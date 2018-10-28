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
* id: The logical Id of the resource.

**Sample request**

Following is a sample REST request that can be handled by the retrieveById operation.
```
{
 "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/",
 "type": "Patient",
 "id": "4342008"
}
```
**Sample response**
```json
{
    "resourceType": "Patient",
    "id": "4342008",
    "meta": {
        "versionId": "105",
        "lastUpdated": "2018-10-23T07:16:14.000Z"
    },
    "text": {
        "status": "generated",
        "div": "<div><p><b>Patient</b></p><p><b>Name</b>: SMART, WILMA</p><p><b>DOB</b>: Mar 16, 1947</p><p><b>Administrative Gender</b>: Female</p><p><b>Marital Status</b>: Married</p><p><b>Status</b>: Active</p></div>"
    },
    "extension": [
        {
            "url": "http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity",
            "extension": [
                {
                    "url": "ombCategory",
                    "valueCoding": {
                        "system": "http://hl7.org/fhir/v3/Ethnicity",
                        "code": "2186-5",
                        "display": "Not Hispanic or Latino",
                        "userSelected": false
                    }
                },
                {
                    "url": "text",
                    "valueString": "Not Hispanic or Latino"
                }
            ]
        }
    ],
    "identifier": [
        {
            "use": "usual",
            "type": {
                "coding": [
                    {
                        "system": "http://hl7.org/fhir/v2/0203",
                        "code": "MR",
                        "display": "Medical record number",
                        "userSelected": false
                    }
                ],
                "text": "MRN"
            },
            "system": "urn:oid:2.2.2.2.2.2",
            "value": "10000891",
            "period": {
                "start": "2018-09-19T15:58:40.000Z"
            }
        },
        {
            "use": "usual",
            "type": {
                "coding": [
                    {
                        "system": "http://hl7.org/fhir/v2/0203",
                        "code": "MR",
                        "display": "Medical record number",
                        "userSelected": false
                    }
                ],
                "text": "MRN"
            },
            "system": "urn:oid:1.1.1.1.1.1",
            "value": "10002700",
            "period": {
                "start": "2016-06-22T20:25:56.000Z"
            }
        },
        {
            "use": "usual",
            "type": {
                "text": "Messaging"
            },
            "system": "urn:oid:2.16.840.1.113883.3.13.8",
            "value": "65DBEC0B8D154E3488FA5FFE9AC7713F",
            "period": {
                "start": "2017-12-01T16:54:17.000Z"
            }
        }
    ],
    "active": true,
    "name": [
        {
            "use": "official",
            "text": "SMART, WILMA",
            "family": [
                "SMART"
            ],
            "given": [
                "WILMA"
            ],
            "period": {
                "start": "2016-06-22T20:25:58.000Z"
            }
        },
        {
            "use": "maiden",
            "text": "WILLIAMS,",
            "family": [
                "WILLIAMS"
            ],
            "period": {
                "start": "2017-03-09T19:37:17.000Z"
            }
        }
    ],
    "telecom": [
        {
            "system": "phone",
            "value": "816-222-2222",
            "use": "work",
            "period": {
                "start": "2017-06-27T17:28:04.000Z"
            }
        },
        {
            "system": "phone",
            "value": "8168101010",
            "use": "home",
            "period": {
                "start": "2017-02-07T18:56:52.000Z"
            }
        },
        {
            "system": "phone",
            "value": "913-913-9131",
            "use": "mobile",
            "period": {
                "start": "2017-06-27T17:31:07.000Z"
            }
        },
        {
            "system": "email",
            "value": "wilma_smart@gmail.com",
            "use": "home",
            "period": {
                "start": "2017-12-01T16:52:18.000Z"
            }
        }
    ],
    "gender": "female",
    "birthDate": "1947-03-16",
    "address": [
        {
            "use": "home",
            "text": "1200 Road\nKansas City, MO 64114\nUSA",
            "line": [
                "1200 Road"
            ],
            "city": "Kansas City",
            "district": "Jackson",
            "state": "MO",
            "postalCode": "64114",
            "country": "USA",
            "period": {
                "start": "2017-02-07T18:56:52.000Z"
            }
        }
    ],
    "maritalStatus": {
        "coding": [
            {
                "system": "http://hl7.org/fhir/v3/MaritalStatus",
                "code": "M",
                "display": "Married",
                "userSelected": false
            }
        ],
        "text": "Married"
    },
    "contact": [
        {
            "relationship": [
                {
                    "text": "Authorized Representative"
                }
            ],
            "name": {
                "use": "official",
                "text": "SMART Jr, FRED RICK",
                "family": [
                    "SMART"
                ],
                "given": [
                    "FRED",
                    "RICK"
                ],
                "prefix": [
                    "Mr"
                ],
                "suffix": [
                    "Jr"
                ],
                "period": {
                    "start": "2016-08-31T18:24:54.000Z"
                }
            },
            "telecom": [
                {
                    "system": "phone",
                    "value": "8168889999",
                    "use": "home",
                    "period": {
                        "start": "2017-11-16T17:18:18.000Z"
                    }
                },
                {
                    "system": "email",
                    "value": "kathy.pickering@cerner.com",
                    "use": "home",
                    "period": {
                        "start": "2018-09-13T16:54:27.000Z"
                    }
                }
            ],
            "address": {
                "use": "home",
                "text": "1000 Rockhill Rd\nApartment 2\nKansas City, MO 64114\nUSA",
                "line": [
                    "1000 Rockhill Rd",
                    "Apartment 2"
                ],
                "city": "Kansas City",
                "district": "Jackson",
                "state": "MO",
                "postalCode": "64114",
                "country": "USA",
                "period": {
                    "start": "2017-11-16T17:18:18.000Z"
                }
            },
            "gender": "male",
            "period": {
                "start": "2017-12-28T15:41:08.000Z",
                "end": "2018-01-04T04:57:53.000Z"
            }
        }
    ],
    "communication": [
        {
            "language": {
                "coding": [
                    {
                        "system": "urn:ietf:bcp:47",
                        "code": "hi",
                        "display": "Hindi",
                        "userSelected": false
                    }
                ],
                "text": "Hindi"
            },
            "preferred": true
        }
    ],
    "careProvider": [
        {
            "reference": "Practitioner/1912007",
            "display": "McCurdy, Michael"
        }
    ]
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
 "base": "https://fhir-ehr.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/",
 "type": "Patient"
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
 "base": "https://fhir-ehr.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
 "type": "Appointment",
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
 "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/",
 "type": "AllergyIntolerance",
 "patient": "4342010",
 "status": "active"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "f2ddeaaa-60dd-4b0d-9f43-08c670104971",
    "type": "searchset",
    "total": 3,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/AllergyIntolerance?patient=4342010&status=active"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/AllergyIntolerance/6207793",
            "resource": {
                "resourceType": "AllergyIntolerance",
                "id": "6207793",
                "meta": {
                    "versionId": "6263803",
                    "lastUpdated": "2017-07-21T05:15:51.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Allergy Intolerance</b></p><p><b>Patient</b>: SMART, JOE</p><p><b>Allergy</b>: No known food allergy</p><p><b>Status</b>: Active</p><p><b>Criticality</b>: Low Risk</p><p><b>Category</b>: Environment</p><p><b>Onset</b>: Apr 21, 2017</p><p><b>Note</b>: Apr 10, 2017 11:57 A.M. UTC - Portal, Portal - asasa</p></div>"
                },
                "onset": "2017-04-21",
                "recordedDate": "2017-04-11T15:00:11.000-05:00",
                "recorder": {
                    "reference": "Practitioner/4464007",
                    "display": "Portal, Portal"
                },
                "patient": {
                    "reference": "Patient/4342010",
                    "display": "SMART, JOE"
                },
                "substance": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "429625007",
                            "display": "No known food allergy (situation)",
                            "userSelected": false
                        }
                    ],
                    "text": "No known food allergy"
                },
                "status": "active",
                "criticality": "CRITL",
                "type": "intolerance",
                "category": "environment",
                "note": {
                    "text": "Apr 10, 2017 11:57 A.M. UTC - Portal, Portal - asasa"
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/AllergyIntolerance/6207793",
            "resource": {
                "resourceType": "AllergyIntolerance",
                "id": "6207793",
                "meta": {
                    "versionId": "6263807",
                    "lastUpdated": "2017-07-21T05:15:51.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Allergy Intolerance</b></p><p><b>Patient</b>: SMART, JOE</p><p><b>Allergy</b>: No known food allergy</p><p><b>Status</b>: Active</p><p><b>Criticality</b>: Low Risk</p><p><b>Category</b>: Environment</p><p><b>Onset</b>: Apr 21, 2017</p><p><b>Note</b>: Apr 10, 2017 11:57 A.M. UTC - Portal, Portal - asasa</p></div>"
                },
                "onset": "2017-04-21",
                "recordedDate": "2017-04-11T15:00:11.000-05:00",
                "recorder": {
                    "reference": "Practitioner/4464007",
                    "display": "Portal, Portal"
                },
                "patient": {
                    "reference": "Patient/4342010",
                    "display": "SMART, JOE"
                },
                "substance": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "429625007",
                            "display": "No known food allergy (situation)",
                            "userSelected": false
                        }
                    ],
                    "text": "No known food allergy"
                },
                "status": "active",
                "criticality": "CRITL",
                "type": "intolerance",
                "category": "environment",
                "note": {
                    "text": "Apr 10, 2017 11:57 A.M. UTC - Portal, Portal - asasa"
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/AllergyIntolerance/5703733",
            "resource": {
                "resourceType": "AllergyIntolerance",
                "id": "5703733",
                "meta": {
                    "versionId": "5703733",
                    "lastUpdated": "2016-06-27T14:08:41.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Allergy Intolerance</b></p><p><b>Patient</b>: SMART, JOE</p><p><b>Allergy</b>: No known medicine allergy</p><p><b>Status</b>: Active</p></div>"
                },
                "recordedDate": "2016-06-27T09:08:41.000-05:00",
                "recorder": {
                    "reference": "Practitioner/1912007",
                    "display": "McCurdy, Michael"
                },
                "patient": {
                    "reference": "Patient/4342010",
                    "display": "SMART, JOE"
                },
                "substance": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "409137002",
                            "display": "No known drug allergies (context-dependent category)",
                            "userSelected": false
                        }
                    ],
                    "text": "No known medicine allergy"
                },
                "status": "active",
                "type": "allergy"
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Appointment",
  "patient": "4704007",
  "date": "2017-10-04T08:00:00.000-05:00",
  "status": "booked",
  "count": "5"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "963bc706-8ffe-4f27-8057-40ac5db06870",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Appointment?date=2017-10-04T08%3A00%3A00.000-05%3A00&patient=4704007&status=booked&_count=5"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Appointment/3005756",
            "resource": {
                "resourceType": "Appointment",
                "id": "3005756",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2017-10-04T13:06:34.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Appointment</b></p><p><b>Description</b>: Same Day</p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Oct  4, 2017  1:00 P.M. UTC</p><p><b>End</b>: Oct  4, 2017  2:00 P.M. UTC</p><p><b>Duration</b>: 60 Minutes</p><p><b>Status</b>: Booked</p><p><b>Location</b>: Baseline East</p><p><b>Participants</b>:</p><p><b>Patient</b>: Smart, Barney R</p><br /><p><b>Practitioner</b>: Howdeshell, Tami</p><p><b>Primary</b>: Yes</p></div>"
                },
                "status": "booked",
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "description": "Same Day",
                "start": "2017-10-04T08:00:00.000-05:00",
                "end": "2017-10-04T09:00:00.000-05:00",
                "minutesDuration": 60,
                "participant": [
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "extension": [
                                            {
                                                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                                                "valueCode": "unknown"
                                            }
                                        ]
                                    }
                                ],
                                "text": "Resource"
                            },
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "PPRF",
                                        "display": "primary performer",
                                        "userSelected": false
                                    }
                                ]
                            }
                        ],
                        "actor": {
                            "reference": "Practitioner/2578010",
                            "display": "Howdeshell, Tami"
                        },
                        "required": "required",
                        "status": "accepted"
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "extension": [
                                            {
                                                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                                                "valueCode": "unknown"
                                            }
                                        ]
                                    }
                                ],
                                "text": "Patient"
                            }
                        ],
                        "actor": {
                            "reference": "Patient/4704007",
                            "display": "Smart, Barney R"
                        },
                        "required": "required",
                        "status": "accepted"
                    },
                    {
                        "actor": {
                            "reference": "Location/4048128",
                            "display": "Baseline East"
                        },
                        "required": "required",
                        "status": "accepted"
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Binary",
  "patient": "1316035",
  "start": "2014-09-24T12:00:00.000Z",
  "end": "2016-09-24T12:00:00.000Z"
}
```
**Sample response**
```json
{
    "resourceType": "Binary",
    "id": "5054497f-de15-4c01-b010-6fc2d3c6c90c",
    "meta": {
        "lastUpdated": "2018-10-23T10:06:25Z"
        },
    "contentType": "application/xml",
    "content": "Binary content"
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Patient",
  "id": "1316035"
}
```

