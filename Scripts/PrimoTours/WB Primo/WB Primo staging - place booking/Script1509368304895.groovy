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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow(FailureHandling.OPTIONAL)

WebUI.navigateToUrl(WbUrl)

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstName'), 
    paxFirstName + ' AUT')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastName'), paxLastName)

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerAddress'), 
    'Home address')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPostcode'), 
    '6700')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerEmail'), 
    'cornel.neacsu@roweb.ro')

WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_customerPhone'), 
    '12345678')

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstname-0_1'), 
    2)

//Passenger area
//Read from Excel
def excelInfo = [('fname') : '', ('lname') : '', ('pgender') : '', ('pday') : '', ('pmonth') : '', ('pyear') : '']

def rawData = TestDataFactory.findTestData('Data Files/WB_Primo/Passenger_details')

Number excelRowNo = rawData.getRowNumbers()

//END of - Read from Excel
Number randomPaxIndex = 1

WebDriver driver = DriverFactory.getWebDriver()

String roomContainerXpath = 'id("booking")/div[@class="wrapper second-bg"]/div[contains(@class,"container-mx")]/div[@class="row"]/div[@class="col-md-12 roomContainer"]'

Number roomsCount = driver.findElements(By.xpath(roomContainerXpath)).size()

println('roomsCount=' + roomsCount)

for (int i = 1; i <= roomsCount; i++) {
    String paxInRoomXpath = ((roomContainerXpath + '[') + i) + ']/div[@class="row"]/div[@class="col-md-12"]/div[@class="row"]'

    Number paxInRoomCount = driver.findElements(By.xpath(paxInRoomXpath)).size()

    println('paxInRoomCount=' + paxInRoomCount)

    for (int j = 1; j <= paxInRoomCount; j++) {
        if ((i == 1) & (j == 1)) {
            continue
        }
        
        //random passenger choice from Excel file
        randomPaxIndex = (Math.abs(new Random().nextInt() % excelRowNo) + 1)

        println(randomPaxIndex)

        excelInfo.fname = (rawData.getValue('FirstName', randomPaxIndex) + ' AUT')

        excelInfo.lname = rawData.getValue('LastName', randomPaxIndex)

        excelInfo.pgender = rawData.getValue('Gender', randomPaxIndex)

        excelInfo.pday = rawData.getValue('Day DOB', randomPaxIndex)

        excelInfo.pmonth = rawData.getValue('Month DOB', randomPaxIndex)

        excelInfo.pyear = rawData.getValue('Year DOB', randomPaxIndex)

        String paxDetailFields = ((paxInRoomXpath + '[') + j) + ']/div[@class="col-md-x col-md-9"]/div[@class="row paxContainer"]/div[@class="col-md-5"]'

        //first name field finding
        String xpathval = paxDetailFields + '[1]/div[contains(@class,"form-group")]/input[@class="form-control paxFirstName"]'

        println('fn: ' + xpathval)

        //fieldToSearch = 
        TestObject repObj = findTestObject('Object Repository/PrimoTours/Old Objects/allPaxFirstNameFields')

        repObj.findProperty('xpath').setValue(xpathval)

        WebUI.setText(repObj, excelInfo.fname)

        //last name field finding
        xpathval = (paxDetailFields + '[2]/div[contains(@class,"form-group")]/input[@class="form-control paxLastName"]')

        println('ln: ' + xpathval)

        //fieldToSearch =
        repObj = findTestObject('Object Repository/PrimoTours/Old Objects/allPaxLastNameFields')

        repObj.findProperty('xpath').setValue(xpathval)

        WebUI.setText(repObj, excelInfo.lname)
    }
}

//def coco1 = findTestObject('PrimoTours/Old Objects/allPaxFirstNameFields')
//def coco2 = findTestObject('PrimoTours/Old Objects/allPaxLastNameFields')
//WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_firstname-0_1'),    excelInfo.fname)
//WebUI.setText(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Page_Primo Tours  Danmarks bedste c/input_lastname0_1'),    excelInfo.lname)
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

WebUI.waitForElementVisible(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/span_Vlg forsikring'), 
    10)

WebUI.waitForElementClickable(findTestObject('PrimoTours/Old Objects/Coco/PrimoT/Ins2/Page_Primo Tours  Danmarks bedste c/span_Vlg forsikring'), 
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

