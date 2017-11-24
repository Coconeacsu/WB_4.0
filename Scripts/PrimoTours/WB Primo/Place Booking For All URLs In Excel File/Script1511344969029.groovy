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
import com.kms.katalon.core.testdata.reader.SheetPOI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def excelInfo = ['fname':'', 'lname': '', 'pgender':'', 'pday':'', 'pmonth':'', 'pyear':'']

def rawData = TestDataFactory.findTestData("Data Files/WB_Primo/Passenger_details")

Number x = rawData.getRowNumbers()
Number randomPaxIndex = Math.abs(new Random().nextInt() % x) + 0

excelInfo.fname = rawData.getValue("FirstName", randomPaxIndex)
excelInfo.lname = rawData.getValue("LastName", randomPaxIndex)
excelInfo.pgender = rawData.getValue("Gender", randomPaxIndex)
excelInfo.pday = rawData.getValue("Day DOB", randomPaxIndex)
excelInfo.pmonth = rawData.getValue("Month DOB", randomPaxIndex)
excelInfo.pyear = rawData.getValue("Year DOB", randomPaxIndex)


//new excelBuilder("D:\\Software testing\\Tourpaq\\Resources\\Primo_URLs_For_Automated_Test.xlsx").eachLine([labels:true]) {
//	println("Coco")
	//new passenger(fname:"$FirstName", lname: "$LastName", pgender:address, telephone:phone).save()
//  }

WbUrl = ""
def coco1 = fi ('PrimoTours/Old Objects/allPaxFirstNameFields')

/*return excelInfo
SheetPOI paxDetails = findTestData("WB_Primo/Starting_URLs")
 
WbUrl = ""


WebUI.callTestCase(findTestCase('PrimoTours/WB Primo/WB Primo staging - place booking'), [('WbUrl') : 'http://localhost:51007/DoBooking.aspx?pltaID=1480269&p=1&rno=3&pt=1&a=8&c=2&aa=&ca=0%7C1%7C6&page=booking'
        , ('paxFirstName') : 'T', ('paxLastName') : 'TT', ('paxGender') : '', ('paxDay') : '', ('paxMonth') : '', ('paxYear') : ''], 
    FailureHandling.STOP_ON_FAILURE)*/