**Sample response**
```json
{
    "resourceType": "Patient",
    "id": "1316035",
    "meta": {
        "versionId": "0",
        "lastUpdated": "2012-05-17T15:24:54.000Z"
    },
    "text": {
        "status": "generated",
        "div": "<div><p><b>Patient</b></p><p><b>Name</b>: Thota, Durga</p><p><b>DOB</b>: Aug 17, 1999</p><p><b>Administrative Gender</b>: Male</p><p><b>Status</b>: Active</p></div>"
    },
    "identifier": [
        {
            "use": "usual",
            "type": {
                "coding": [
                    {
                        "system": "http://hl7.org/fhir/v2/0203",
                        "code": "MR",
                        "display": "Medical record number",
                        "userSelected": false
                    }
                ],
                "text": "MRN"
            },
            "system": "urn:oid:1.1.1.1.1.1",
            "value": "10000367",
            "period": {
                "start": "2012-05-17T15:24:54.000Z"
            }
        }
    ],
    "active": true,
    "name": [
        {
            "use": "official",
            "text": "Thota, Durga",
            "family": [
                "Thota"
            ],
            "given": [
                "Durga"
            ],
            "period": {
                "start": "2012-05-17T15:24:54.000Z"
            }
        }
    ],
    "telecom": [
        {
            "system": "phone",
            "value": "(816) 931-8337",
            "use": "home",
            "period": {
                "start": "2012-05-17T15:24:54.000Z"
            }
        }
    ],
    "gender": "male",
    "birthDate": "1999-08-17",
    "address": [
        {
            "use": "home",
            "text": "4630 Troost Ave\nKansas City, MO ",
            "line": [
                "4630 Troost Ave"
            ],
            "city": "Kansas City",
            "state": "MO",
            "period": {
                "start": "2012-05-17T15:24:54.000Z"
            }
        }
    ],
    "careProvider": [
        {
            "reference": "Practitioner/1314014",
            "display": "McCready, Tim"
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "CarePlan",
  "patient": "1316020",
  "category": "assess-plan"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "af243e09-6533-4435-925e-1b05374138a5",
    "type": "searchset",
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/CarePlan?patient=1316020&category=assess-plan&_count=10"
        },
        {
            "relation": "next",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/CarePlan?patient=1316020&-pageContext=eNqVUl1r2zAU_SsrGXtyxJVsJY6hEMdWh6GLg62EbS_GKEomsKWgOGUd_fGT24ysDXQeCKR77zn3S0eYFglptbSoPT4IJBqllagb-SB1h-q2_mU0OtR7pfcofrZW9V4mRnfyZzea34h3-VsjTm3_EFZ10qoaFbKzygUXj6xHlLJLzqGb-ehkdfSSLGrVNpK2RQdpj0ZHux_KHpr6McI-ngABB8azKYwBu8MBoueDAOC7CxHA4RjDmPgcTyIKESFoisM-hOG6jjBWImsaebBmpxp5qcZv770svSUQuJRTx9SnpnHXIi6zpIo5L7LFmrPSudjdHUt4tmFVGnPmHLu6Ocr_uJPz5j6k56Ud-6xfVvxbdZ-V_HXbwmzdj1wadbaMfPxpNP8XiNAhoNkAkA9DQMEQEHXTxW57-bJaFfkmS1nxdvhXRmdP_cqc_lJWJmyZZsvPw8V4VvW1FHOntrpTRn98kfo1ohf_pf6SfeVVsi7KvG-XYp8EU-xNAGM_8D0c0JCQSRg4VYIHf331qmCbLF-XFy4JCdDQ90KgNJg4LiV0FvgBDv5w3XhPoyf4DQskM4Y%3D&-pageDirection=NEXT"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/CarePlan/8055463",
            "resource": {
                "resourceType": "CarePlan",
                "id": "8055463",
                "meta": {
                    "versionId": "1",
                    "lastUpdated": "2018-05-07T10:44:08-05:00"
                },
                "text": {
                    "status": "additional",
                    "div": "<div><p><b>Care Plan</b></p><p><b>Patient</b>: Houde, Test 1</p><p><b>Status</b>: Completed</p><p><b>Description</b>:</p><pre>Document reference&#10;Document reference&#10;</pre><p><b>Author</b>: Aluru, Naveen</p><p><b>Effective Date/Time</b>: May 10, 2018  9:10 A.M. UTC</p></div>"
                },
                "subject": {
                    "reference": "Patient/1316020",
                    "display": "Houde, Test 1"
                },
                "status": "completed",
                "context": {
                    "reference": "Encounter/2457909"
                },
                "period": {
                    "start": "2018-05-10T04:10:14-05:00"
                },
                "author": [
                    {
                        "reference": "Practitioner/1698008",
                        "display": "Aluru, Naveen"
                    }
                ],
                "modified": "2018-05-07T10:44:08-05:00",
                "category": [
                    {
                        "coding": [
                            {
                                "system": "http://argonaut.hl7.org",
                                "code": "assess-plan",
                                "display": "Assess-Plan"
                            }
                        ]
                    }
                ]
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/CarePlan/7647299",
            "resource": {
                "resourceType": "CarePlan",
                "id": "7647299",
                "meta": {
                    "versionId": "1",
                    "lastUpdated": "2018-02-02T17:04:58-06:00"
                },
                "text": {
                    "status": "additional",
                    "div": "<div><p><b>Care Plan</b></p><p><b>Patient</b>: Houde, Test 1</p><p><b>Status</b>: Completed</p><p><b>Description</b>:</p><pre>[Image Removed: ]&#10; 83570zh &#10;  &#39638;&#38364;&#31680;&#32622;&#25563;&#34899;(Hip Replacement)&#24460;&#65306;&#23621;&#23478;&#23433;&#20840; &#10;  &#36234;&#30637;&#35299;&#23621;&#23478;&#21361;&#38570;&#36234;&#21487;&#24171;&#21161;&#24744;&#23433;&#20840;&#22320;&#24674;&#24489;&#12290;&#24744;&#21487;&#33021;&#24819;&#35201;&#37325;&#26032;&#25850;&#25918;&#20642;&#20465;&#65292;&#20197;&#26041;&#20415;&#36208;&#21205;&#12290;&#22312;&#28020;&#23460;&#35041;&#65292;&#20687;&#28107;&#28020;&#36575;&#31649;&#21644;&#21152;&#39640;&#22352;&#24257;&#31561;&#36628;&#21161;&#24037;&#20855;&#21487;&#24171;&#21161;&#24744;&#20445;&#25345;&#23433;&#20840;&#12290;&#35201;&#27880;&#24847;&#26159;&#21542;&#26377;&#21361;&#38570;&#65292;&#22914;&#28526;&#28629;&#30340;&#22320;&#26495;&#25110;&#34920;&#38754;&#19981;&#24179;&#12290; &#10; [Image Removed: &#23433;&#20840;&#25552;&#31034;&#25226;&#20320;&#30340;&#28107;&#28020;&#12290;]&#10; [Image Removed: &#23433;&#20840;&#25552;&#31034;&#30340;&#23458;&#21381;&#12290;]&#10;</pre><p><b>Author</b>: Brewer, Phil V</p><p><b>Effective Date/Time</b>: Feb  2, 2018 10:10 A.M. UTC</p></div>"
                },
                "subject": {
                    "reference": "Patient/1316020",
                    "display": "Houde, Test 1"
                },
                "status": "completed",
                "context": {
                    "reference": "Encounter/2457909"
                },
                "period": {
                    "start": "2018-02-02T04:10:14-06:00"
                },
                "author": [
                    {
                        "reference": "Practitioner/1418008",
                        "display": "Brewer, Phil V"
                    }
                ],
                "modified": "2018-02-02T17:04:58-06:00",
                "category": [
                    {
                        "coding": [
                            {
                                "system": "http://argonaut.hl7.org",
                                "code": "assess-plan",
                                "display": "Assess-Plan"
                            }
                        ]
                    }
                ]
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/CarePlan/7647283",
            "resource": {
                "resourceType": "CarePlan",
                "id": "7647283",
                "meta": {
                    "versionId": "1",
                    "lastUpdated": "2018-02-02T15:50:52-06:00"
                },
                "text": {
                    "status": "additional",
                    "div": "<div><p><b>Care Plan</b></p><p><b>Patient</b>: Houde, Test 1</p><p><b>Status</b>: Completed</p><p><b>Description</b>:</p><pre>[Image Removed: ]&#10; 83570zh &#10;  &#39638;&#38364;&#31680;&#32622;&#25563;&#34899;(Hip Replacement)&#24460;&#65306;&#23621;&#23478;&#23433;&#20840; &#10;  &#36234;&#30637;&#35299;&#23621;&#23478;&#21361;&#38570;&#36234;&#21487;&#24171;&#21161;&#24744;&#23433;&#20840;&#22320;&#24674;&#24489;&#12290;&#24744;&#21487;&#33021;&#24819;&#35201;&#37325;&#26032;&#25850;&#25918;&#20642;&#20465;&#65292;&#20197;&#26041;&#20415;&#36208;&#21205;&#12290;&#22312;&#28020;&#23460;&#35041;&#65292;&#20687;&#28107;&#28020;&#36575;&#31649;&#21644;&#21152;&#39640;&#22352;&#24257;&#31561;&#36628;&#21161;&#24037;&#20855;&#21487;&#24171;&#21161;&#24744;&#20445;&#25345;&#23433;&#20840;&#12290;&#35201;&#27880;&#24847;&#26159;&#21542;&#26377;&#21361;&#38570;&#65292;&#22914;&#28526;&#28629;&#30340;&#22320;&#26495;&#25110;&#34920;&#38754;&#19981;&#24179;&#12290; &#10; [Image Removed: &#23433;&#20840;&#25552;&#31034;&#25226;&#20320;&#30340;&#28107;&#28020;&#12290;]&#10; [Image Removed: &#23433;&#20840;&#25552;&#31034;&#30340;&#23458;&#21381;&#12290;]&#10;</pre><p><b>Author</b>: Brewer, Phil V</p><p><b>Effective Date/Time</b>: Feb  2, 2018  9:10 A.M. UTC</p></div>"
                },
                "subject": {
                    "reference": "Patient/1316020",
                    "display": "Houde, Test 1"
                },
                "status": "completed",
                "context": {
                    "reference": "Encounter/2457909"
                },
                "period": {
                    "start": "2018-02-02T03:10:14-06:00"
                },
                "author": [
                    {
                        "reference": "Practitioner/1418008",
                        "display": "Brewer, Phil V"
                    }
                ],
                "modified": "2018-02-02T15:50:52-06:00",
                "category": [
                    {
                        "coding": [
                            {
                                "system": "http://argonaut.hl7.org",
                                "code": "assess-plan",
                                "display": "Assess-Plan"
                            }
                        ]
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Condition",
  "patient": "4342012"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "87813fbd-f78e-45b4-85ef-cee908ea1668",
    "type": "searchset",
    "total": 3,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Condition?patient=4342012"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Condition/p7930037",
            "resource": {
                "resourceType": "Condition",
                "id": "p7930037",
                "meta": {
                    "versionId": "8202327",
                    "lastUpdated": "2018-05-04T17:10:02.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Condition</b></p><p><b>Patient</b>: SMART, TIMMY</p><p><b>Problem</b>: Ham syndrome, Polyglandular autoimmune syndrome, type 1 (disorder)</p><p><b>Verification Status</b>: Entered In Error</p><p><b>Resolved</b>: False</p></div>"
                },
                "patient": {
                    "reference": "Patient/4342012",
                    "display": "SMART, TIMMY"
                },
                "asserter": {
                    "reference": "Practitioner/4464007",
                    "display": "Portal, Portal"
                },
                "dateRecorded": "2018-04-02",
                "code": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "11244009",
                            "display": "Polyglandular autoimmune syndrome, type 1 (disorder)",
                            "userSelected": false
                        }
                    ],
                    "text": "Ham syndrome"
                },
                "category": {
                    "coding": [
                        {
                            "system": "http://argonaut.hl7.org",
                            "code": "problem",
                            "display": "Problem"
                        }
                    ],
                    "text": "Problem"
                },
                "verificationStatus": "entered-in-error",
                "abatementBoolean": false
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Condition/p8202259",
            "resource": {
                "resourceType": "Condition",
                "id": "p8202259",
                "meta": {
                    "versionId": "8281897",
                    "lastUpdated": "2018-05-16T16:02:51.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Condition</b></p><p><b>Patient</b>: SMART, TIMMY</p><p><b>Problem</b>: Ham syndrome, Polyglandular autoimmune syndrome, type 1 (disorder)</p><p><b>Clinical Status</b>: Resolved</p><p><b>Verification Status</b>: Confirmed</p><p><b>Resolved</b>: May 16, 2018</p></div>"
                },
                "patient": {
                    "reference": "Patient/4342012",
                    "display": "SMART, TIMMY"
                },
                "asserter": {
                    "reference": "Practitioner/4464007",
                    "display": "Portal, Portal"
                },
                "dateRecorded": "2018-05-04",
                "code": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "11244009",
                            "display": "Polyglandular autoimmune syndrome, type 1 (disorder)",
                            "userSelected": false
                        }
                    ],
                    "text": "Ham syndrome"
                },
                "category": {
                    "coding": [
                        {
                            "system": "http://argonaut.hl7.org",
                            "code": "problem",
                            "display": "Problem"
                        }
                    ],
                    "text": "Problem"
                },
                "clinicalStatus": "resolved",
                "verificationStatus": "confirmed",
                "abatementDateTime": "2018-05-16"
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Condition/p8202251",
            "resource": {
                "resourceType": "Condition",
                "id": "p8202251",
                "meta": {
                    "versionId": "8202323",
                    "lastUpdated": "2018-05-04T17:09:51.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Condition</b></p><p><b>Patient</b>: SMART, TIMMY</p><p><b>Problem</b>: Ham syndrome, Polyglandular autoimmune syndrome, type 1 (disorder)</p><p><b>Verification Status</b>: Entered In Error</p><p><b>Resolved</b>: False</p></div>"
                },
                "patient": {
                    "reference": "Patient/4342012",
                    "display": "SMART, TIMMY"
                },
                "asserter": {
                    "reference": "Practitioner/4464007",
                    "display": "Portal, Portal"
                },
                "dateRecorded": "2018-05-04",
                "code": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "11244009",
                            "display": "Polyglandular autoimmune syndrome, type 1 (disorder)",
                            "userSelected": false
                        }
                    ],
                    "text": "Ham syndrome"
                },
                "category": {
                    "coding": [
                        {
                            "system": "http://argonaut.hl7.org",
                            "code": "problem",
                            "display": "Problem"
                        }
                    ],
                    "text": "Problem"
                },
                "verificationStatus": "entered-in-error",
                "abatementBoolean": false
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Contract",
  "subject": "4598008"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "b6d4dd4a-fb3a-49dd-ab4b-57d93fdf8f8a",
    "type": "searchset",
    "total": 2,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Contract?subject=Patient%2F4598008"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Contract/7470218",
            "resource": {
                "resourceType": "Contract",
                "id": "7470218",
                "meta": {
                    "versionId": "2"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Contract</b></p><p><b>Actor Name</b>: NOAH, GEORGE</p><p><b>Subject Name</b>: NOAH, BRANDON</p><p><b>Applies Begin</b>: Nov  8, 2016  9:09 P.M. UTC</p><p><b>Type</b>: Consent report (record artifact)</p><p><b>Subtype</b>: Consent status (finding)</p></div>"
                },
                "applies": {
                    "start": "2016-11-08T21:09:24.000Z"
                },
                "subject": [
                    {
                        "reference": "Patient/4598008",
                        "display": "NOAH, BRANDON"
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "https://snomed.ct/sct",
                            "code": "371537001",
                            "display": "Consent report (record artifact)"
                        }
                    ],
                    "text": "Consent report (record artifact)"
                },
                "subtype": [
                    {
                        "coding": [
                            {
                                "system": "https://snomed.ct/sct",
                                "code": "309370004",
                                "display": "Consent status (finding)"
                            }
                        ],
                        "text": "Consent status (finding)"
                    }
                ],
                "action": [
                    {
                        "coding": [
                            {
                                "system": "https://snomed.ct/sct",
                                "code": "441898007",
                                "display": "Consented (qualifier value)"
                            }
                        ],
                        "text": "Consented (qualifier value)"
                    }
                ],
                "actionReason": [
                    {
                        "coding": [
                            {
                                "system": "https://snomed.ct/sct",
                                "code": "425691002",
                                "display": "Consent given for electronic record sharing (finding)"
                            }
                        ],
                        "text": "Consent given for electronic record sharing (finding)"
                    }
                ],
                "actor": [
                    {
                        "entity": {
                            "reference": "RelatedPerson/7470218",
                            "display": "NOAH, GEORGE"
                        },
                        "role": [
                            {
                                "text": "Authorized Representative"
                            }
                        ]
                    }
                ]
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Contract/7470237",
            "resource": {
                "resourceType": "Contract",
                "id": "7470237",
                "meta": {
                    "versionId": "5"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Contract</b></p><p><b>Actor Name</b>: NOAH, SANDY</p><p><b>Subject Name</b>: NOAH, BRANDON</p><p><b>Applies Begin</b>: Nov  8, 2016  9:15 P.M. UTC</p><p><b>Type</b>: Consent report (record artifact)</p><p><b>Subtype</b>: Consent status (finding)</p></div>"
                },
                "applies": {
                    "start": "2016-11-08T21:15:10.000Z"
                },
                "subject": [
                    {
                        "reference": "Patient/4598008",
                        "display": "NOAH, BRANDON"
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "https://snomed.ct/sct",
                            "code": "371537001",
                            "display": "Consent report (record artifact)"
                        }
                    ],
                    "text": "Consent report (record artifact)"
                },
                "subtype": [
                    {
                        "coding": [
                            {
                                "system": "https://snomed.ct/sct",
                                "code": "309370004",
                                "display": "Consent status (finding)"
                            }
                        ],
                        "text": "Consent status (finding)"
                    }
                ],
                "action": [
                    {
                        "coding": [
                            {
                                "system": "https://snomed.ct/sct",
                                "code": "441898007",
                                "display": "Consented (qualifier value)"
                            }
                        ],
                        "text": "Consented (qualifier value)"
                    }
                ],
                "actionReason": [
                    {
                        "coding": [
                            {
                                "system": "https://snomed.ct/sct",
                                "code": "425691002",
                                "display": "Consent given for electronic record sharing (finding)"
                            }
                        ],
                        "text": "Consent given for electronic record sharing (finding)"
                    }
                ],
                "actor": [
                    {
                        "entity": {
                            "reference": "RelatedPerson/7470237",
                            "display": "NOAH, SANDY"
                        },
                        "role": [
                            {
                                "text": "Authorized Representative"
                            }
                        ]
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Device",
  "patient": "4478007"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "e2855b3b-7184-4aa3-b51a-cb53d3e97819",
    "type": "searchset",
    "total": 2,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Device?patient=4478007"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Device/15575768",
            "resource": {
                "resourceType": "Device",
                "id": "15575768",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2001-01-01T06:00:00.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Device</b></p><p><b>Patient</b>: SMART Jr, FRED RICK</p><p><b>Type</b>: Insulin Pump</p><p><b>Manufacture Date</b>: Jan  1, 2001  6:00 A.M. UTC</p><p><b>Model</b>: MiniMed Paradigm&#174; 522/722</p><p><b>Serial Number</b>: PBR668583H</p><p><b>Lot Number</b>: 567884-IP</p><p><b>Owner</b>: Baseline East </p></div>"
                },
                "identifier": [
                    {
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/identifier-type",
                                    "code": "SNO",
                                    "display": "Serial Number"
                                }
                            ],
                            "text": "Serial Number"
                        },
                        "value": "PBR668583H"
                    }
                ],
                "type": {
                    "text": "Insulin Pump"
                },
                "model": "MiniMed Paradigm® 522/722",
                "manufactureDate": "2001-01-01T06:00:00.000Z",
                "_udi": {
                    "extension": [
                        {
                            "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                            "valueCode": "unknown"
                        }
                    ]
                },
                "lotNumber": "567884-IP",
                "owner": {
                    "display": "Baseline East "
                },
                "patient": {
                    "reference": "Patient/4478007",
                    "display": "SMART Jr, FRED RICK"
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Device/15577768",
            "resource": {
                "resourceType": "Device",
                "id": "15577768",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2002-01-01T06:00:00.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Device</b></p><p><b>Patient</b>: SMART Jr, FRED RICK</p><p><b>Type</b>: Stryker MDM X3 Hip System</p><p><b>Manufacture Date</b>: Jan  1, 2002  6:00 A.M. UTC</p><p><b>Model</b>: MDM X3</p><p><b>Serial Number</b>: ser100-1001</p><p><b>Owner</b>: Baseline East Medical Center</p></div>"
                },
                "identifier": [
                    {
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/identifier-type",
                                    "code": "SNO",
                                    "display": "Serial Number"
                                }
                            ],
                            "text": "Serial Number"
                        },
                        "value": "ser100-1001"
                    }
                ],
                "type": {
                    "text": "Stryker MDM X3 Hip System"
                },
                "model": "MDM X3",
                "manufactureDate": "2002-01-01T06:00:00.000Z",
                "_udi": {
                    "extension": [
                        {
                            "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                            "valueCode": "unknown"
                        }
                    ]
                },
                "owner": {
                    "display": "Baseline East Medical Center"
                },
                "patient": {
                    "reference": "Patient/4478007",
                    "display": "SMART Jr, FRED RICK"
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "DiagnosticReport",
  "patient": "1316020",
  "count": "2"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "8cb7dfba-5434-42e6-8578-9e0ea6d66c21",
    "type": "searchset",
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DiagnosticReport?patient=1316020&_count=2"
        },
        {
            "relation": "next",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DiagnosticReport?patient=1316020&-pageContext=eNqNUttq4zAQ_ZUtWfYpEZLvNhTi2GoRZONgK2GzL0aoSiqwpaA4pS39-MpOoCWhpUIwmjMz50ia4boFXBglDGgPTxzwRirJWSOehOoAa9mrVmDPdlLtQDp4S7YTmVadeO5G0xv-bf2D5se2P3AjO2EkA6XojLTB2QvuMyrRZefQzXR0NCo5kSWtfEiEacFemINWyfZRmn3DXhLkogA60CajOIQTiOymECbDBhDC_zbkQBRNEJy4kKIwcVACAxBHwRC6luHaCGB0I_ZGb2UjPsTo7XxM8lsHepYxtJXq2DTWzNKKZHVKaUlmK4orC-G7O5xRssZ1nlJsgS1rDuIHtjPH3uSS7ZQ-dJL_Iu3w3X9G0zLNSTEv7je9wN8l3dRzUtFLJ7W6xaJelsWa5Li0dRUeIHuaFfnm4qJf8pxvYpua4yrDi5ws7n_e4fOoXPe3sC1kndTq92l-rjP6ifrQX-B_tM5WZVWU1vNg4ASBP_aR73qRP0aeG0UxcmC_zmj46TuXJV6TYlVdMDiWIXZCx_csgx-4Xgg9d2AY0Pj07rfRG3wH5Hr0NA%3D%3D&-pageDirection=NEXT"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DiagnosticReport/5927259",
            "resource": {
                "resourceType": "DiagnosticReport",
                "id": "5927259",
                "meta": {
                    "versionId": "9",
                    "lastUpdated": "2016-02-24T20:55:45.000Z"
                },
                "text": {
                    "status": "additional",
                    "div": "<div><p><b>Diagnostic Report</b></p><p><b>Document Type</b>: RADRPT</p><p><b>Document Title</b>: XR Abdomen AP</p><p><b>Status</b>: Appended</p><p><b>Verifying Provider</b>: Vogel, Jason</p><p><b>Ordering Provider</b>: <ul><li>Sura, Zameer</li></ul></p></div>"
                },
                "status": "appended",
                "category": {
                    "text": "RADRPT"
                },
                "code": {
                    "text": "RADRPT"
                },
                "subject": {
                    "reference": "Patient/1316020",
                    "display": "Houde, Test 1"
                },
                "encounter": {
                    "reference": "Encounter/3261906"
                },
                "effectiveDateTime": "2016-02-24T20:50:43.000Z",
                "issued": "2016-02-24T20:55:44.000Z",
                "performer": {
                    "reference": "Practitioner/1526007",
                    "display": "Vogel, Jason"
                },
                "request": [
                    {
                        "reference": "ProcedureRequest/20485919"
                    }
                ],
                "presentedForm": [
                    {
                        "contentType": "text/html",
                        "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Binary/TR-5927259"
                    },
                    {
                        "contentType": "application/pdf",
                        "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Binary/XR-5927259"
                    }
                ]
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DiagnosticReport/5153487",
            "resource": {
                "resourceType": "DiagnosticReport",
                "id": "5153487",
                "meta": {
                    "versionId": "3",
                    "lastUpdated": "2015-08-06T20:03:21.000Z"
                },
                "text": {
                    "status": "additional",
                    "div": "<div><p><b>Diagnostic Report</b></p><p><b>Document Type</b>: RADRPT</p><p><b>Status</b>: Partial</p><p><b>Verifying Provider</b>: Interfaced-Unknown</p></div>"
                },
                "status": "partial",
                "code": {
                    "text": "RADRPT"
                },
                "subject": {
                    "reference": "Patient/1316020",
                    "display": "Houde, Test 1"
                },
                "effectiveDateTime": "2015-08-06T20:03:09.000Z",
                "issued": "2015-08-06T20:03:21.000Z",
                "performer": {
                    "display": "Interfaced-Unknown"
                },
                "presentedForm": [
                    {
                        "extension": [
                            {
                                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                                "valueCode": "masked"
                            }
                        ]
                    },
                    {
                        "extension": [
                            {
                                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                                "valueCode": "masked"
                            }
                        ]
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "DocumentReference",
  "patient": "1316024",
  "createdEarliest": "2016-01-06",
  "createdLatest": "2016-01-07"
}
```
>Note:id, or one of patient or subject must be provided.

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "7885eaf3-8a89-4999-8fd6-dcb6e72ad993",
    "type": "searchset",
    "total": 2,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DocumentReference?patient=1316024&created=ge2016-01-06&created=le2016-01-07"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DocumentReference/6589312",
            "resource": {
                "resourceType": "DocumentReference",
                "id": "6589312",
                "meta": {
                    "versionId": "6589311",
                    "lastUpdated": "2016-07-27T18:00:43.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Document Reference</b></p><p><b>Patient Name</b>: PETERS, TIMOTHY</p><p><b>Document Type</b>: Rheumatology Consultation</p><p><b>Document Title</b>: Rheumatology Note</p><p><b>Date</b>: Jan  6, 2016  9:10 A.M. UTC</p><p><b>Document Status</b>: Auth (Verified)</p></div>"
                },
                "subject": {
                    "reference": "Patient/1316024",
                    "display": "PETERS, TIMOTHY"
                },
                "type": {
                    "coding": [
                        {
                            "system": "http://loinc.org",
                            "code": "34839-1"
                        }
                    ],
                    "text": "Rheumatology Consultation"
                },
                "authenticator": {
                    "reference": "Practitioner/2044324"
                },
                "created": "2016-01-06T09:10:14.000Z",
                "indexed": "2016-01-06T09:10:14.000Z",
                "status": "current",
                "docStatus": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/composition-status",
                            "code": "final",
                            "display": "Final"
                        }
                    ],
                    "text": "Auth (Verified)"
                },
                "description": "Rheumatology Note",
                "content": [
                    {
                        "attachment": {
                            "contentType": "application/pdf",
                            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Binary/XR-6589312"
                        }
                    }
                ],
                "context": {
                    "encounter": {
                        "reference": "Encounter/1309918"
                    }
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/DocumentReference/6589307",
            "resource": {
                "resourceType": "DocumentReference",
                "id": "6589307",
                "meta": {
                    "versionId": "6589306",
                    "lastUpdated": "2016-07-27T17:38:08.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Document Reference</b></p><p><b>Patient Name</b>: PETERS, TIMOTHY</p><p><b>Document Type</b>: Rheumatology Consultation</p><p><b>Document Title</b>: Rheumatology Note</p><p><b>Date</b>: Jan  6, 2016  9:10 A.M. UTC</p><p><b>Document Status</b>: Auth (Verified)</p></div>"
                },
                "subject": {
                    "reference": "Patient/1316024",
                    "display": "PETERS, TIMOTHY"
                },
                "type": {
                    "coding": [
                        {
                            "system": "http://loinc.org",
                            "code": "34839-1"
                        }
                    ],
                    "text": "Rheumatology Consultation"
                },
                "authenticator": {
                    "reference": "Practitioner/2044324"
                },
                "created": "2016-01-06T09:10:14.000Z",
                "indexed": "2016-01-06T09:10:14.000Z",
                "status": "current",
                "docStatus": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/composition-status",
                            "code": "final",
                            "display": "Final"
                        }
                    ],
                    "text": "Auth (Verified)"
                },
                "description": "Rheumatology Note",
                "content": [
                    {
                        "attachment": {
                            "contentType": "application/pdf",
                            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Binary/XR-6589307"
                        }
                    }
                ],
                "context": {
                    "encounter": {
                        "reference": "Encounter/1309918"
                    }
                }
            }
        }
    ]
}
```
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Goal",
      "patient": "685925",
  "startDate": "2016-11-09",
  "endDate": "2016-11-30"
}
```
>Note:The _id parameter may not be provided at the same time as the patient, subject,startDate and endDate parameters.

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "093ad1c8-0242-4ae0-97e5-e3438c72f514",
    "type": "searchset",
    "total": 3,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Goal?patient=685925"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Goal/59475953",
            "resource": {
                "resourceType": "Goal",
                "id": "59475953",
                "meta": {
                    "versionId": "1485975664000",
                    "lastUpdated": "2017-02-01T19:01:04.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Goal</b></p><p><b>Subject</b>: JONES, OLIVIA CERNER</p><p><b>Description</b>: Test goal</p><p><b>Status</b>: In Progress</p><p><b>Start Date</b>: Nov  9, 2016</p><p><b>Target Date</b>: Nov 30, 2016</p></div>"
                },
                "subject": {
                    "reference": "Patient/685925",
                    "display": "JONES, OLIVIA CERNER"
                },
                "startDate": "2016-11-09",
                "targetDate": "2016-11-30",
                "category": [
                    {
                        "text": "Community"
                    }
                ],
                "description": "Test goal",
                "status": "in-progress",
                "statusDate": "2016-11-09",
                "note": [
                    {
                        "authorReference": {
                            "reference": "Practitioner/4594024",
                            "display": "Bhadra, Chelsea"
                        },
                        "time": "2017-02-01T19:01:04.000Z",
                        "text": "Test comment for the goal \"Test goal\""
                    }
                ]
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Goal/59535837",
            "resource": {
                "resourceType": "Goal",
                "id": "59535837",
                "meta": {
                    "versionId": "1482335249000",
                    "lastUpdated": "2016-12-21T15:47:29.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Goal</b></p><p><b>Subject</b>: JONES, OLIVIA CERNER</p><p><b>Description</b>: Met goal</p><p><b>Status</b>: Achieved</p><p><b>Start Date</b>: Dec 13, 2016</p><p><b>Target Date</b>: Dec 23, 2016</p></div>"
                },
                "subject": {
                    "reference": "Patient/685925",
                    "display": "JONES, OLIVIA CERNER"
                },
                "startDate": "2016-12-13",
                "targetDate": "2016-12-23",
                "category": [
                    {
                        "text": "Community"
                    },
                    {
                        "text": "Safety"
                    }
                ],
                "description": "Met goal",
                "status": "achieved",
                "statusDate": "2016-12-21"
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Goal/59535833",
            "resource": {
                "resourceType": "Goal",
                "id": "59535833",
                "meta": {
                    "versionId": "1485975696000",
                    "lastUpdated": "2017-02-01T19:01:36.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Goal</b></p><p><b>Subject</b>: JONES, OLIVIA CERNER</p><p><b>Description</b>: Test Goal without a target date</p><p><b>Author</b>: JONES, OLIVIA CERNER</p><p><b>Status</b>: In Progress</p><p><b>Start Date</b>: Dec 21, 2016</p></div>"
                },
                "subject": {
                    "reference": "Patient/685925",
                    "display": "JONES, OLIVIA CERNER"
                },
                "startDate": "2016-12-21",
                "category": [
                    {
                        "text": "Behavioral"
                    }
                ],
                "description": "Test Goal without a target date",
                "status": "in-progress",
                "statusDate": "2016-12-21",
                "author": {
                    "reference": "Patient/685925",
                    "display": "JONES, OLIVIA CERNER"
                },
                "note": [
                    {
                        "authorReference": {
                            "reference": "Practitioner/4594024",
                            "display": "Bhadra, Chelsea"
                        },
                        "time": "2017-02-01T19:01:36.000Z",
                        "text": "This is a test. I repeat, this is only a test!"
                    }
                ]
            }
        }
    ]
}
```

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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Immunization",
  "patient": "4478007",
  "earliestDate": "2015-01-01",
  "latestDate": "2016-11-30"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "baf5e2fe-fcc7-4530-8e77-fd35ad1dc763",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Immunization?patient=4478007&date=ge2015-01-01&date=le2016-11-30"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Immunization/M6753285",
            "resource": {
                "resourceType": "Immunization",
                "id": "M6753285",
                "meta": {
                    "versionId": "1",
                    "lastUpdated": "2016-09-09T09:32:39-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Immunization</b></p><p><b>Vaccine</b>: tetanus toxoid</p><p><b>Date</b>: Sep  9, 2016 12:29 P.M. UTC</p><p><b>Given</b>: Yes</p><p><b>Administered by</b>: Pickering, Kathy</p><p><b>Site</b>: Left Gluteus Medius</p><p><b>Route</b>: IM</p></div>"
                },
                "status": "completed",
                "date": "2016-09-09T07:29:00-05:00",
                "vaccineCode": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/sid/cvx",
                            "code": "112",
                            "display": "tetanus toxoid, unspecified formulation",
                            "userSelected": false
                        }
                    ],
                    "text": "tetanus toxoid"
                },
                "patient": {
                    "reference": "Patient/4478007",
                    "display": "SMART Jr, FRED RICK"
                },
                "wasNotGiven": false,
                "reported": false,
                "performer": {
                    "reference": "Practitioner/4474007",
                    "display": "Pickering, Kathy"
                },
                "encounter": {
                    "reference": "Encounter/4135906"
                },
                "manufacturer": {
                    "display": "Johnson and Johnson/Merck Consumer"
                },
                "location": {
                    "reference": "Location/4048134",
                    "display": "1N"
                },
                "lotNumber": "L0909",
                "expirationDate": "2017-09-11",
                "site": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "78333006",
                            "display": "structure of gluteus medius muscle (body structure)",
                            "userSelected": false
                        }
                    ],
                    "text": "Left Gluteus Medius"
                },
                "route": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "78421000",
                            "display": "Intramuscular route (qualifier value)",
                            "userSelected": false
                        }
                    ],
                    "text": "IM"
                },
                "doseQuantity": {
                    "value": 1,
                    "unit": "mL",
                    "system": "http://unitsofmeasure.org",
                    "code": "mL"
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "MedicationAdministration",
  "patient": "4642007",
  "status": "completed",
  "Practitioner": "1776007"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "0a53707c-edaf-43ee-bf00-df722c4e35b2",
    "type": "searchset",
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationAdministration?patient=4642007&status=completed&practitioner=1776007"
        },
        {
            "relation": "next",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationAdministration?patient=4642007&status=completed&practitioner=1776007&-pageContext=H4sIAAAAAAAAADWMuwoCMRBF_yW1BJN1iU4nrqVWW9hJSCYmYB6Ms4KI_25AvN3hHs5bNHtDAeJ8vMxi1Ymw8An93udUDgvXEPq7UAGHVJAgJw8uWmKJz65CiIna3b4kY25XilX-RPto0tUMRptRb4fexuInnvM_qkal9M4Mm3Xf5wtjreoSiQAAAA%3D%3D&-pageDirection=NEXT"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationAdministration/7283373",
            "resource": {
                "resourceType": "MedicationAdministration",
                "id": "7283373",
                "meta": {
                    "versionId": "7283374",
                    "lastUpdated": "2017-11-22T17:25:12.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Medication Administration</b></p><p><b>Patient Name</b>: Smart, Connie</p><p><b>Medication Display</b>: acetaminophen</p><p><b>Administered</b>: Yes</p><p><b>Dosage Quantity</b>: 120 mg</p><p><b>Medication Status</b>: Completed</p><p><b>Effective Time</b>: Nov 22, 2017  5:25 P.M. UTC</p></div>"
                },
                "status": "completed",
                "patient": {
                    "reference": "Patient/4642007",
                    "display": "Smart, Connie"
                },
                "practitioner": {
                    "reference": "Practitioner/1776007",
                    "display": "Julius, Scott"
                },
                "encounter": {
                    "reference": "Encounter/4251906"
                },
                "prescription": {
                    "reference": "MedicationOrder/22954085"
                },
                "wasNotGiven": false,
                "effectiveTimeDateTime": "2017-11-22T17:25:00.000Z",
                "medicationCodeableConcept": {
                    "coding": [
                        {
                            "system": "http://www.nlm.nih.gov/research/umls/rxnorm",
                            "code": "161",
                            "display": "Acetaminophen",
                            "userSelected": false
                        }
                    ],
                    "text": "acetaminophen"
                },
                "dosage": {
                    "text": "120 mg Oral q4hr",
                    "route": {
                        "coding": [
                            {
                                "system": "http://ncimeta.nci.nih.gov",
                                "code": "C38288",
                                "display": "ORAL",
                                "userSelected": false
                            },
                            {
                                "system": "http://snomed.info/sct",
                                "code": "26643006",
                                "display": "Oral route (qualifier value)",
                                "userSelected": false
                            }
                        ],
                        "text": "Oral"
                    },
                    "quantity": {
                        "value": 120,
                        "unit": "mg",
                        "system": "http://unitsofmeasure.org",
                        "code": "mg"
                    }
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationAdministration/7283363",
            "resource": {
                "resourceType": "MedicationAdministration",
                "id": "7283363",
                "meta": {
                    "versionId": "7283364",
                    "lastUpdated": "2017-11-22T17:16:46.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Medication Administration</b></p><p><b>Patient Name</b>: Smart, Connie</p><p><b>Medication Display</b>: aspirin</p><p><b>Administered</b>: Yes</p><p><b>Dosage Quantity</b>: 325 mg</p><p><b>Medication Status</b>: Completed</p><p><b>Effective Time</b>: Nov 22, 2017  5:15 P.M. UTC</p></div>"
                },
                "status": "completed",
                "patient": {
                    "reference": "Patient/4642007",
                    "display": "Smart, Connie"
                },
                "practitioner": {
                    "reference": "Practitioner/1776007",
                    "display": "Julius, Scott"
                },
                "encounter": {
                    "reference": "Encounter/4251906"
                },
                "prescription": {
                    "reference": "MedicationOrder/22962037"
                },
                "wasNotGiven": false,
                "effectiveTimeDateTime": "2017-11-22T17:15:00.000Z",
                "medicationCodeableConcept": {
                    "coding": [
                        {
                            "system": "http://www.nlm.nih.gov/research/umls/rxnorm",
                            "code": "212033",
                            "display": "Aspirin 325 MG Oral Tablet",
                            "userSelected": false
                        }
                    ],
                    "text": "aspirin"
                },
                "dosage": {
                    "text": "325 mg = 1 tabs GTUBE Once",
                    "route": {
                        "coding": [
                            {
                                "system": "http://ncimeta.nci.nih.gov",
                                "code": "C38246",
                                "display": "INTRAGASTRIC",
                                "userSelected": false
                            },
                            {
                                "system": "http://snomed.info/sct",
                                "code": "127490009",
                                "display": "Gastrostomy route (qualifier value)",
                                "userSelected": false
                            }
                        ],
                        "text": "GTUBE"
                    },
                    "quantity": {
                        "value": 325,
                        "unit": "mg",
                        "system": "http://unitsofmeasure.org",
                        "code": "mg"
                    }
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "MedicationOrder",
  "patient": "4342010",
  "status": "active"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "9ddfdb55-33f5-47c1-83fd-ff02f81d2a8f",
    "type": "searchset",
    "total": 2,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationOrder?patient=4342010&_count=25&status=active"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationOrder/23626045",
            "resource": {
                "resourceType": "MedicationOrder",
                "id": "23626045",
                "meta": {
                    "versionId": "2",
                    "lastUpdated": "2018-05-31T11:32:16.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Medication Order</b></p><p><b>Patient Name</b>: SMART, JOE</p><p><b>Medication Name</b>: DOPamine 400mg / D5W 250mL 400 mg [2 mg/kg/hr] + Dextrose 10% in Water 1000 mL</p><p><b>Dosage Instructions</b>: 250 mL/hr, IV</p><p><b>Status</b>: Active</p></div>"
                },
                "contained": [
                    {
                        "resourceType": "Medication",
                        "id": "4310122",
                        "code": {
                            "text": "DOPamine 400mg / D5W 250mL 400 mg [2 mg/kg/hr] + Dextrose 10% in Water 1000 mL"
                        },
                        "product": {
                            "form": {
                                "coding": [
                                    {
                                        "system": "http://ncimeta.nci.nih.gov",
                                        "code": "C42986",
                                        "display": "SOLUTION",
                                        "userSelected": false
                                    },
                                    {
                                        "system": "http://snomed.info/sct",
                                        "code": "77899000",
                                        "display": "Drug solution (product)",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Soln"
                            },
                            "ingredient": [
                                {
                                    "item": {
                                        "reference": "#18702044-1",
                                        "display": "DOPamine 400mg / D5W 250mL"
                                    },
                                    "amount": {
                                        "numerator": {
                                            "value": 400,
                                            "unit": "mg",
                                            "system": "http://unitsofmeasure.org",
                                            "code": "mg"
                                        },
                                        "denominator": {
                                            "value": 1000,
                                            "unit": "mL",
                                            "system": "http://unitsofmeasure.org",
                                            "code": "mL"
                                        }
                                    }
                                },
                                {
                                    "item": {
                                        "reference": "#2778756-2",
                                        "display": "Dextrose 10% in Water"
                                    },
                                    "amount": {
                                        "numerator": {
                                            "value": 1000,
                                            "unit": "mL",
                                            "system": "http://unitsofmeasure.org",
                                            "code": "mL"
                                        },
                                        "denominator": {
                                            "value": 1000,
                                            "unit": "mL",
                                            "system": "http://unitsofmeasure.org",
                                            "code": "mL"
                                        }
                                    }
                                }
                            ]
                        }
                    },
                    {
                        "resourceType": "Medication",
                        "id": "18702044-1",
                        "code": {
                            "text": "DOPamine 400mg / D5W 250mL"
                        }
                    },
                    {
                        "resourceType": "Medication",
                        "id": "2778756-2",
                        "code": {
                            "coding": [
                                {
                                    "system": "http://www.nlm.nih.gov/research/umls/rxnorm",
                                    "code": "237648",
                                    "display": "Glucose 100 MG/ML Injectable Solution",
                                    "userSelected": false
                                }
                            ],
                            "text": "Dextrose 10% in Water"
                        }
                    }
                ],
                "dateWritten": "2018-05-16T10:46:20.000-05:00",
                "status": "active",
                "patient": {
                    "reference": "Patient/4342010",
                    "display": "SMART, JOE"
                },
                "prescriber": {
                    "reference": "Practitioner/1912007",
                    "display": "McCurdy, Michael"
                },
                "encounter": {
                    "reference": "Encounter/4027918"
                },
                "medicationReference": {
                    "reference": "#4310122",
                    "display": "DOPamine 400mg / D5W 250mL 400 mg [2 mg/kg/hr] + Dextrose 10% in Water 1000 mL"
                },
                "dosageInstruction": [
                    {
                        "text": "250 mL/hr, IV",
                        "_text": {
                            "extension": [
                                {
                                    "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/patient-friendly-display",
                                    "valueString": "250 Milliliter/hour Intravenous. Refills: 0."
                                }
                            ]
                        },
                        "timing": {
                            "repeat": {
                                "boundsPeriod": {
                                    "start": "2018-05-16T12:44:00.000-05:00"
                                },
                                "duration": 4,
                                "durationUnits": "h"
                            }
                        },
                        "route": {
                            "coding": [
                                {
                                    "system": "http://ncimeta.nci.nih.gov",
                                    "code": "C38276",
                                    "display": "INTRAVENOUS",
                                    "userSelected": false
                                },
                                {
                                    "system": "http://snomed.info/sct",
                                    "code": "47625008",
                                    "display": "Intravenous route (qualifier value)",
                                    "userSelected": false
                                }
                            ],
                            "text": "IV"
                        },
                        "doseQuantity": {
                            "value": 1000,
                            "unit": "mL",
                            "system": "http://unitsofmeasure.org",
                            "code": "mL"
                        },
                        "rateRatio": {
                            "numerator": {
                                "value": 1000,
                                "unit": "mL",
                                "system": "http://unitsofmeasure.org",
                                "code": "mL"
                            },
                            "denominator": {
                                "value": 4,
                                "unit": "hr",
                                "system": "http://unitsofmeasure.org",
                                "code": "h"
                            }
                        }
                    }
                ],
                "dispenseRequest": {
                    "validityPeriod": {
                        "start": "2018-05-16T10:46:20.000-05:00"
                    }
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationOrder/23622113",
            "resource": {
                "resourceType": "MedicationOrder",
                "id": "23622113",
                "meta": {
                    "versionId": "1",
                    "lastUpdated": "2018-06-04T11:43:54.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Medication Order</b></p><p><b>Patient Name</b>: SMART, JOE</p><p><b>Medication Name</b>: Dextrose 2.5% with 0.45% NaCl 1000 mL</p><p><b>Dosage Instructions</b>: Free-Text Rate, IV</p><p><b>Status</b>: Active</p></div>"
                },
                "dateWritten": "2018-05-16T09:34:44.000-05:00",
                "status": "active",
                "patient": {
                    "reference": "Patient/4342010",
                    "display": "SMART, JOE"
                },
                "prescriber": {
                    "reference": "Practitioner/4874007",
                    "display": "Smith, Brandon M."
                },
                "priorPrescription": {
                    "reference": "MedicationOrder/22893893"
                },
                "encounter": {
                    "reference": "Encounter/4027918"
                },
                "medicationCodeableConcept": {
                    "coding": [
                        {
                            "system": "http://www.nlm.nih.gov/research/umls/rxnorm",
                            "code": "244095",
                            "display": "Glucose 25 MG/ML / Sodium Chloride 0.0769 MEQ/ML Injectable Solution",
                            "userSelected": false
                        }
                    ],
                    "text": "Dextrose 2.5% with 0.45% NaCl 1000 mL"
                },
                "dosageInstruction": [
                    {
                        "text": "Free-Text Rate, IV",
                        "_text": {
                            "extension": [
                                {
                                    "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/patient-friendly-display",
                                    "valueString": "Free-Text Rate Intravenous. Refills: 0."
                                }
                            ]
                        },
                        "timing": {
                            "repeat": {
                                "boundsPeriod": {
                                    "start": "2018-05-16T07:34:00.000-07:00"
                                }
                            }
                        },
                        "route": {
                            "coding": [
                                {
                                    "system": "http://ncimeta.nci.nih.gov",
                                    "code": "C38276",
                                    "display": "INTRAVENOUS",
                                    "userSelected": false
                                },
                                {
                                    "system": "http://snomed.info/sct",
                                    "code": "47625008",
                                    "display": "Intravenous route (qualifier value)",
                                    "userSelected": false
                                }
                            ],
                            "text": "IV"
                        },
                        "doseQuantity": {
                            "value": 1000,
                            "unit": "mL",
                            "system": "http://unitsofmeasure.org",
                            "code": "mL"
                        }
                    }
                ],
                "dispenseRequest": {
                    "validityPeriod": {
                        "start": "2018-05-16T09:34:44.000-05:00"
                    }
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "MedicationStatement",
  "id": "21389901",
  "status": "active"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "ca865f97-52d2-4e08-a520-fbd33fb3686f",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationStatement?_id=21389901"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/MedicationStatement/21389901",
            "resource": {
                "resourceType": "MedicationStatement",
                "id": "21389901",
                "meta": {
                    "versionId": "2",
                    "lastUpdated": "2018-06-04T11:43:54.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Medication Statement</b></p><p><b>Patient Name</b>: SMART, JOE</p><p><b>Medication Name</b>: acebutolol (Sectral)</p><p><b>Dosage Instructions</b>: 200 mg, 1 caps, Oral, Daily</p><p><b>Status</b>: Completed</p><p><b>Taken</b>: Yes</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/medication-statement-category",
                        "valueCodeableConcept": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/medication-statement-category",
                                    "code": "inpatient",
                                    "display": "Inpatient"
                                }
                            ],
                            "text": "Inpatient"
                        }
                    }
                ],
                "patient": {
                    "reference": "Patient/4342010",
                    "display": "SMART, JOE"
                },
                "informationSource": {
                    "reference": "Practitioner/4874007",
                    "display": "Smith, Brandon M."
                },
                "dateAsserted": "2016-06-27T09:57:32.000-05:00",
                "status": "completed",
                "wasNotTaken": false,
                "effectivePeriod": {
                    "start": "2016-06-27T09:00:00.000-07:00",
                    "end": "2018-05-16T07:31:00.000-07:00"
                },
                "supportingInformation": [
                    {
                        "reference": "MedicationOrder/21389901"
                    }
                ],
                "medicationCodeableConcept": {
                    "coding": [
                        {
                            "system": "http://www.nlm.nih.gov/research/umls/rxnorm",
                            "code": "9631",
                            "display": "Sectral",
                            "userSelected": false
                        }
                    ],
                    "text": "acebutolol (Sectral)"
                },
                "dosage": [
                    {
                        "text": "200 mg, 1 caps, Oral, Daily",
                        "_text": {
                            "extension": [
                                {
                                    "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/patient-friendly-display",
                                    "valueString": "200 Milligram Oral every day. Refills: 0."
                                }
                            ]
                        },
                        "timing": {
                            "repeat": {
                                "boundsPeriod": {
                                    "start": "2016-06-27T09:00:00.000-07:00",
                                    "end": "2018-05-16T07:31:00.000-07:00"
                                }
                            },
                            "code": {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/timing-abbreviation",
                                        "code": "QD",
                                        "display": "QD",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Daily"
                            }
                        },
                        "route": {
                            "coding": [
                                {
                                    "system": "http://ncimeta.nci.nih.gov",
                                    "code": "C38288",
                                    "display": "ORAL",
                                    "userSelected": false
                                },
                                {
                                    "system": "http://snomed.info/sct",
                                    "code": "26643006",
                                    "display": "Oral route (qualifier value)",
                                    "userSelected": false
                                }
                            ],
                            "text": "Oral"
                        },
                        "quantityQuantity": {
                            "value": 200,
                            "unit": "mg",
                            "system": "http://unitsofmeasure.org",
                            "code": "mg"
                        }
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Encounter",
  "patient": "4342010"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "3772c4b3-b3bd-487a-8d14-cfbd45563d85",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Encounter?patient=4342008"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Encounter/4269906",
            "resource": {
                "resourceType": "Encounter",
                "id": "4269906",
                "meta": {
                    "versionId": "29",
                    "lastUpdated": "2018-10-23T07:16:17.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Encounter</b></p><p><b>Location</b>: Baseline East Medical Center, BE Hospital, BE Cardiology</p><p><b>Type</b>: Outpatient</p><p><b>Class</b>: Outpatient</p><p><b>Status</b>: in Progress</p><p><b>Period Start Date</b>: Oct 23, 2018  3:30 P.M. UTC</p><p><b>Reason For Visit</b>: Pleuritic Chest Pain</p><p><b>Attending Physician</b>: Portal, Portal</p></div>"
                },
                "status": "in-progress",
                "class": "outpatient",
                "type": [
                    {
                        "text": "Outpatient"
                    }
                ],
                "patient": {
                    "reference": "Patient/4342008",
                    "display": "SMART, WILMA"
                },
                "participant": [
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ADM",
                                        "display": "admitter",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Admitting Physician"
                            }
                        ],
                        "period": {
                            "start": "2018-02-18T02:46:00.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/1",
                            "display": "SYSTEM, SYSTEM"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ADM",
                                        "display": "admitter",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Admitting Physician"
                            }
                        ],
                        "period": {
                            "start": "2017-11-03T15:48:00.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/2044020",
                            "display": "Strecker, Bradley"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ADM",
                                        "display": "admitter",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Admitting Physician"
                            }
                        ],
                        "period": {
                            "start": "2017-10-25T21:32:00.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/4770008",
                            "display": "Bommireddipalli, Ramkumar"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ATND",
                                        "display": "attender",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Attending Physician"
                            }
                        ],
                        "period": {
                            "start": "2018-05-18T18:58:00.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/4464007",
                            "display": "Portal, Portal"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ATND",
                                        "display": "attender",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Attending Physician"
                            }
                        ],
                        "period": {
                            "start": "2018-01-22T14:46:00.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/1600014",
                            "display": "O'Larte, Dave"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ATND",
                                        "display": "attender",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Attending Physician"
                            }
                        ],
                        "period": {
                            "start": "2018-01-19T15:53:00.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/4664007",
                            "display": "Hopper, Grace"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "ATND",
                                        "display": "attender",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Attending Physician"
                            }
                        ],
                        "period": {
                            "start": "2017-07-19T14:26:00.000Z",
                            "end": "2018-01-31T23:20:53.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/1",
                            "display": "SYSTEM, SYSTEM"
                        }
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "PPRF",
                                        "display": "primary performer",
                                        "userSelected": false
                                    }
                                ],
                                "text": "Ordering Physician"
                            }
                        ],
                        "period": {
                            "start": "2018-02-16T18:20:53.000Z"
                        },
                        "individual": {
                            "reference": "Practitioner/4664007",
                            "display": "Hopper, Grace"
                        }
                    }
                ],
                "period": {
                    "start": "2018-10-23T15:30:00.000Z"
                },
                "reason": [
                    {
                        "text": "Pleuritic Chest Pain"
                    }
                ],
                "location": [
                    {
                        "location": {
                            "reference": "Location/4048278",
                            "display": "Baseline East Medical Center, BE Hospital, BE Cardiology"
                        },
                        "status": "active"
                    }
                ],
                "serviceProvider": {
                    "reference": "Organization/619848"
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Observation",
  "patient": "3998008",
  "code": "http://snomed.info/sct|229819007",
  "startDate": "2014-09-24",
  "endDate": "2016-10-12"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "ed46f4c9-61e9-4cc0-b3ec-1505616ffdc1",
    "type": "searchset",
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Observation?code=http%3A%2F%2Fsnomed.info%2Fsct%7C229819007&patient=4342008&_lastUpdated=ge2014-09-24&_lastUpdated=lt2016-10-12&_count=50"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Observation/93-7050369",
            "resource": {
                "resourceType": "Observation",
                "id": "93-7050369",
                "meta": {
                    "versionId": "7050369",
                    "lastUpdated": "2017-08-04T15:26:40.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Observation</b></p><p><b>Patient</b>: 4342008</p><p><b>Date</b>: Aug  4, 2017  3:26 P.M. UTC</p><p><b>Status</b>: Final</p><p><b>Category</b>: Social History</p><p><b>Code</b>: Tobacco</p></div>"
                },
                "status": "final",
                "category": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/observation-category",
                            "code": "social-history",
                            "display": "Social History"
                        }
                    ],
                    "text": "Social History"
                },
                "code": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "229819007",
                            "display": "Tobacco use and exposure (observable entity)"
                        },
                        {
                            "system": "http://loinc.org",
                            "code": "72166-2"
                        }
                    ],
                    "text": "Tobacco"
                },
                "subject": {
                    "reference": "Patient/4342008"
                },
                "issued": "2017-08-04T15:26:40.000Z",
                "valueCodeableConcept": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "25594002",
                            "display": "Moderate risk of (contextual qualifier) (qualifier value)"
                        }
                    ],
                    "text": "Medium Risk"
                },
                "related": [
                    {
                        "type": "has-member",
                        "target": {
                            "reference": "Observation/7050369-q6930400"
                        }
                    },
                    {
                        "type": "has-member",
                        "target": {
                            "reference": "Observation/7050369-q6930404"
                        }
                    }
                ]
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Observation/7050369-q6930400",
            "resource": {
                "resourceType": "Observation",
                "id": "7050369-q6930400",
                "meta": {
                    "versionId": "7050369",
                    "lastUpdated": "2017-08-04T15:26:40.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Observation</b></p><p><b>Patient</b>: 4342008</p><p><b>Date</b>: Aug  4, 2017  3:26 P.M. UTC</p><p><b>Status</b>: Final</p><p><b>Category</b>: Social History</p><p><b>Question</b>: SHX Tobacco use</p><p><b>Response</b>: Current some day smoker</p></div>"
                },
                "status": "final",
                "category": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/observation-category",
                            "code": "social-history",
                            "display": "Social History"
                        }
                    ],
                    "text": "Social History"
                },
                "code": {
                    "coding": [
                        {
                            "system": "http://loinc.org",
                            "code": "72166-2"
                        }
                    ],
                    "text": "SHX Tobacco use"
                },
                "subject": {
                    "reference": "Patient/4342008"
                },
                "issued": "2017-08-04T15:26:40.000Z",
                "valueCodeableConcept": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "428041000124106",
                            "display": "Occasional tobacco smoker (finding)"
                        }
                    ],
                    "text": "Current some day smoker"
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Observation/7050369-q6930404",
            "resource": {
                "resourceType": "Observation",
                "id": "7050369-q6930404",
                "meta": {
                    "versionId": "7050369",
                    "lastUpdated": "2017-08-04T15:26:40.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Observation</b></p><p><b>Patient</b>: 4342008</p><p><b>Date</b>: Aug  4, 2017  3:26 P.M. UTC</p><p><b>Status</b>: Final</p><p><b>Category</b>: Social History</p><p><b>Question</b>: SHX Tobacco type</p><p><b>Response</b>: Cigarettes</p></div>"
                },
                "status": "final",
                "category": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/observation-category",
                            "code": "social-history",
                            "display": "Social History"
                        }
                    ],
                    "text": "Social History"
                },
                "code": {
                    "text": "SHX Tobacco type"
                },
                "subject": {
                    "reference": "Patient/4342008"
                },
                "issued": "2017-08-04T15:26:40.000Z",
                "valueCodeableConcept": {
                    "text": "Cigarettes"
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Patient",
  "id": "4342009"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "b7cbc5ca-e4a1-4032-a8cb-cd5a15282a77",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient?_id=4342009"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient/4342009",
            "resource": {
                "resourceType": "Patient",
                "id": "4342009",
                "meta": {
                    "versionId": "34",
                    "lastUpdated": "2018-10-18T06:18:28.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Patient</b></p><p><b>Name</b>: SMART, NANCY</p><p><b>DOB</b>: Aug 11, 1980</p><p><b>Administrative Gender</b>: Female</p><p><b>Marital Status</b>: Married</p><p><b>Status</b>: Active</p></div>"
                },
                "extension": [
                    {
                        "url": "http://fhir.org/guides/argonaut/StructureDefinition/argo-race",
                        "extension": [
                            {
                                "url": "ombCategory",
                                "valueCoding": {
                                    "system": "http://hl7.org/fhir/v3/Race",
                                    "code": "2106-3",
                                    "display": "White",
                                    "userSelected": false
                                }
                            },
                            {
                                "url": "text",
                                "valueString": "White"
                            }
                        ]
                    }
                ],
                "identifier": [
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "MR",
                                    "display": "Medical record number",
                                    "userSelected": false
                                }
                            ],
                            "text": "MRN"
                        },
                        "system": "urn:oid:1.1.1.1.1.1",
                        "value": "10002701",
                        "period": {
                            "start": "2016-06-22T20:43:05.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "type": {
                            "text": "Messaging"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.8",
                        "value": "B3F1E729F3804CE78EE48A077965FA15",
                        "period": {
                            "start": "2018-09-13T16:39:25.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "URN:CERNER:IDENTITY-FEDERATION:REALM:0B8A0111-E8E6-4C26-A91C-5069CBC6B1CA:PRINCIPAL:ABC123",
                        "period": {
                            "start": "2017-09-26T05:00:00.000Z",
                            "end": "2019-01-02T05:00:00.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "URN:CERNER:IDENTITY-FEDERATION:REALM:687F29DD-69DD-4DE5-ACB1-FD8A2241EF3A:PRINCIPAL:YP2QT7JS2SA",
                        "period": {
                            "start": "2016-11-01T10:00:00.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "urn:cerner:identity-federation:realm:687f29dd-69dd-4de5-acb1-fd8a2241ef3a:principal:YP2qT7jS2sa",
                        "period": {
                            "start": "2016-11-01T10:00:00.000Z"
                        }
                    }
                ],
                "active": true,
                "name": [
                    {
                        "use": "official",
                        "text": "SMART, NANCY",
                        "family": [
                            "SMART"
                        ],
                        "given": [
                            "NANCY"
                        ],
                        "period": {
                            "start": "2016-06-22T20:43:05.000Z"
                        }
                    }
                ],
                "telecom": [
                    {
                        "system": "email",
                        "value": "kathy.pickering@cerner.com",
                        "use": "home",
                        "period": {
                            "start": "2018-09-13T16:37:32.000Z"
                        }
                    }
                ],
                "gender": "female",
                "birthDate": "1980-08-11",
                "maritalStatus": {
                    "coding": [
                        {
                            "system": "http://hl7.org/fhir/v3/MaritalStatus",
                            "code": "M",
                            "display": "Married",
                            "userSelected": false
                        }
                    ],
                    "text": "Married"
                },
                "contact": [
                    {
                        "relationship": [
                            {
                                "text": "Authorized Representative"
                            }
                        ],
                        "name": {
                            "use": "official",
                            "text": "SMART, JOE",
                            "family": [
                                "SMART"
                            ],
                            "given": [
                                "JOE"
                            ],
                            "period": {
                                "start": "2016-06-22T21:06:59.000Z"
                            }
                        },
                        "telecom": [
                            {
                                "system": "phone",
                                "value": "9139898765",
                                "use": "home",
                                "period": {
                                    "start": "2017-06-27T21:47:16.000Z"
                                }
                            },
                            {
                                "system": "phone",
                                "value": "9137876555",
                                "use": "mobile",
                                "period": {
                                    "start": "2017-06-27T21:47:16.000Z"
                                }
                            },
                            {
                                "system": "email",
                                "value": "kathy.pickering@cerner.com",
                                "use": "home",
                                "period": {
                                    "start": "2018-09-13T16:43:28.000Z"
                                }
                            }
                        ],
                        "address": {
                            "use": "home",
                            "text": "1234 Blvd\nOverland Park, KS 66213\nUSA",
                            "line": [
                                "1234 Blvd"
                            ],
                            "city": "Overland Park",
                            "district": "Johnson",
                            "state": "KS",
                            "postalCode": "66213",
                            "country": "USA",
                            "period": {
                                "start": "2017-06-27T21:47:16.000Z"
                            }
                        },
                        "gender": "male",
                        "period": {
                            "start": "2017-07-07T18:28:24.000Z",
                            "end": "2017-09-20T15:18:54.000Z"
                        }
                    },
                    {
                        "relationship": [
                            {
                                "text": "Authorized Representative"
                            }
                        ],
                        "name": {
                            "use": "official",
                            "text": "SMART, JOE",
                            "family": [
                                "SMART"
                            ],
                            "given": [
                                "JOE"
                            ],
                            "period": {
                                "start": "2016-06-22T21:06:59.000Z"
                            }
                        },
                        "telecom": [
                            {
                                "system": "phone",
                                "value": "9139898765",
                                "use": "home",
                                "period": {
                                    "start": "2017-06-27T21:47:16.000Z"
                                }
                            },
                            {
                                "system": "phone",
                                "value": "9137876555",
                                "use": "mobile",
                                "period": {
                                    "start": "2017-06-27T21:47:16.000Z"
                                }
                            },
                            {
                                "system": "email",
                                "value": "kathy.pickering@cerner.com",
                                "use": "home",
                                "period": {
                                    "start": "2018-09-13T16:43:28.000Z"
                                }
                            }
                        ],
                        "address": {
                            "use": "home",
                            "text": "1234 Blvd\nOverland Park, KS 66213\nUSA",
                            "line": [
                                "1234 Blvd"
                            ],
                            "city": "Overland Park",
                            "district": "Johnson",
                            "state": "KS",
                            "postalCode": "66213",
                            "country": "USA",
                            "period": {
                                "start": "2017-06-27T21:47:16.000Z"
                            }
                        },
                        "gender": "male",
                        "period": {
                            "start": "2017-06-09T13:46:54.000Z",
                            "end": "2017-06-20T15:28:11.000Z"
                        }
                    }
                ],
                "careProvider": [
                    {
                        "reference": "Practitioner/1912007",
                        "display": "McCurdy, Michael"
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Person",
  "identifier": "urn%3Aoid%3A2.16.840.1.113883.3.13.6%7Curn%3Acerner%3Aidentity-federation%3Arealm%3A687f29dd-69dd-4de5-acb1-fd8a2241ef3a%3Aprincipal%3AEC4Ax54P8GI"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "e7bea039-84a8-4177-b040-5cc6bf8bab3a",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Person?identifier=urn%3Aoid%3A2.16.840.1.113883.3.13.6%7Curn%3Acerner%3Aidentity-federation%3Arealm%3A687f29dd-69dd-4de5-acb1-fd8a2241ef3a%3Aprincipal%3AEC4Ax54P8GI"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Person/1316024",
            "resource": {
                "resourceType": "Person",
                "id": "1316024",
                "meta": {
                    "versionId": "35",
                    "lastUpdated": "2017-08-31T19:30:35.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Person</b></p><p><b>Name</b>: PETERS, TIMOTHY</p><p><b>DOB</b>: Apr 30, 1961</p><p><b>Administrative Gender</b>: Male</p><p><b>Status</b>: Active</p></div>"
                },
                "identifier": [
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "URN:CERNER:IDENTITY-FEDERATION:REALM:687F29DD-69DD-4DE5-ACB1-FD8A2241EF3A:PRINCIPAL:EC4AX54P8GI",
                        "period": {
                            "start": "2016-11-01T10:00:00.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "NEW-FEDPRINCIPAL-ALIAS-12212016",
                        "period": {
                            "start": "2016-01-02T05:00:00.000Z",
                            "end": "2017-01-02T05:00:00.000Z"
                        }
                    }
                ],
                "name": [
                    {
                        "use": "official",
                        "text": "PETERS, TIMOTHY",
                        "family": [
                            "PETERS"
                        ],
                        "given": [
                            "TIMOTHY"
                        ],
                        "period": {
                            "start": "2012-05-17T14:54:31.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "given": [
                            "TIM"
                        ],
                        "period": {
                            "start": "2012-05-22T15:45:50.000Z"
                        }
                    }
                ],
                "telecom": [
                    {
                        "system": "phone",
                        "value": "1231231231",
                        "use": "work",
                        "period": {
                            "start": "2013-03-11T07:17:03.000Z"
                        }
                    },
                    {
                        "system": "phone",
                        "value": "8168229121",
                        "use": "home",
                        "period": {
                            "start": "2012-05-17T15:33:18.000Z"
                        }
                    },
                    {
                        "system": "phone",
                        "value": "8162324455",
                        "use": "mobile",
                        "period": {
                            "start": "2013-01-30T14:56:59.000Z"
                        }
                    }
                ],
                "gender": "male",
                "birthDate": "1961-04-30",
                "address": [
                    {
                        "use": "home",
                        "text": "9430 Blue Ridge Blvd\nKansas City, MO 64199\nUSA",
                        "line": [
                            "9430 Blue Ridge Blvd"
                        ],
                        "city": "Kansas City",
                        "district": "Jackson",
                        "state": "MO",
                        "postalCode": "64199",
                        "country": "USA",
                        "period": {
                            "start": "2012-05-17T15:33:18.000Z"
                        }
                    }
                ],
                "active": true
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Practitioner",
  "id": "1994021"
}
```

