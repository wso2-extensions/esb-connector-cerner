/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.connector.integration.test.cerner;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Integration test
 */
public class CernerConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> eiRequestHeadersMap = new HashMap<String, String>();
    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {
        String connectorName = System.getProperty("connector_name") + "-connector-" +
                System.getProperty("connector_version") + ".zip";
        addCertificatesToEIKeyStore("client-truststore.jks", "wso2carbon");
        init(connectorName);
        getApiConfigProperties();
        eiRequestHeadersMap.put("Accept-Charset", "UTF-8");
        eiRequestHeadersMap.put("Content-Type", "application/json+fhir");
        eiRequestHeadersMap.put("Authorization", "Bearer " + connectorProperties.getProperty("accessToken"));
        eiRequestHeadersMap.put("Accept", "application/json+fhir");
        apiRequestHeadersMap.putAll(eiRequestHeadersMap);
    }

    /**
     * Positive test case for getConformance method with mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {getConformance} integration test with mandatory parameters.")
    public void getConformanceWithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:getConformance");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "getConformance.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/metadata";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
    }

    /**
     * Positive test case for readSpecificResourceById method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {readSpecificResourceById} integration test with Mandatory parameters.")
    public void readSpecificResourceByIdWithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:retrieveById");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "readSpecificResourceById.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/" + connectorProperties.getProperty("type") + "/" + connectorProperties.getProperty("id");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getString("id"),
          eiRestResponse.getBody().getString("id"));
    }

    /**
     * Positive test case for searchSpecificResourceById method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchSpecificResourceById} integration test with Mandatory parameters.")
    public void searchSpecificResourceByIdWithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchById");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchSpecificResourceById.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/" + connectorProperties.getProperty("type") + "?_id=" + connectorProperties.getProperty("id");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
          eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchPatient method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchPatient} integration test with Optional parameters.")
    public void searchPatientWithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchPatient");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchPatient.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/" + connectorProperties.getProperty("type") +
                "?given=" + connectorProperties.getProperty("patientGivenName") + "&birthdate=eq" + connectorProperties.getProperty("patientBirthdate");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("birthDate"),
          eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("birthDate"));
    }

    /**
     * Positive test case for searchAppointment method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchAppointment} integration test with Optional parameters.")
    public void searchAppointmentWithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchAppointment");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchAppointment.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Appointment" +
                "?patient=" + connectorProperties.getProperty("patient") + "&date=" + connectorProperties.getProperty("appointmentDate");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));

    }

    /**
     * Positive test case for searchCondition method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchCondition} integration test with Optional parameters.")
    public void searchConditionWithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchCondition");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchCondition.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Condition" +
                "?patient=" + connectorProperties.getProperty("patient") + "&category=" + connectorProperties.getProperty("conditionCategory");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getJSONObject("patient").getString("display"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getJSONObject("patient").getString("display"));

    }

    /**
     * Positive test case for searchEncounter method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchEncounter} integration test with Mandatory parameters.")
    public void searchEncounterwithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchNewEncounter");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchNewEncounter.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Encounter" +
                "?patient=" + connectorProperties.getProperty("patient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"));

    }

    /**
     * Positive test case for searchMedicationStatement method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchMedicationStatement} integration test with optional parameters.")
    public void searchMedicationStatementwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchMedicationStatement");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchMedicationStatement.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/MedicationStatement" +
                "?patient=" + connectorProperties.getProperty("patient") + "&status=" + connectorProperties.getProperty("status");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("dateAsserted"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("dateAsserted"));

    }

    /**
     * Positive test case for searchObservation method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchObservation} integration test with optional parameters.")
    public void searchObservationwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchObservation");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchObservation.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Observation" +
                "?patient=" + connectorProperties.getProperty("patient") + "&_lastUpdated=ge" + connectorProperties.getProperty("initialDateOfLastUpdate");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"));
    }

    /**
     * Positive test case for searchSchedule method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchSchedule} integration test with mandatory parameters.")
    public void searchSchedulewithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchSchedule");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchSchedule.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Schedule" +
                "?_id=" + connectorProperties.getProperty("scheduleId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchGoal method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchGoal} integration test with optional parameters.")
    public void searchGoalwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchGoal");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchGoal.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Goal" +
                "?patient=" + connectorProperties.getProperty("patient") + "&targetDate=" + connectorProperties.getProperty("startDate") + "&targetDate=" +
                connectorProperties.getProperty("endDate");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("targetDate"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("targetDate"));
    }

    /**
     * Positive test case for searchAllergyIntolerance method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchAllergyIntolerance} integration test with optional parameters.")
    public void searchAllergyIntolerancelwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchAllergyIntolerance");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchAllergyIntolerance.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/AllergyIntolerance" +
                "?patient=" + connectorProperties.getProperty("patient") + "&status=" + connectorProperties.getProperty("status");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"));
    }

    /**
     * Positive test case for searchCarePlan method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchCarePlan} integration test with optional parameters.")
    public void searchCarePlanwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchCarePlan");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchCarePlan.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/CarePlan" +
                "?patient=" + connectorProperties.getProperty("patient") + "&category=" + connectorProperties.getProperty("carePlanCategory");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchContract method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchContract} integration test with optional parameters.")
    public void searchContractwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchContract");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchContract.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Contract" +
                "?subject:Patient=" + connectorProperties.getProperty("contractSubject");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchDevice method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchDevice} integration test with optional parameters.")
    public void searchDevicewithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchDevice");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchDevice.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Device" +
                "?patient=" + connectorProperties.getProperty("patientDevice");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchDiagnosticReport method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchDiagnosticReport} integration test with optional parameters.")
    public void searchDiagnosticReportwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchDiagnosticReport");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchDiagnosticReport.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/DiagnosticReport" +
                "?patient=" + connectorProperties.getProperty("patient") + "&subject:Patient=" + connectorProperties.getProperty("subjectPatient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchImmunization method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchImmunization} integration test with mandatory parameters.")
    public void searchImmunizationwithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchImmunization");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchImmunization.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Immunization" +
                "?patient=" + connectorProperties.getProperty("patient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchBinary method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchBinary} integration test with mandatory parameters.")
    public void searchBinarywithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchBinary");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchBinary.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Binary" + "/$autogen-ccd-if" +
                "?patient=" + connectorProperties.getProperty("patient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
    }

    /**
     * Positive test case for searchDocumentReference method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchDocumentReference} integration test with mandatory parameters.")
    public void searchDocumentReferencewithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchDocumentReference");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchDocumentReference.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/DocumentReference" +
                "?patient=" + connectorProperties.getProperty("patient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"));
    }

    /**
     * Positive test case for searchMedicationAdministration method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchMedicationAdministration} integration test with optional parameters.")
    public void searchMedicationAdministrationwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchMedicationAdministration");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchMedicationAdministration.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/MedicationAdministration" +
                "?patient=" + connectorProperties.getProperty("patient") + "&status=" + connectorProperties.getProperty("medicationAdminStatus");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"));
    }

    /**
     * Positive test case for searchMedicationOrder method with Optional parameters.
     */
    @Test(enabled = true, description = "cerner {searchMedicationOrder} integration test with optional parameters.")
    public void searchMedicationOrderwithOptionalParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchMedicationOrder");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchMedicationOrder.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/MedicationOrder" +
                "?patient=" + connectorProperties.getProperty("patient") + "&status=" + connectorProperties.getProperty("status");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchPractitioner method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchPractitioner} integration test with mandatory parameters.")
    public void searchPractitionerwithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchPractitioner");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchPractitioner.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Practitioner" +
                "?_id=" + connectorProperties.getProperty("practitionerId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
    }

    /**
     * Positive test case for searchProcedure method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchProcedure} integration test with mandatory parameters.")
    public void searchProcedurewithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchProcedure");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchProcedure.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Procedure" +
                "?patient=" + connectorProperties.getProperty("patient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("status"));
    }

    /**
     * Positive test case for searchRelatedPerson method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchRelatedPerson} integration test with mandatory parameters.")
    public void searchRelatedPersonwithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchRelatedPerson");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchRelatedPerson.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/RelatedPerson" +
                "?patient=" + connectorProperties.getProperty("patient");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }

    /**
     * Positive test case for searchSlot method with Mandatory parameters.
     */
    @Test(enabled = true, description = "cerner {searchSlot} integration test with mandatory parameters.")
    public void searchSlotwithMandatoryParameters() throws IOException, JSONException {
        eiRequestHeadersMap.put("Action", "urn:searchSlot");
        RestResponse<JSONObject> eiRestResponse = sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "searchSlot.json");
        final String apiEndPoint = connectorProperties.getProperty("base") + "/Slot" +
                "?_id=" + connectorProperties.getProperty("slotId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200,"Invalid parameter value");
        Assert.assertEquals(apiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"),
                eiRestResponse.getBody().getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getString("id"));
    }
}