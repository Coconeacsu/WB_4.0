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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow(FailureHandling.OPTIONAL)

WebUI.navigateToUrl('https://www.primotours.dk/', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/span_jquery-select-trigger-arr'), 
    10)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/span_jquery-select-trigger-arr'), 
    10)

WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/span_jquery-select-trigger-arr'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/a_Kreta'), 3)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/a_Kreta'), 3)

'Choose departure resort'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/a_Kreta'))

'Click search on Primotours.dk'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Charter rejser med Primo Tours/button_Find drmmerejsen'))

WebUI.waitForPageLoad(3)

not_run: WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_Book her'), 10)

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_Book her'), 10)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_Book her'), 10)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_Book her'), 10)

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_Book her'), 10)

'Click "Book" on Primotours.dk offer'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_Book her'))

WebUI.switchToWindowTitle('Primo Tours – Danmarks bedste charterbureau')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstName'), 'Cornel')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastName'), 'Neacsu')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerAddress'), 'Home address')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPostcode'), '6700')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerEmail'), 'cornel.neacsu@roweb.ro')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPhone'), '12345678')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstname-0_1'), 'FirstName of passenger')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastname0_1'), 'Last name of passenger')

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    5)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    25)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/i_fa fa-arrow-circle-right'), 
    10)

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

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle radio kalypto'), 5)

'Click on first product category "Individual choices" radio button'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle radio kalypto'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto (1)'), 5)

'Click on first product category "Yes please" checkbox, so all passengers get default product in category'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto (1)'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto (2)'), 
    3)

'Scroll to Accept terms checkbox LABEL'
not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Keep trying/label_Jeg accepterer hermed de'), 3)

'Click on to Accept terms checkbox LABEL'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Keep trying/label_Jeg accepterer hermed de'))

'Scroll to Accept terms checkbox '
WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto'), 3)

'Click on to Accept terms checkbox '
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/a_toggle checkbox kalypto'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'), 
    3)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'), 
    5)

'Click on save booking.'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'))

not_run: WebUI.closeBrowser()

