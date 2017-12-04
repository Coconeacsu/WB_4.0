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
import com.kms.katalon.core.testdata.reader.SheetPOI as SheetPOI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow(FailureHandling.OPTIONAL)

WebUI.navigateToUrl(GlobalVariable.StagingBaseURL + WbUrl)

//Read from Excel
def excelInfo = [('fname') : '', ('lname') : '', ('pgender') : '', ('pday') : '', ('pmonth') : '', ('pyear') : '']

def rawData = TestDataFactory.findTestData('Data Files/WB_Primo/Passenger_details')

Number excelRowNo = rawData.getRowNumbers()

//END of - Read from Excel
Number randomPaxIndex = Math.abs(new Random().nextInt() % excelRowNo) + 1

excelInfo.fname = rawData.getValue('FirstName', randomPaxIndex)

excelInfo.lname = rawData.getValue('LastName', randomPaxIndex)

excelInfo.pgender = rawData.getValue('Gender', randomPaxIndex)

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstName'), 
    excelInfo.fname + ' AUT')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastName'), excelInfo.lname)

WebUI.click(findTestObject('PrimoTours/LandingPage/customerGender'))

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerAddress'), 
    'Home address')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPostcode'), 
    '6700')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerEmail'), 
    'cornel.neacsu@roweb.ro')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPhone'), 
    '12345678')

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstname-0_1'), 
    20)

WebDriver driver = DriverFactory.getWebDriver()

String roomContainerXpath = 'id("roomAndStaticOptionsContainer")/div[@class="row"]/div[@class="col-md-12 roomContainer"]'

Number roomsCount = driver.findElements(By.xpath(roomContainerXpath)).size()

println('roomsCount=' + roomsCount)

//Passenger area
for (int i = 1; i <= roomsCount; i++) {
    String paxInRoomXpath = ('id("passengersContainer_' + (i - 1)) + '")/div[@class="col-md-12"]/div[@class="row"]'

    println('paxInRoomXpath=' + paxInRoomXpath)

    //id("passengersContainer_0")/div[@class="col-md-12"]/div[@class="row"]
    Number paxInRoomCount = driver.findElements(By.xpath(paxInRoomXpath)).size()

    println('paxInRoomCount=' + paxInRoomCount)

    for (int j = 1; j <= paxInRoomCount; j++) {
        if ((i == 1) & (j == 1)) {
            continue
        }
        
        //random passenger choice from Excel file
        randomPaxIndex = (Math.abs(new Random().nextInt() % excelRowNo) + 1)

        //println(randomPaxIndex)
        excelInfo.fname = (rawData.getValue('FirstName', randomPaxIndex) + ' AUT')

        excelInfo.lname = rawData.getValue('LastName', randomPaxIndex)

        excelInfo.pgender = rawData.getValue('Gender', randomPaxIndex)

        excelInfo.pday = rawData.getValue('Day DOB', randomPaxIndex)

        excelInfo.pmonth = rawData.getValue('Month DOB', randomPaxIndex)

        excelInfo.pyear = rawData.getValue('Year DOB', randomPaxIndex)

        String paxDetailFields = ((paxInRoomXpath + '[') + j) + ']/div[@class="col-md-x col-md-9"]/div[@class="row paxContainer"][1]/div[contains(@class,"paxAttribute")]'

        //first name field finding
        String xpathval = paxDetailFields + '[1]/div[contains(@class,"form-group")]/input[contains(@class,"paxFirstName")]'

        println('fn: ' + xpathval)

        TestObject repObj = findTestObject('Object Repository/PrimoTours/LandingPage/secondPaxFirstNameField')

        repObj.findProperty('xpath').setValue(xpathval)

        WebUI.setText(repObj, excelInfo.fname)

        //last name field finding
        xpathval = (paxDetailFields + '[2]/div[contains(@class,"form-group")]/input[contains(@class,"paxLastName")]')

        println('ln: ' + xpathval)

        repObj = findTestObject('Object Repository/PrimoTours/LandingPage/secondPaxFirstNameField')

        repObj.findProperty('xpath').setValue(xpathval)

        WebUI.setText(repObj, excelInfo.lname)

        //pax gender
        //repObj = findTestObject('Object Repository/PrimoTours/LandingPage/secondPaxFirstNameField')

        //xpathval = (paxDetailFields + '[3]/div[contains(@class,"paxGenderSelectorContainer")]/span[contains(@class,"select2 select2-container")]/span[contains(@class,"selection")]/span[contains(@class,"select2-selection")]')

        //println('gender: ' + xpathval)

        //repObj.findProperty('xpath').setValue(xpathval)

        //WebUI.click(repObj, FailureHandling.OPTIONAL)
    }
}

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/bookingTotalValue'), 3)