**Sample response**
```json
{
    "resourceType": "Practitioner",
    "id": "1994021",
    "meta": {
        "versionId": "0",
        "lastUpdated": "2013-11-04T13:25:17.000-06:00"
    },
    "text": {
        "status": "generated",
        "div": "<div><p><b>Practitioner</b></p><p><b>Name</b>: PCTAUT, OrdersPhy3</p><p><b>Identifiers</b>: DOCDEA: 234234123</p><p><b>Gender</b>: Male</p><p><b>Status</b>: Active</p></div>"
    },
    "identifier": [
        {
            "use": "usual",
            "type": {
                "text": "DOCDEA"
            },
            "value": "234234123",
            "period": {
                "start": "2013-11-08T00:00:00.000-06:00"
            }
        }
    ],
    "active": true,
    "name": {
        "use": "usual",
        "text": "PCTAUT, OrdersPhy3",
        "family": [
            "PCTAUT"
        ],
        "given": [
            "OrdersPhy3"
        ],
        "period": {
            "start": "2013-11-04T13:25:17.000-06:00"
        }
    },
    "telecom": [
        {
            "system": "phone",
            "value": "8165550192",
            "use": "work"
        }
    ],
    "address": [
        {
            "use": "work",
            "text": "123 Main St.\nBirmingham, AL 56265\nUSA",
            "line": [
                "123 Main St."
            ],
            "city": "Birmingham",
            "state": "AL",
            "postalCode": "56265",
            "country": "USA"
        }
    ],
    "gender": "male"
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Procedure",
  "id": "24110557"
}
```
**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "8c9814d7-145c-499f-b138-a841c86a5d44",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Procedure?_id=24110557"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Procedure/24110557",
            "resource": {
                "resourceType": "Procedure",
                "id": "24110557",
                "meta": {
                    "versionId": "1",
                    "lastUpdated": "2014-09-16T22:49:27.000Z"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Procedure</b></p><p><b>Subject</b>: Houde, Test 1</p><p><b>Code</b>: Influenza</p><p><b>Status</b>: Completed</p><p><b>Notes</b>: <ul><li>Testing this influenza</li></ul></p></div>"
                },
                "subject": {
                    "reference": "Patient/1316020",
                    "display": "Houde, Test 1"
                },
                "status": "completed",
                "code": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "348046004",
                            "display": "Influenza (split virion) vaccine injection suspension 0.5mL prefilled syringe (product)"
                        }
                    ],
                    "text": "Influenza"
                },
                "performedDateTime": "2014-09-16T00:00:00.000-05:00",
                "encounter": {
                    "reference": "Encounter/2457909"
                },
                "notes": [
                    {
                        "authorReference": {
                            "reference": "Practitioner/1590015",
                            "display": "Herrman, Greg"
                        },
                        "time": "2014-09-16T21:35:32.000Z",
                        "text": "Testing this influenza"
                    }
                ]
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "RelatedPerson",
  "patient": "3838011"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "85b2ff80-706d-4e88-9579-29c82246e7d2",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/RelatedPerson?patient=3838011"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/RelatedPerson/5796399",
            "resource": {
                "resourceType": "RelatedPerson",
                "id": "5796399",
                "meta": {
                    "versionId": "35"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>RelatedPerson</b></p><p><b>Name</b>: PETERS, TIMOTHY</p><p><b>DOB</b>: Apr 30, 1961</p><p><b>Sex</b>: Male</p></div>"
                },
                "identifier": [
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "URN:CERNER:IDENTITY-FEDERATION:REALM:687F29DD-69DD-4DE5-ACB1-FD8A2241EF3A:PRINCIPAL:EC4AX54P8GI",
                        "period": {
                            "start": "2016-11-01T10:00:00.000Z"
                        }
                    },
                    {
                        "use": "usual",
                        "type": {
                            "coding": [
                                {
                                    "system": "http://hl7.org/fhir/v2/0203",
                                    "code": "AN",
                                    "display": "Account number",
                                    "userSelected": false
                                }
                            ],
                            "text": "Federated Person Principal"
                        },
                        "system": "urn:oid:2.16.840.1.113883.3.13.6",
                        "value": "NEW-FEDPRINCIPAL-ALIAS-12212016",
                        "period": {
                            "start": "2016-01-02T05:00:00.000Z",
                            "end": "2017-01-02T05:00:00.000Z"
                        }
                    }
                ],
                "patient": {
                    "reference": "Patient/3838011",
                    "display": "Peters, Jennifer"
                },
                "name": {
                    "use": "official",
                    "text": "PETERS, TIMOTHY",
                    "family": [
                        "PETERS"
                    ],
                    "given": [
                        "TIMOTHY"
                    ],
                    "period": {
                        "start": "2012-05-17T14:54:31.000Z"
                    }
                },
                "telecom": [
                    {
                        "system": "phone",
                        "value": "1231231231",
                        "use": "work",
                        "period": {
                            "start": "2013-03-11T07:17:03.000Z"
                        }
                    },
                    {
                        "system": "phone",
                        "value": "8168229121",
                        "use": "home",
                        "period": {
                            "start": "2012-05-17T15:33:18.000Z"
                        }
                    },
                    {
                        "system": "phone",
                        "value": "8162324455",
                        "use": "mobile",
                        "period": {
                            "start": "2013-01-30T14:56:59.000Z"
                        }
                    }
                ],
                "gender": "male",
                "birthDate": "1961-04-30",
                "address": [
                    {
                        "use": "home",
                        "text": "9430 Blue Ridge Blvd\nKansas City, MO 64199\nUSA",
                        "line": [
                            "9430 Blue Ridge Blvd"
                        ],
                        "city": "Kansas City",
                        "district": "Jackson",
                        "state": "MO",
                        "postalCode": "64199",
                        "country": "USA",
                        "period": {
                            "start": "2012-05-17T15:33:18.000Z"
                        }
                    }
                ],
                "period": {
                    "start": "2015-10-30T06:50:09.000Z"
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Scehdule",
  "id": "21265426-633867-3121665-0,21265426-633867-3121665-15"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "f861d6c1-b266-45ac-8654-8d39f283b01a",
    "type": "searchset",
    "total": 2,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Schedule?_id=21265426-633867-3121665-0%2C21265426-633867-3121665-15"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Schedule/21265426-633867-3121665-15",
            "resource": {
                "resourceType": "Schedule",
                "id": "21265426-633867-3121665-15",
                "text": {
                    "status": "extensions",
                    "div": "<div><p><b>Schedule</b></p><p><b>Type</b>: Same Day</p><p><b>Practitioner</b>: Howdeshell, Tami</p><p><b>Location</b>: Baseline West</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/633867",
                            "display": "Baseline West"
                        }
                    }
                ],
                "type": [
                    {
                        "coding": [
                            {
                                "system": "http://snomed.info/sct",
                                "code": "394581000",
                                "display": "Community medicine"
                            }
                        ],
                        "text": "Same Day"
                    }
                ],
                "actor": {
                    "reference": "Practitioner/2578010",
                    "display": "Howdeshell, Tami"
                }
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Schedule/21265426-633867-3121665-0",
            "resource": {
                "resourceType": "Schedule",
                "id": "21265426-633867-3121665-0",
                "text": {
                    "status": "extensions",
                    "div": "<div><p><b>Schedule</b></p><p><b>Type</b>: Same Day</p><p><b>Practitioner</b>: Howdeshell, Tami</p><p><b>Location</b>: Baseline West</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/633867",
                            "display": "Baseline West"
                        }
                    }
                ],
                "type": [
                    {
                        "coding": [
                            {
                                "system": "http://snomed.info/sct",
                                "code": "394581000",
                                "display": "Community medicine"
                            }
                        ],
                        "text": "Same Day"
                    }
                ],
                "actor": {
                    "reference": "Practitioner/2578010",
                    "display": "Howdeshell, Tami"
                }
            }
        }
    ]
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
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Slot",
  "scheduleActor": "2578010",
  "start": "2016",
  "slotType": "http://snomed.info/sct|394581000",
  "count": "5"
}
```

**Sample response**
```json
{
    "resourceType": "Bundle",
    "id": "c6cced00-976a-4aaa-846b-9607f72aff82",
    "type": "searchset",
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot?slot-type=http%3A%2F%2Fsnomed.info%2Fsct%7C394581000&schedule.actor=Practitioner%2F2578010&start=2016&_count=5"
        },
        {
            "relation": "next",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot?-pageContext=ea02e976-c9ee-440b-a1f1-e87fb1d570a7&-pageDirection=NEXT"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot/21265426-4048128-3121781-360",
            "resource": {
                "resourceType": "Slot",
                "id": "21265426-4048128-3121781-360",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2015-06-10T10:40:33.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Slot</b></p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Jan 30, 2016  8:00 P.M. UTC</p><p><b>End</b>: Jan 30, 2016  9:00 P.M. UTC</p><p><b>Status</b>: Free</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/4048128"
                        }
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "schedule": {
                    "reference": "Schedule/21265426-4048128-3121781-360"
                },
                "freeBusyType": "free",
                "start": "2016-01-30T14:00:00.000-06:00",
                "end": "2016-01-30T15:00:00.000-06:00"
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot/21265426-633867-3121781-360",
            "resource": {
                "resourceType": "Slot",
                "id": "21265426-633867-3121781-360",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2015-06-10T10:40:33.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Slot</b></p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Jan 30, 2016  8:00 P.M. UTC</p><p><b>End</b>: Jan 30, 2016  9:00 P.M. UTC</p><p><b>Status</b>: Free</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/633867"
                        }
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "schedule": {
                    "reference": "Schedule/21265426-633867-3121781-360"
                },
                "freeBusyType": "free",
                "start": "2016-01-30T14:00:00.000-06:00",
                "end": "2016-01-30T15:00:00.000-06:00"
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot/21265426-4048128-3121781-365",
            "resource": {
                "resourceType": "Slot",
                "id": "21265426-4048128-3121781-365",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2015-06-10T10:40:33.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Slot</b></p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Jan 30, 2016  8:05 P.M. UTC</p><p><b>End</b>: Jan 30, 2016  9:05 P.M. UTC</p><p><b>Status</b>: Free</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/4048128"
                        }
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "schedule": {
                    "reference": "Schedule/21265426-4048128-3121781-365"
                },
                "freeBusyType": "free",
                "start": "2016-01-30T14:05:00.000-06:00",
                "end": "2016-01-30T15:05:00.000-06:00"
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot/21265426-633867-3121781-365",
            "resource": {
                "resourceType": "Slot",
                "id": "21265426-633867-3121781-365",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2015-06-10T10:40:33.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Slot</b></p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Jan 30, 2016  8:05 P.M. UTC</p><p><b>End</b>: Jan 30, 2016  9:05 P.M. UTC</p><p><b>Status</b>: Free</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/633867"
                        }
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "schedule": {
                    "reference": "Schedule/21265426-633867-3121781-365"
                },
                "freeBusyType": "free",
                "start": "2016-01-30T14:05:00.000-06:00",
                "end": "2016-01-30T15:05:00.000-06:00"
            }
        },
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Slot/21265426-4048128-3121781-370",
            "resource": {
                "resourceType": "Slot",
                "id": "21265426-4048128-3121781-370",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2015-06-10T10:40:33.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Slot</b></p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Jan 30, 2016  8:10 P.M. UTC</p><p><b>End</b>: Jan 30, 2016  9:10 P.M. UTC</p><p><b>Status</b>: Free</p></div>"
                },
                "extension": [
                    {
                        "url": "https://fhir-ehr.cerner.com/dstu2/StructureDefinition/scheduling-location",
                        "valueReference": {
                            "reference": "Location/4048128"
                        }
                    }
                ],
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "schedule": {
                    "reference": "Schedule/21265426-4048128-3121781-370"
                },
                "freeBusyType": "free",
                "start": "2016-01-30T14:10:00.000-06:00",
                "end": "2016-01-30T15:10:00.000-06:00"
            }
        }
    ]
}
```
**Related cerner documentation**
[https://fhir.cerner.com/millennium/dstu2/scheduling/slot/#search](https://fhir.cerner.com/millennium/dstu2/scheduling/slot/#search)

## Sample Configuration
Following is a sample proxy service that illustrates how to connect to Cerner with the init operation and use the searchAppointment operation. The sample request for this proxy can be found in searchAppointment sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse" name="searchAppointment"
       statistics="disable" trace="disable" transports="https,http" startOnLoad="true">
    <target>
        <inSequence>
            <property name="base" expression="json-eval($.base)"/>
            <property name="type" expression="json-eval($.type)"/>
            <property name="date" expression="json-eval($.date)"/>
            <property name="patient" expression="json-eval($.patient)"/>
            <property name="accessToken" expression="json-eval($.accessToken)"/>
            <cerner.init>
                <base>{$ctx:base}</base>
            </cerner.init>
            <cerner.searchAppointment>
                <type>{$ctx:type}</type>
                <date>{$ctx:date}</date>
                <patient>{$ctx:patient}</patient>
            </cerner.searchAppointment>
            <send/>
        </inSequence>
        <outSequence/>
        <faultSequence/>
    </target>
    <parameter name="serviceType">proxy</parameter>
    <description/>
</proxy>
```

