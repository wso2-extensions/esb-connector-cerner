
### Product: Integration tests for WSO2 ESB cerner connector through REST API

**Pre-requisites:**
   - Maven 3.x
   - Java 1.8

**Tested Platform:**
   -  ubuntu 16.04
   -  WSO2 EI 6.3.0

   Steps to follow in setting integration test.
   
   1. Download WSO2 EI 6.3.0 from official website and place the WSO2 EI 6.3.0 zip to {EI_Connector_Home}/repository/.

   2. Enable the following message formatter and message builder in the WSO2 EI axis2.xml
   ```xml
    <messageFormatter contentType="application/json+fhir" class="org.apache.synapse.commons.json.JsonStreamFormatter"/>
   ```
   ```xml
    <messageBuilder contentType="application/json+fhir" class="org.apache.synapse.commons.json.JsonStreamBuilder"/>
   ```
   3. Extract the certificate from browser by navigating to the official cerner sandbox URL<https://fhir-open.sandboxcerner.com/dstu2/> and place it to {EI_Connector_Home}/repository/.

   4. Update connector properties file "cerner.properties" located in "CERNER_HOME/src/test/resources/artifacts/ESB/connector/config/",
   with relevant information.

1) base: The base url
2) type: The type of the resource (Patient)
3) id:  The resource Id
4) patient:  The patient Id
5) subjectPatient: The patient subject Id.
6) PatientBirthdate:  Patient Birthdate.
7) PatientGivenName:  Patient given name.
8) AppointmentDate:  start date of the appointment.
9) ConditionCategory:  Category of the condition.
10) InitialDateOfLastUpdate:  Initial date from the date-range in which the update has been made.
11) appointmentType: Appointment resource Type (Appointment)
12) conditionType: Condition resource Type (Condition)
13) encounterType: Encounter resource Type (Encounter)
14) medicationStatementType: MedicationStatement resource Type (MedicationStatement)
15) status: The status (active)
16) observationType: Observation resource Type (Observation)
17) scheduleId: The schedule Id
18) scheduleType: Schedule resource Type. (Schedule)
19) startDate: start date from the date-range.
20) endDate: end date from the date-range.
21) goalType: Goal resource Type (Goal)
22) allergyType: AllergyIntolerance resource Type ( AllergyIntolerance)
23) allergyStatus: Allergy status (Confirmed)
24) carePlanType: CarePlan resource Type (CarePlan)
25) carePlanCategory: careplan category- assess-plan
26) contractType: Contract resource type (Contract)
27) contractSubject: contract subject Id.
28) deviceType: Device resource Type(Device)
29) diagnosticReportType: DiagnosticReport resource Type (DiagnosticReport)
30) immunizationType: Immunization resource Type (Immunization)
31) binaryType: Binary resource Type (Binary)
32) documentReferenceType: DocumentReference resource type (  DocumentReference)
33) medicationAdministrationType: MedicationAdministration resource type (MedicationAdministration)
34) medicationOrderType: MedicationOrder resource type (MedicationOrder )
35) practitionerType: Practitioner resource type (Practitioner)
36) practitionerId: Practitioner Id.
37) procedureType: Procedure resource Type (Procedure)
38) relatedPersonType: RelatedPerson resource Type (RelatedPerson )
39) slotType: Slot resource type (Slot)
40) slotId: Slot Id

5.Navigate to "{CERNER_HOME}" and run the following command.

```console
$ mvn clean install -Dskip-tests=false
```
