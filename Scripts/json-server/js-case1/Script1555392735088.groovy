import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.HttpBodyContent as HttpBodyContent
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import java.util.List as List
import java.util.concurrent.locks.Condition as Condition
import java.util.ArrayList as ArrayList

//신규 POST object
def request = ((findTestObject('json-server/PostCommand')) as RequestObject)

String body = '{ "id": 12, "title": "TCOE TEST12", "author": "TCOE12"}'

try {
	request.setBodyContent(new HttpTextBodyContent(body, 'UTF-8', 'application/json'))

	//request.setRestUrl("http://localhost:3000/posts/1")
	def url = request.getRestUrl()

	//url = url.replace('{postid}', '1')

	request.setRestUrl(url)
}
catch (Exception ex) {
	println(ex.detailMessage)
}

//Make POST request 실행
WS.sendRequest(request)

//Verify response with GET
def response = ((findTestObject('json-server/GET_Exam1')) as RequestObject)

List<TestObjectProperty> params = new ArrayList()

params.add(new TestObjectProperty('id', ConditionType.EQUALS, '12'))

response.setRestParameters(params)

//Make GET Request
def result = WS.sendRequest(response, FailureHandling.CONTINUE_ON_FAILURE)

//Verify title from response
WS.verifyElementPropertyValue(result, 'title', '[TCOE TEST12]', FailureHandling.STOP_ON_FAILURE)

//신규 등록한 id:12를 UPDATE
request = ((findTestObject('json-server/PUT_Exam2')) as RequestObject)

body = '{ "id": 12, "title": "TCOE TEST21", "author": "TCOE21"}'

try {
	request.setBodyContent(new HttpTextBodyContent(body, 'UTF-8', 'application/json'))

	//request.setRestUrl("http://localhost:3000/posts/1")
	url = request.getRestUrl()

	url = url.replace('{postid}', '12')

	request.setRestUrl(url)
}
catch (Exception ex) {
	println(ex.detailMessage)
}

//Make PUT request
WS.sendRequest(request)

//update 결과 Verify response with GET
response = ((findTestObject('json-server/GET_Exam1')) as RequestObject)

//List<TestObjectProperty> params = new ArrayList()
params = new ArrayList()

params.add(new TestObjectProperty('id', ConditionType.EQUALS, '12'))

response.setRestParameters(params)

//Make GET Request
result = WS.sendRequest(response, FailureHandling.CONTINUE_ON_FAILURE)

//Verify title from response
WS.verifyElementPropertyValue(result, 'title', '[TCOE TEST21]', FailureHandling.STOP_ON_FAILURE)

