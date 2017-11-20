import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.invoke.LambdaForm.Name as Name
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow(FailureHandling.OPTIONAL)

WebUI.navigateToUrl(WbUrl)

/*InternalData paxDetails = findTestData("WB_Primo/Passenger_details")

Random random = new Random()
Number randomPaxIndex = random.nextInt(10 ** paxDetails.getRowNumbers());*/
WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstName'), 
    'Cornel')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastName'), 'Neacsu - Automated')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerAddress'), 
    'Home address')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPostcode'), 
    '6700')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerEmail'), 
    'cornel.neacsu@roweb.ro')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPhone'), 
    '12345678')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstname-0_1'), 
    'FirstName of passenger')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastname0_1'), 
    'Last name of passenger')

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/span_kr. 7.892-'), 3)

'Done so that click on "Next" button is possible for Mobile env.\r\nClick on total so Keyboard area gets closed.'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/span_kr. 7.892-'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    5)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    5)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    10)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    5)

WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'))

WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/span_Vlg forsikring'), 
    10)

WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/span_Vlg forsikring'))

'Select default travel insurance\r\n'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/li_Har selv forsikring - kr. 0'))

'Click on individual pax insurance selection checkbox'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/Page_Primo Tours  Danmarks bedste c (1)/a_toggle checkbox kalypto'))

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto (1)'), 
    0)

not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/Save Booking/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto'), 
    5)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto'), 
    5)

'Click on individual pax insurance selection checkbox'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle radio kalypto'), 
    5)

'Click on first product category "Individual choices" radio button'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle radio kalypto'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto (1)'), 
    5)

'Click on first product category "Yes please" checkbox, so all passengers get default product in category'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto (1)'), 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto (2)'), 
    3)

'Scroll to Accept terms checkbox LABEL'
not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Keep trying/label_Jeg accepterer hermed de'), 
    3)

'Click on to Accept terms checkbox LABEL'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Keep trying/label_Jeg accepterer hermed de'))

'Scroll to Accept terms checkbox '
WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto'), 
    3)

'Click on to Accept terms checkbox '
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'), 
    3)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'), 
    5)

'Click on save booking.'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'))

