<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>BrowseNodeLookup</name>
   <tag></tag>
   <elementGuidId>6c840cc2-a96b-402d-bb9b-f92caa8e9bb7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?>&lt;SOAP-ENV:Envelope xmlns:SOAP-ENV=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot; xmlns:tns=&quot;http://webservices.amazon.com/AWSECommerceService/2011-08-01&quot;>
  &lt;SOAP-ENV:Header/>
  &lt;SOAP-ENV:Body>
    &lt;tns:BrowseNodeLookup>
      &lt;tns:MarketplaceDomain>?&lt;/tns:MarketplaceDomain>
      &lt;tns:AWSAccessKeyId>?&lt;/tns:AWSAccessKeyId>
      &lt;tns:AssociateTag>?&lt;/tns:AssociateTag>
      &lt;tns:Validate>?&lt;/tns:Validate>
      &lt;tns:XMLEscaping>?&lt;/tns:XMLEscaping>
      &lt;tns:Shared>?&lt;/tns:Shared>
      &lt;tns:Request>?&lt;/tns:Request>
    &lt;/tns:BrowseNodeLookup>
  &lt;/SOAP-ENV:Body>
&lt;/SOAP-ENV:Envelope>
</soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>BrowseNodeLookup</soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress>http://webservices.amazon.com/AWSECommerceService/AWSECommerceService.wsdl</wsdlAddress>
</WebServiceRequestEntity>