'Done so that click on "Next" button is possible for Mobile env.\r\nClick on total so Keyboard area gets closed.'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/bookingTotalValue'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/nextButtonOnLandingPage'), 
    5)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/nextButtonOnLandingPage'), 
    5)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/nextButtonOnLandingPage'), 
    10)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/nextButtonOnLandingPage'), 
    5)

WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/Page_Primo Tours  Danmarks bedste c/nextButtonOnLandingPage'))

WebUI.delay(3)

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementNotVisible(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 20)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'), 
    10)

WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'), 
    10)

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'), 
    10)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'), 
    10)

WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'))

try {
    'Select default travel insurance\r\n'
    WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/firstTravelInsuranceOption'))
}
catch (Exception e) {
    WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'), 
        10)

    WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/travelInsuranceFirstPaxSelector'))

    'Select default travel insurance\r\n'
    WebUI.click(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/firstTravelInsuranceOption'))
} 

'Click on individual pax insurance selection checkbox'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/Page_Primo Tours  Danmarks bedste c (1)/a_toggle checkbox kalypto'))

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto (1)'), 
    0)

not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/Save Booking/Page_Primo Tours  Danmarks bedste c/a_btn btn-success col-xs-12 st'))

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/individualInsuranceCheckbox'), 
    10)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/individualInsuranceCheckbox'), 
    10)

'Click on individual pax insurance selection checkbox'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/individualInsuranceCheckbox'))

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategIndividualSelectionRadioB'), 
    5)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategIndividualSelectionRadioB'), 
    10)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategIndividualSelectionRadioB'), 
    5)

'Click on first product category "Individual choices" radio button'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategIndividualSelectionRadioB'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategSelectForAllPaxCheckbox'), 
    5)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategSelectForAllPaxCheckbox'), 
    10)

'Click on first product category "Yes please" checkbox, so all passengers get default product in category'
WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Success/firstProdCategSelectForAllPaxCheckbox'), 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Page_Primo Tours  Danmarks bedste c/a_toggle checkbox kalypto (2)'), 
    3)

'Scroll to Accept terms checkbox LABEL'
not_run: WebUI.scrollToElement(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Keep trying/label_Jeg accepterer hermed de'), 
    3)

'Click on to Accept terms checkbox LABEL'
not_run: WebUI.click(findTestObject('PrimoTours/Old Objects/Coco (1)/PrimoT/SaveBooking2/Keep trying/label_Jeg accepterer hermed de'))

'Scroll to Accept terms checkbox label'
WebUI.scrollToElement(findTestObject('PrimoTours/ConfirmationPage/labelForAgreeTermsAndConditions'), 3)

WebUI.waitForElementClickable(findTestObject('PrimoTours/ConfirmationPage/labelForAgreeTermsAndConditions'), 5)

'Click on to Accept terms checkbox label '
WebUI.click(findTestObject('PrimoTours/ConfirmationPage/labelForAgreeTermsAndConditions'))

WebUI.scrollToElement(findTestObject('PrimoTours/ConfirmationPage/placeBookingButton'), 5)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('PrimoTours/ConfirmationPage/placeBookingButton'), 10)

'Try to save booking'
try {
    'Click on save booking.'
    WebUI.click(findTestObject('PrimoTours/ConfirmationPage/placeBookingButton'))
}
catch (Exception e) {
    'Click on save booking.'
    WebUI.scrollToElement(findTestObject('PrimoTours/ConfirmationPage/placeBookingButton'), 5)

    WebUI.click(findTestObject('PrimoTours/ConfirmationPage/placeBookingButton'))
} 

WebUI.delay(3)

'Wait for TY page to load'
WebUI.waitForPageLoad(30)

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/ThankYouPage/bookingNoContainer'), 30)

'Wait for TY page to load'
WebUI.waitForJQueryLoad(30, FailureHandling.OPTIONAL)

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementPresent(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 30, FailureHandling.OPTIONAL)

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

'Wait for page loader to dissapear before making verifications'
WebUI.waitForElementNotVisible(findTestObject('PrimoTours/Old Objects/CCenter/pageLoaderOverlayLayer'), 30, FailureHandling.OPTIONAL)

'Try to click print ticket'
try {
    'Print ticket click'
    WebUI.click(findTestObject('PrimoTours/Old Objects/ThankYouPage/printTicketSpan'), FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
    'Print ticket click'
    WebUI.click(findTestObject('PrimoTours/Old Objects/ThankYouPage/printTicketSpan'), FailureHandling.STOP_ON_FAILURE)
} 

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

WebUI.delay(1)

