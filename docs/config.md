
# Configuring Cerner Operations
[[Initializing the connector]](#initializing-the-connector)  [[Additional Information]](#additional-information)

## Initializing the connector
To use the Cerner connector, add the <cerner.init> element in your configuration before carrying out any Cerner operations.

**init**
```xml
<cerner.init>
	<base>{$ctx:baseUrl}></base>
</cerner.init>
```
**Properties**

* baseUrl: The API URL to access the endpoint. Eg: <https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/>

> Note:The API Url details can be accessed through - https://fhir.cerner.com/millennium/dstu2/#service-root-url

## Additional Information

Be sure to add and enable the following Axis2 configurations in the <EI_HOME>/conf/axis2/axis2.xml file.


Required message formatters

**messageFormatters**
```xml
<messageFormatter contentType="application/json+fhir" class="org.apache.synapse.commons.json.JsonStreamFormatter"/>
```
Required message builders

**messageBuilders**
```xml
<messageBuilder contentType="application/json+fhir" class="org.apache.synapse.commons.json.JsonStreamBuilder"/>
```
>Note: The secure sandBox needs authentication, Refer: [https://fhir.cerner.com/authorization/](https://fhir.cerner.com/authorization/)

Now that you have connected to cerner connector,  check [Working with the Cerner Connector](operation.md) to perform various operations with the connector.
