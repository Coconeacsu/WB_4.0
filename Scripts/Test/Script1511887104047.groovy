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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.maximizeWindow(FailureHandling.OPTIONAL)

WebUI.navigateToUrl('https://staging-primotours-webbooking.tourpaq.com/ThankYouForBooking.aspx?hash=9C8E9B5254C98076E1DA5E0CAD65E8D26CDFFA63')

'Wait for TY page to load'
WebUI.waitForPageLoad(30)

'Wait for TY page to load'
WebUI.waitForJQueryLoad(30, FailureHandling.OPTIONAL)

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 30, FailureHandling.OPTIONAL)

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementNotVisible(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 30, FailureHandling.OPTIONAL)

'Wait for booking to be placed, max 30 seconds'
WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingNoContainer'), 40)

'Wait for booking to be placed, max 30 seconds'
WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingNoContainer'), 40)

'Check TY page contains important elements'
WebUI.verifyElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingNoContainer'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingTotalInfo'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingTotalPriceBar'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/printTicketSpan'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/ThankYouPage/printTicketSpan'), 2)

'Print ticket click'
WebUI.click(findTestObject('PrimoTours/Old Objects/ThankYouPage/printTicketSpan'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/cCenterButton'), 2)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/ThankYouPage/cCenterButton'), 2)

'Login to CC click'
WebUI.click(findTestObject('PrimoTours/Old Objects/ThankYouPage/cCenterButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(30)

WebUI.waitForJQueryLoad(30)

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 30)

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementNotVisible(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 30)

'Check bookingNo is in the page in CCenter'
WebUI.verifyElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingNoContainer'), FailureHandling.STOP_ON_FAILURE)

'Check bookingTotal is in the page in CCenter'
WebUI.verifyElementVisible(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingTotalPriceBar'), FailureHandling.STOP_ON_FAILURE)