2. Create a json file called `searchAppointment.json` containing the following json:
```json
{
  "base": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca",
  "type": "Appointment",
  "date": "2017-10-04",
  "patient": "4704007"
}
```
3. Execute the following cURL command:
    ```curl
    curl http://localhost:8280/services/searchAppointment -d @searchAppointment.json
    ```
4. cerner will return a json response as below
```json
{
    "resourceType": "Bundle",
    "id": "963bc706-8ffe-4f27-8057-40ac5db06870",
    "type": "searchset",
    "total": 1,
    "link": [
        {
            "relation": "self",
            "url": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Appointment?date=2017-10-04T08%3A00%3A00.000-05%3A00&patient=4704007&status=booked&_count=5"
        }
    ],
    "entry": [
        {
            "fullUrl": "https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Appointment/3005756",
            "resource": {
                "resourceType": "Appointment",
                "id": "3005756",
                "meta": {
                    "versionId": "0",
                    "lastUpdated": "2017-10-04T13:06:34.000-05:00"
                },
                "text": {
                    "status": "generated",
                    "div": "<div><p><b>Appointment</b></p><p><b>Description</b>: Same Day</p><p><b>Type</b>: Same Day</p><p><b>Start</b>: Oct  4, 2017  1:00 P.M. UTC</p><p><b>End</b>: Oct  4, 2017  2:00 P.M. UTC</p><p><b>Duration</b>: 60 Minutes</p><p><b>Status</b>: Booked</p><p><b>Location</b>: Baseline East</p><p><b>Participants</b>:</p><p><b>Patient</b>: Smart, Barney R</p><br /><p><b>Practitioner</b>: Howdeshell, Tami</p><p><b>Primary</b>: Yes</p></div>"
                },
                "status": "booked",
                "type": {
                    "coding": [
                        {
                            "system": "http://snomed.info/sct",
                            "code": "394581000",
                            "display": "Community medicine",
                            "userSelected": false
                        },
                        {
                            "system": "https://fhir.cerner.com/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/codeSet/14249",
                            "code": "21265426",
                            "display": "Same Day",
                            "userSelected": true
                        }
                    ],
                    "text": "Same Day"
                },
                "description": "Same Day",
                "start": "2017-10-04T08:00:00.000-05:00",
                "end": "2017-10-04T09:00:00.000-05:00",
                "minutesDuration": 60,
                "participant": [
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "extension": [
                                            {
                                                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                                                "valueCode": "unknown"
                                            }
                                        ]
                                    }
                                ],
                                "text": "Resource"
                            },
                            {
                                "coding": [
                                    {
                                        "system": "http://hl7.org/fhir/v3/ParticipationType",
                                        "code": "PPRF",
                                        "display": "primary performer",
                                        "userSelected": false
                                    }
                                ]
                            }
                        ],
                        "actor": {
                            "reference": "Practitioner/2578010",
                            "display": "Howdeshell, Tami"
                        },
                        "required": "required",
                        "status": "accepted"
                    },
                    {
                        "type": [
                            {
                                "coding": [
                                    {
                                        "extension": [
                                            {
                                                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                                                "valueCode": "unknown"
                                            }
                                        ]
                                    }
                                ],
                                "text": "Patient"
                            }
                        ],
                        "actor": {
                            "reference": "Patient/4704007",
                            "display": "Smart, Barney R"
                        },
                        "required": "required",
                        "status": "accepted"
                    },
                    {
                        "actor": {
                            "reference": "Location/4048128",
                            "display": "Baseline East"
                        },
                        "required": "required",
                        "status": "accepted"
                    }
                ]
            }
        }
    ]
}
```