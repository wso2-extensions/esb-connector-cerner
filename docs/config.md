
# Configuring Cerner Operations
[[Initializing the connector]](#initializing-the-connector)  [[Additional Information]](#additional-information)

## Initializing the connector
To use the Cerner connector, add the <cerner.init> element in your configuration before carrying out any Cerner operations.
The <cerner.init> element authenticates the user using the OAuth2 authentication and allows them to access the Cerner registered client applications and secure sandbox.
For more information on authorizing requests in Cerner, see [API Doc](https://fhir.cerner.com/authorization/).


**init**
```xml
<cerner.init>
	<base>{$ctx:baseUrl}></base>
	<accessToken>{$ctx:accessToken}</accessToken>
</cerner.init>
```
**Properties**

* baseUrl: The API URL to access the endpoint. Eg: <https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/>
* accessToken: Access token obtained when using Cerner registered applications and secure sandbox.

> Note: Access token is not necessary when open sandbox is used.

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

Now that you have configured the Cerner connector, see [Working with the Cerner Connector](operation.md) to perform various operations using the connector.