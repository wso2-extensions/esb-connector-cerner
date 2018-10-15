# Working with the Cerner Connector
[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview
The following operations allow you to work with the cerner connector. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with the cerner connector, see [Sample configuration](#sample-configuration).


| Operation        | Description |
| ------------- |-------------|
| [retrieveById](#retrieve-a-specific-resource-by-its-id) | Read a specific Resource By the provided Id.|
| [create](#create-a-specific-resource) | Create a new Resource in the server specified location.|
| [update](#update-a-specific-resource) | Update a specific resource.|
| [searchAllergyIntolerance](#search-allergy-intolerance-of-a-patient) | Search clinical assessment of a patient's allergy or intolerance.|
| [searchAppointment](#search-appointments-scheduled)  | Search information of scheduled appointments.|
| [searchBinary](#search-binary-document)  | Search  clinical content such as text, images, and PDFs.|
| [searchById](#search-a-specific-resource-by-id)  | Search a specific Resource By ID.|
| [searchCarePlan](#search-care-plan-for-a-patient)  |Search Care plan resource by user provided parameters.|
| [searchCondition](#search-condition-of-a-patient)  | Search Medical condition of a patient.|
| [searchContract](#search-contract)  | Search contracted people who are authorized to view patient details.|
| [SearchDevice](#search-implanted-device-details)  | Search implanted device history of a patient.|
| [searchDiagnosticReport](#search-diagnostic-reports-of-a-patient)  | Search information on diagnostic report and procedures.|
| [searchDocumentReference](#search-document-reference)  | Search clinical documents and reference to retrieve them.|
| [searchGoal](#search-goal)  | Search intended objectives for a patient.|
| [searchImmunization](#search-immunization-for-a-patient)  | Search current and historical administration of vaccinations.|
| [searchMedicationAdministration](#search-medication-administration-of-a-patient)  | Search Medications and vaccines administrated to a patient.|
| [searchMedicationOrder](#search-medication-order)  | Search orders for all medications along with administration instructions.|
| [searchMedicationStatement](#search-medication-statement)  | Search medications taken by the patient now or in the past.|
| [searchNewEncounter](#search-encounter)  | Search admissions or visits during which health care services were provided to a patient.|
| [searchObservation](#search-observation)  |Search measurements or simple assertions about a patient.|
| [searchPatient](#search-patient)  | Search about a person receiving health care services from a specific organization.|
| [searchPractitioner](#search-practitioner)  | Search information about a person formally involved in the care of a patient.|
| [searchProcedure](#search-procedure)  | Search current and historical procedures performed on a patient.|
| [searchRelatedPerson](#search-related-person-of-a-patient)  | Search information about a person who is involved in the care of a patient but has no formal responsibility|
| [searchSchedule](#search-schedule)  | Search  time slots which are defined for booking an appointment.|
| [searchSlot](#search-slot)  | Search time slots from a schedule which are available for booking an appointment.|




## Operation details
This section provides details on each of the operations.

## Retrieve a specific resource by its Id
This retrieveById operation reads a resource based on the Id you provide.

**retrieveById**
```xml
<cerner.retrieveById>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
</cerner.retrieveById>
```
**Properties**
* base: The service root URL.
* type: The type of the resource that is needed to be retrieved.
* Id: The logical Id of the resource.

**Sample request**

Following is a sample REST request that can be handled by the retrieveById operation.
```
{
 "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/",
 "type": “Patient",
 "id": "4342008"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/individuals/patient/#retrieve-by-id](https://fhir.cerner.com/millennium/dstu2/individuals/patient/#retrieve-by-id)

## Create a specific resource
The create operation creates a specific resource in the server specified location.

**Create**
```xml
<cerner.create>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
</cerner.create>
```

**Properties**
* base: The service root URL.
* type: The type of the resource.

**Sample request**

Following is a sample REST request that can be handled by the Create operation.

```
{
 "base": “https://fhir-ehr.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/",
 "type": “Patient"
}
```

**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/individuals/patient/#create](https://fhir.cerner.com/millennium/dstu2/individuals/patient/#create)

## Update a specific resource
The update operation updates a specific resource in the server specified location.

**Update**
```xml
<cerner.update>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
 </cerner.update>
```

**Properties**
* base: The service root URL.
* type: The type of the resource that is needed to be updated.
* id: The logical Id of the resource.

**Sample request**

Following is a sample REST request that can be handled by the Update operation.

```
{
 "base": “https://fhir-ehr.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
 "type": “Appointment",
 "id": "1620549"
}
```

**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/scheduling/appointment/#update](https://fhir.cerner.com/millennium/dstu2/scheduling/appointment/#update)

## Search Allergy Intolerance of a patient
The searchAllergyIntolerance operation search Allergy intolerance reports of a particular patient.

**searchAllergyIntolerance**
```xml
<cerner.searchAllergyIntolerance>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
    <status>{$ctx:status}</status>
</cerner.searchAllergyIntolerance>

```
**Properties**
* base: The service root URL.
* type: The type of the resource.
* id: The logical Id of the Allergy Intolerance.
* patient: patient who the sensitivity is for.
* status[optional]: The certainty of the allergy or intolerance,Example: confirmed.

>Note: One of the id or patient must be provided.

**Sample request**

Following is a sample REST request that can be handled by the searchAllergyIntolerance operation.
```
{
 "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/",
 "type": “AllergyIntolerance",
 "id": "5703737",
 "status":"active"
}
```

**Related cerner documentation**

[https://fhir.cerner.com/millennium/dstu2/general-clinical/allergy-intolerance/#search](https://fhir.cerner.com/millennium/dstu2/general-clinical/allergy-intolerance/#search)
 
## Search Appointments scheduled
The Appointment operation provides information about scheduled appointments.

**searchAppointment**
```xml
<cerner.searchAppointment>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <date>{$ctx:date}</date>
    <startDate>{$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
    <patient>{$ctx:patient}</patient>
    <practitioner>{$ctx:practitioner}</practitioner>
    <location>{$ctx:location}</location>
    <status>{$ctx:status}</status>
    <count>{$ctx:count}</count>
</cerner.searchAppointment>
```
**Properties**
* base: The service root URL.
* type: The type of the resource.
* id: The logical resource id associated with the resource
* date: The Appointment date/time, if user specify the startDate and endDate, this parameter should not be used.
* startDate: starting date of the Appointment(when searched using date range).
* endDate: end date of the Appointment(when searched using date range).
* patient: A single or comma separated list of Patient references.
* practitioner: A single or comma separated list of Practitioner references.
* location: A single or comma separated list of Location references.
* status[optional]: A single or comma separated list of appointment statuses
* count[optional]: The maximum number of results to return.

>Note: id or one of patient, practitioner, or location must be provided.

**Sample request**

Following is a sample REST request that can be handled by the searchAppointment operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Appointment",
  "id": "3005756",
  "date": "2017-10-04T08:00:00.000-05:00",
  "status": "booked",
  "count": "5"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/scheduling/appointment/#search](https://fhir.cerner.com/millennium/dstu2/scheduling/appointment/#search)

## Search Binary document

The search Binary operation contain any clinical content such as text, images, and PDFs.

**searchBinary**
```xml
 <cerner.searchBinary>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <patient>{$ctx:patient}</patient>
    <start>{$ctx:start}</start>
    <end>{$ctx:end}</end>
 </cerner.searchBinary>
```
**Properties**
* base: The service root URL.
* type: The type of the resource.
* patient: A reference to the patient that is the subject of the CCD.
* start[optional]: The start of the date range for which the CCD is to be generated.
* end[optional]: The end of the date range for which the CCD is to be generated.

**Sample request**

Following is a sample REST request that can be handled by the searchBinary operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Binary",
  "patient": "1316035",
  "start": "2014-09-24T12:00:00.000Z",
  "end": "2016-09-24T12:00:00.000Z"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/infrastructure/binary/#autogen-ccd-if](https://fhir.cerner.com/millennium/dstu2/infrastructure/binary/#autogen-ccd-if)

## Search a specific resource by Id
The search by Id operation allows to search a specific resource by its Id.

**searchById**
```xml
 <cerner.searchById>
     <base>{$ctx:base}</base>
     <type>{$ctx:type}</type>
     <id>{$ctx:id}</id>
 </cerner.searchById>
 ```

**Properties**
* base: The service root URL.
* type: The type of the resource.
* id: The logical Id of the resource.

**Sample request**

Following is a sample REST request that can be handled by the searchById operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Patient",
  "id": "1316035"
}
```

## Search Care Plan for a patient
The searchCarePlan Operations allows user to search on how one or more practitioners plan to deliver care to a specific patient.

**searchCarePlan**
```xml
<cerner.searchCarePlan>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
    <startDate>{$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
    <category>{$ctx:category}</category>
    <count>{$ctx:count}</count>
    <subject>{$ctx:subject}</subject>
    <context>{$ctx:context}</context>
</cerner.searchCarePlan>
```

**Properties**
* base: The service root URL.
* type: The type of the resource.
* id: The logical resource id associated with the resource.
* patient: Who care plan is for.
* startDate[optional]: starting date of the carePlan.
* endDate[optional]: end date of the carePlan.
* category[optional]: The scope of care plan being searched for
* count[optional]: Number of results per page.
* subject: Who care plan is for.
* context[optional]: The encounter id of the care plan.

>Note: id or one of patient or subject must be provided.

**Sample request**

Following is a sample REST request that can be handled by the searchCarePlan operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "CarePlan",
  "patient": "1316020",
  "category": "assess-plan"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/care-provision/care-plan/#search](https://fhir.cerner.com/millennium/dstu2/care-provision/care-plan/#search)


## Search Condition of a patient
The search Condition operation search record details about a patient’s problems, diagnoses, or other health matters that are concerning.

**searchCondition**
```xml
<cerner.searchCondition>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
    <category>{$ctx:category}</category>
    <clinicalstatus>{$ctx:clinicalstatus}</clinicalstatus>
</cerner.searchCondition>
```
**Properties**
* base: The service root URL.
* type: The type of the resource.
* id: The logical resource id associated with the resource. 
* Patient: The patient who has the condition.
* Category[optional]: The category of the condition. Example: diagnosis, problem, health-concern.
* clinicalStatus[optional]: The clinical status of the condition.

**Sample request**

Following is a sample REST request that can be handled by the searchCondition operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Condition",
  "patient": "4342012"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/general-clinical/condition/#search](https://fhir.cerner.com/millennium/dstu2/general-clinical/condition/#search)


## Search Contract
The search Contract operation search people who are authorized to view a patient’s data. Eg: Mother(actor) has the authorization to view her child’s(subject) data. 

**searchContract**
```xml
<cerner.searchContract>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <subject>{$ctx:subject}</subject>
    <actor>{$ctx:actor}</actor>
    <actor.identifier>{$ctx:actor.identifier}</actor.identifier>
    <patient.identifier>{$ctx:patient.identifier}</patient.identifier>
    <include>{$ctx:include}</include>
</cerner.searchContract>
```
**Properties**
* base: The service root URL.
* type: The type of the resource.
* id: The logical resource id associated with the resource.
* actor: The actor (RelatedPerson) of the Contract,Eg: mother.
* actorIdentifier: The identifier for the actor of the Contract.
* patientIdentifier: The identifier for the patient subject of the Contract.
* subject: Subject of the contract (patient).
* includeActor[optional]: Actor resource entry to be returned as part of the response.
* includePatient[optional]: Patient resource entry to be returned as part of the response.

>Note:Either the _id or one of actor, actor.identifier, patient.identifier, or subject parameters must be provided.

**Sample request**

Following is a sample REST request that can be handled by the searchContract operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Contract",
  "subject": "4598008"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/entities/contract/#search](https://fhir.cerner.com/millennium/dstu2/entities/contract/#search)

## Search implanted device details
The search Device operation search the known history of implanted devices on a patient.

**searchDevice**
```xml
<cerner.searchDevice>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
</cerner.searchDevice>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Device).
* id: The logical resource id associated with the Device.
* patient: The patient on whom the device is implanted.

**Sample request**

Following is a sample REST request that can be handled by the searchDevice operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Device",
  "patient": "4478007"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/devices/device/#search](https://fhir.cerner.com/millennium/dstu2/devices/device/#search)

## Search Diagnostic Reports of a patient
The search Diagnostic report operation allows user to find information about the diagnostic test carried out and procedures such as Radiology or Pathology report.

**SearchDiagnosticReport**
```xml
<cerner.searchDiagnosticReport>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <patient>{$ctx:patient}</patient>
    <subject>{$ctx:subject}</subject>
    <startDate>$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
    <count>{$ctx:count}</count>
</cerner.searchDiagnosticReport>
```
**Properties**
* base: The service root URL.
* Type: Type of the resource (DiagnosticReport).
* Patient: The patient whos diagnostic report belong to.
* subject: The subject (Patient) of the report.
* startDate[optional]: starting date of the report.
* endDate[optional]: end date of the report.
* count[optional]: The maximum number of results to return per page.

**Sample request**

Following is a sample REST request that can be handled by the SearchDiagnosticReport operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "DiagnosticReport",
  "patient": "1316020",
  "count": "10"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/diagnostic/diagnostic-report/#search](https://fhir.cerner.com/millennium/dstu2/diagnostic/diagnostic-report/#search)

## Search Document Reference
The search Document reference operation will search clinical documents of a patient and return those docuemnts along with a reference to them.

**SearchDocumentReference**
```xml
<cerner.searchDocumentReference>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
    <subject>{$ctx:subject}</subject>
    <encounter>{$ctx:encounter}</encounter>
    <createdEarliest>{$ctx:createdEarliest}</createdEarliest>
    <createdLatest>{$ctx:createdLatest}</createdLatest>
    <count>{$ctx:count}</count>
</cerner.searchDocumentReference>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (DiagnosticReport).
* id: The logical resource id associated with the resource.
* patient: The patient to which the document reference belongs. 
* subject: The subject of the document reference. (Patient resource).
* encounter[optional]: The encounter to which the document reference belongs(Encounter resource).
* createdEarliest[optional]: The start date/time the referenced document was created. 
* createdLatest[optional]:  The end date/time the referenced document was created.
* count[optional]: The maximum number of results to return.

**Sample request**

Following is a sample REST request that can be handled by the SearchDocumentReference operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "DocumentReference",
  "patient": "1316024",
  "createdEarliest": "2016-01-06",
  "createdLatest": "2016-01-07"
}
```
>Note:id, or one of patient or subject must be provided.

**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/infrastructure/document-reference/#search](https://fhir.cerner.com/millennium/dstu2/infrastructure/document-reference/#search)

## Search Goal
search Goal operation will search and respond with desired outcome or health state to be achieved by a patient over a period or at a specific point in time. 

**searchGoal**
```xml
<cerner.searchGoal>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <subject>{$ctx:subject}</subject>
    <patient>{$ctx:patient}</patient>
    <startDate>{$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
</cerner.searchGoal>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Goal).
* id : The logical resource id associated with the resource.
* patient: The patient who has the goal.
* subject: The subject who this goal is intended for. Must represent a Patient resource.
* startDate[optional]: start date of the date range which to find goals.
* endDate[optional]: end date of the date range which to find goals.

**Sample request**

Following is a sample REST request that can be handled by the SearchGoal operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Goal",
  "patient": "685925",
  "startDate": "2016-11-09",
  "endDate": "2016-11-30"
}
```
>Note:The _id parameter may not be provided at the same time as the patient, subject,startDate and endDate parameters.

**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/care-provision/goal/#search](https://fhir.cerner.com/millennium/dstu2/care-provision/goal/#search)

## Search Immunization for a patient
The search Immunization resource will return historical administration of vaccinations to a patient in all healthcare settings.
Immunization resource would represent the known vaccination history regardless of where the administration itself was done.

**searchImmunization**
```xml
<cerner.searchImmunization>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <patient>{$ctx:patient}</patient>
    <earliestDate>{$ctx:earliestDate}</earliestDate>
    <latestDate>{$ctx:latestDate}</latestDate>
</cerner.searchImmunization>
```

**Properties**
* base: The service root URL.
* type: Type of the resource (Immunization).
* patient: The patient for the vaccination record.
* earliestDate[optional]: Earliest date of the Date range which the immunization administration date falls.
* latestDate[optional]: The Latest date of the Date range which the immunization administration date falls.

**Sample request**

Following is a sample REST request that can be handled by the SearchImmunization operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Immunization",
  "patient": "4478007",
  "earliestDate": "2015-01-01",
  "latestDate": "2016-11-30"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/medications/immunization/#search](https://fhir.cerner.com/millennium/dstu2/medications/immunization/#search)

## Search Medication Administration of a patient
The search Medication administration operation search the information about medications and vaccines administered to a patient or consumed by a patient including injections, intravenous solutions, and self administered oral medications. 

**searchMedicationAdministration**
```xml
<cerner.searchMedicationAdministration>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
    <status>{$ctx:status}</status>
    <practitioner>{$ctx:practitioner}</practitioner>
    <notGiven>{$ctx:notGiven}</notGiven>
    <startEffectiveTime>{$ctx:startEffectiveTime}</startEffectiveTime>
    <endEffectiveTime>{$ctx:endEffectiveTime}</endEffectiveTime>
    <count>{$ctx:count}</count>
</cerner.searchMedicationAdministration>
```

**Properties**
* base: The service root URL.
* type: Type of the resource (MedicationAdministration).
* id: The id of the resource type.
* patient: The patient who has received the medication administration.
* status[optional]: The status of the medication administration.
* practitioner[optional]: The performing clinician.
* notGiven[optional]: Administrations that were not made.
* startEffectiveTime[optional]: The  start date/time from the date-range in which the administration was performed.
* endEffectiveTime[optional]: The date/time from the date-range in which the administration was performed.
* count[optional]: The maximum number of results to return.

**Sample request**

Following is a sample REST request that can be handled by the searchMedicationAdministration operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "MedicationAdministration",
  "patient": "4642007",
  "status": "in-progress",
  "Practitioner": "1776007"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/medications/medication-administration/#search](https://fhir.cerner.com/millennium/dstu2/medications/medication-administration/#search)

## Search Medication Order 
The search Medication order operation search the  all medications along with administration instructions for a patient in both the inpatient and outpatient setting (orders/prescriptions filled by a pharmacy and discharge medication orders).
Based on the parameters provided by the user, the medication order will be returned.

**searchMedicationOrder**
```xml
<cerner.searchMedicationOrder>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <patient>{$ctx:patient}</patient>
    <status>{$ctx:status}</status>
    <timingBoundsPeriod>{$ctx:timingBoundsPeriod}</timingBoundsPeriod>
    <earliestLastUpdate>{$ctx:earliestLastUpdate}</earliestLastUpdate>
    <latestLastUpdate>{$ctx:latestLastUpdate}</latestLastUpdate>
    <count>{$ctx:count}</count>
</cerner.searchMedicationOrder>
```

**Properties**
* base: The service root URL.
* type: Type of the resource (MedicationOrder).
* patient: The identity of a patient to list orders for.
* status[optional]: The status of the medication administration
* timingBoundsPeriod[optional]: The date-time which should fall within the period the medication should be given to the patient
* earliestLastUpdate[optional]: The start Date of the date-range within which the most recent clinically relevant update was made to the medication. 
* latestLastUpdate[optional]: The end Date within which the most recent clinically relevant update was made to the medication. 
* count[optional]: The maximum number of results to return

**Sample request**

Following is a sample REST request that can be handled by the searchMedicationOrder operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "MedicationOrder",
  "patient": "4342010",
  "status": "active"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/medications/medication-order/#search](https://fhir.cerner.com/millennium/dstu2/medications/medication-order/#search)


## Search Medication statement
The search Medication statement will provide a report of medications taken by the patient now or in the past, the report is based on the record kept by either the patient , siginificant other or the provider.

**searchMedicationStatement**
```xml
<cerner.searchMedicationStatement>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
    <status>{$ctx:status}</status>
    <count>{$ctx:count}</count>
</cerner.searchMedicationStatement>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (MedicationStatement).
* id: The logical resource id associated with the resource.
* patient: The identifier of a patient to list statements for.
* status[optional]: The status of the medication statement.
* count[optional]: The maximum number of results to return.

**Sample request**

Following is a sample REST request that can be handled by the searchMedicationStatement operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "MedicationStatement",
  "id": "21389901",
  "status": "active"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/medications/medication-statement/#search](https://fhir.cerner.com/millennium/dstu2/medications/medication-statement/#search)


## Search Encounter
The search NewEncounter operation provides the user to check on the admissions and visits done by a patient, which can be inpatient,outpatient, emergency etc.

**searchNewEncounter**
```xml
<cerner.searchNewEncounter>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <patient>{$ctx:patient}</patient>
</cerner.searchNewEncounter>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Encounter).
* id: The logical resource id associated with the resource.
* patient: The patient present at the encounter.

**Sample request**

Following is a sample REST request that can be handled by the searchNewEncounter operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Encounter",
  "patient": "4342010"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/encounters/encounter/#search](https://fhir.cerner.com/millennium/dstu2/encounters/encounter/#search)

## Search Observation
The Search Observation operation provides the user to check on the measurements or simple assertions about a patient.The obeservation will include  blood pressure, laboratory results ,Vital signs etc. These observation help in supporting diagnoses, monitoring progress, and establishing baselines or trends.

**searchObservation**
```xml
<cerner.searchObservation>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <patient>{$ctx:patient}</patient>
    <subject>{$ctx:subject}</subject>
    <code>{$ctx:code}</code>
    <startDate>{$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
    <initialDateOfLastUpdate>{$ctx:initialDateOfLastUpdate}</initialDateOfLastUpdate>
    <endDateOfLastUpdate>{$ctx:endDateOfLastUpdate}</endDateOfLastUpdate>
    <category>{$ctx:category}</category>
    <count>{$ctx:count}</count>
</cerner.searchObservation>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Observation).
* patient: The subject that the observation is about.
* subject: The subject (Patient) of the observation.
* code[optional]: The code or component-code of the observation type.
* startDate[optional]: start date when considering the observation range.
* endDate[optional]: end date when considering the observation range.
* initialDateOfLastUpdate[optional]: First day from the date-range in which the update has done.
* endDateOfLastUpdate[optional]: Last date from the date-range in which the update has done.
* category[optional]: The category of observations.
* count[optional]: The maximum number of results to return per page.

**Sample request**

Following is a sample REST request that can be handled by the searchObservation operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Observation",
  "patient": "3998008",
  "code": "229819007",
  "startDate": "2014-09-24",
  "endDate": "2016-10-12"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/diagnostic/observation/#search](https://fhir.cerner.com/millennium/dstu2/diagnostic/observation/#search)

## Search Patient
The search Patient operation will let the user to search a patient based on the parameters provided.Patient resource will contain demographic information about a person receiving health care services from a specific organization.

**searchPatient**
```xml
<cerner.searchPatient>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <identifier>{$ctx:identifier}</identifier>
    <name>{$ctx:name}</name>
    <family>{$ctx:family}</family>
    <phone>{$ctx:phone}</phone>
    <birthdate>{$ctx:birthdate]</birthdate>
    <given>{$ctx:given}</given>
    <email>{$ctx:email}</email>
    <gender>{$ctx:gender}</gender>
    <addressPostalCode>{$ctx:addressPostalCode}</addressPostalCode>
    <count>{$ctx:count}</count>
</cerner.searchPatient>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Patient).
* id:The logical resource id associated with the resource.
* identifier: A patient identifier.
* name: The start of either family or given name of the patient.
* family: The start of the family name of the patient.
* phone: The patient’s phone number. 
* birthdate: The patient’s date of birth
* given: The start of the given name of the patient.
* email: The patient’s email address.
* gender[optional]: The gender of the patient.
* addressPostalCode: The postal code in the address details of the patient
* count[optional]: The maximum number of results to return.

**Sample request**

Following is a sample REST request that can be handled by the searchPatient operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Patient",
  "id": "4342009"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/individuals/patient/#search](https://fhir.cerner.com/millennium/dstu2/individuals/patient/#search)

## Search Person 
The search Person operation provides details about an individual who does not belong to the respective health care context ,but provide mechanism to link person resources across different facilities or organizations.

**searchPerson**
```xml
<cerner.searchPerson>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <identifier>{$ctx:identifier}</identifier>
</cerner.searchPerson>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Person).
* id: The logical resource id associated with the resource.
* identifier: The person identifier.

**Sample request**

Following is a sample REST request that can be handled by the searchPerson operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Person",
  "identifier": "urn%3Aoid%3A2.16.840.1.113883.3.13.6%7Curn%3Acerner%3Aidentity-federation%3Arealm%3A687f29dd-69dd-4de5-acb1-fd8a2241ef3a%3Aprincipal%3AEC4Ax54P8GI"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/entities/person/#search](https://fhir.cerner.com/millennium/dstu2/entities/person/#search)


## Search Practitioner
The search Practitioner operation provides details about the person who is in involved with the patient behalf of the healthcare facility.

**searchPractitioner**
```xml
<cerner.searchPractitioner>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
</cerner.searchPractitioner>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Practitioner).
* id: The logical resource id associated with the resource.

**Sample request**

Following is a sample REST request that can be handled by the searchPractitioner operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Practitioner",
  "id": "1994021"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/individuals/practitioner/#search](https://fhir.cerner.com/millennium/dstu2/individuals/practitioner/#search)

## Search Procedure
The search Procedure operation will provide a historical and current procedures carried on the patient.The patient gets to decide which procedures are to be sent to the procedure document.

**searchProcedure**
```xml
<cerner.searchProcedure>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <patient>{$ctx:patient}</patient>
    <id>{$ctx:id}</id>
    <subject>{$ctx:subject}</subject>
    <startDate>{$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
</cerner.searchProcedure>
```
**Properties**

* base: The service root URL.
* type: Type of the resource (Procedure).
* id: The logical resource id associated with the resource.
* patient: The patient subject of the Procedure.
* subject: The subject of the Procedure(must be a patient resource).
* startDate[optional]: initial date /starting date of the procedure.
* endDate[optional]: end Date of the procedure.
>Note:The id parameter may not be provided at the same time as the patient, subject, or date parameters.

**Sample request**

Following is a sample REST request that can be handled by the searchProcedure operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Procedure",
  "id": "24110557"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/general-clinical/procedure/#search](https://fhir.cerner.com/millennium/dstu2/general-clinical/procedure/#search)

## Search Related Person of a patient 
The search Related Person operation provides information about a person who is involved in the care of a patient but has no formal responsibility.

**searchRelatedPerson**
 ```xml
<cerner.searchRelatedPerson>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <identifier>{$ctx:identifier}</identifier>
    <patient>{$ctx:patient}</patient>
</cerner.searchRelatedPerson>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (RelatedPerson).
* id: The logical Id of the resource.
* identifier: The RelatedPerson Identifier.
* patient: A reference to a patient related which the RelatedPerson is associated.

**Sample request**

Following is a sample REST request that can be handled by the searchRelatedPerson operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "RelatedPerson",
  "patient": "3838011"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/individuals/related-person/#search](https://fhir.cerner.com/millennium/dstu2/individuals/related-person/#search)

## Search Schedule
The search schedule provide a time period where time slots are defined for booking an appointment.

**searchSchedule**
```xml
<cerner.searchSchedule>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
</cerner.searchSchedule>
```
**Properties**
* base: The service root URL.
* type: Type of the resource (Schedule).
* id: The logical Id of the resource.

**Sample request**

Following is a sample REST request that can be handled by the searchSchedule operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Scehdule",
  "id": "21265426-633867-3121665-0,21265426-633867-3121665-15"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/scheduling/schedule/#search](https://fhir.cerner.com/millennium/dstu2/scheduling/schedule/#search)

## Search Slot
The search slot operation provides time slots from a schedule which are available for booking an appointment. It only provides the availability and time

**searchSlot**
```xml
<cerner.searchSlot>
    <base>{$ctx:base}</base>
    <type>{$ctx:type}</type>
    <id>{$ctx:id}</id>
    <slotType>{$ctx:slotType}</slotType>
    <scheduleActor>{$ctx:scheduleActor}</scheduleActor>
    <location>{$ctx:location}</location>
    <start>{$ctx:start}</start>
    <startDate>{$ctx:startDate}</startDate>
    <endDate>{$ctx:endDate}</endDate>
    <count>{$ctx:count}</count> 
</cerner.searchSlot>
```

**Properties**
* base: The service root URL.
* type: Type of the resource (Slot).
* id: The logical resource id associated with the resource.
* slotType: The type of appointments that can be booked into this slot.
* scheduleActor: A single or comma separated list of Practitioner references.
* location: A single or comma separated list of Location references.
* start: The Slot date-time.
* startDate: The starting date-time of the slot.
* endDate: The end date-time of the slot.
* count[optional]: The maximum number of results to be returned per page.

>Note: If the start parameter is used, it is not necessary to use the startDate and endDate parameters,(as they define the date range of the slot).

**Sample request**

Following is a sample REST request that can be handled by the searchSlot operation.
```
{
  "base": “https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Slot",
  "scheduleActor": "2578010",
  "start": "2016",
  "slotType": "http://snomed.info/sct|394581000",
  "count": "5"
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/scheduling/slot/#search](https://fhir.cerner.com/millennium/dstu2/scheduling/slot/#search)

## Sample Configuration
Following is a sample proxy service that illustrates how to connect to Cerner with the init operation and use the searchAppointment operation. The sample request for this proxy can be found in searchAppointment sample request. You can use this sample as a template for using other operations in this category.

**Sample Proxy**
```xml
<proxy xmlns="http://ws.apache.org/ns/synapse" name="searchAppointment"
       statistics="disable" trace="disable" transports="https,http" startOnLoad="true">
    <target>
        <inSequence>
            <property name="base" expression="json-eval($.base)"/>
            <property name="type" expression="json-eval($.type)"/>
            <property name="date" expression="json-eval($.date)"/>
            <property name="patient" expression="json-eval($.patient)"/>
            <cerner.init>
                <base>{$ctx:base}</base>
            </cerner.init>
            <cerner.searchAppointment>
                <type>{$ctx:type}</type>
                <date>{$ctx:date}</date>
                <patient>{$ctx:patient}</patient>
            </cerner.searchAppointment>
            <log category="INFO" level="full" separator=","/>
            <send/>
        </inSequence>
        <outSequence/>
        <faultSequence/>
    </target>
    <parameter name="serviceType">proxy</parameter>
    <description/>
</proxy>
```
