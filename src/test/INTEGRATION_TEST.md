
## Integration tests for WSO2 EI cerner connector through Cerner API

### Pre-requisites:
   - Maven 3.x
   - Java 1.8

### Tested Platforms:
   -  Ubuntu 16.04
   -  WSO2 EI 6.4.0

### Steps to follow in setting integration test.
   
   1. Download EI 6.4.0  by navigating to the following [URL](http://wso2.com/products/enterprise-service-bus/#).
   2. Copy the EI 6.4.0 zip to the location `Connector_Home/repository/`

   3. Enable the following message formatter and message builder in the WSO2 EI axis2.xml
   ```xml
    <messageFormatter contentType="application/json+fhir" class="org.apache.synapse.commons.json.JsonStreamFormatter"/>
   ```
   ```xml
    <messageBuilder contentType="application/json+fhir" class="org.apache.synapse.commons.json.JsonStreamBuilder"/>
   ```
   4. Extract the certificate from browser by navigating to the official cerner sandbox URL<https://fhir-open.sandboxcerner.com/dstu2/> and place it to `Connector_Home/repository/`.
    
   5. Update the following properties in `esb-connector-cerner.properties` file at `Connector_Home/repository/`
            base, accessToken
   6. Update connector properties file `cerner.properties` located in `CERNER_HOME/src/test/resources/artifacts/ESB/connector/config/`,
   with relevant information.

| Property | Description |
|----------|------------|
| base | The base url|
| accessToken | The access token received through cerner registered app or secure sandbox.(It is not necessary to fill this, if open sandbox is used as the base URL)|
| type | The type of the resource (Patient).|
| id | The resource Id.|
| patient | The patient Id.|
| subjectPatient | The patient subject Id.|
| PatientBirthdate |  Patient Birthdate.|
| PatientGivenName |  Patient given name.|
| AppointmentDate | start date of the appointment.|
| ConditionCategory | Category of the condition.|
| InitialDateOfLastUpdate | Initial date from the date-range in which the update has been made.|
| status | The status (active)|
| scheduleId | The schedule Id.|
| startDate | start date from the date-range.|
| endDate | end date from the date-range.|
| patientDevice | Patient Id of the person with implanted device|
| carePlanCategory | careplan category- assess-plan|
| contractSubject | contract subject Id.|
| practitionerId | Practitioner Id.|
| slotId | Slot Id|
| medicationAdminStatus | Medication Administration status|


7. Navigate to `CERNER_HOME` and run the following command.

```console
$ mvn clean install -Dskip-tests=false
```
