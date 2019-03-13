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

WS.sendRequest(findTestObject('UserRestService/ListUsers'))

def response = WS.sendRequestAndVerify(findTestObject('UserRestService/ListUsers'))

WS.verifyElementPropertyValue(response, 'data[2].first_name', 'Tracey')

WS.verifyElementPropertyValue(response, 'data[2].id', '6')

WS.verifyElementsCount(response, 'data', 2, FailureHandling.CONTINUE_ON_FAILURE)

WS.verifyResponseStatusCodeInRange(response, 100, 200)

