package wb_4_0

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFDateUtil

/**
 * Groovy Builder that extracts data from
 * Microsoft Excel spreadsheets.
 * @author Goran Ehrsson
 */
public class excelPackage {
	def workbook
	def labels
	def row
 
	excelPackage(String fileName) {
		HSSFRow.metaClass.getAt = {int idx ->
			def cell = delegate.getCell(idx)
			if(! cell) {
				return null
			}
			def value
			switch(cell.cellType) {
				case HSSFCell.CELL_TYPE_NUMERIC:
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					value = cell.dateCellValue
				} else {
					value = cell.numericCellValue
				}
				break
				case HSSFCell.CELL_TYPE_BOOLEAN:
				value = cell.booleanCellValue
				break
				default:
				value = cell.stringCellValue
				break
			}
			return value
		}
 
		new File(fileName).withInputStream{is->
			workbook = new HSSFWorkbook(is)
		}
	}
 
	def getSheet(idx) {
		def sheet
		if(! idx) idx = 0
		if(idx instanceof Number) {
			sheet = workbook.getSheetAt(idx)
		} else if(idx ==~ /^\d+$/) {
			sheet = workbook.getSheetAt(Integer.valueOf(idx))
		} else {
			sheet = workbook.getSheet(idx)
		}
		return sheet
	}
 
	def cell(idx) {
		if(labels && (idx instanceof String)) {
			idx = labels.indexOf(idx.toLowerCase())
		}
		return row[idx]
	}
 
	def propertyMissing(String name) {
		cell(name)
	}
 
	def eachLine(Map params = [:], Closure closure) {
		def offset = params.offset ?: 0
		def max = params.max ?: 9999999
		def sheet = getSheet(params.sheet)
		def rowIterator = sheet.rowIterator()
		def linesRead = 0
 
		if(params.labels) {
			labels = rowIterator.next().collect{it.toString().toLowerCase()}
		}
		offset.times{ rowIterator.next() }
 
		closure.setDelegate(this)
 
		while(rowIterator.hasNext() && linesRead++ < max) {
			row = rowIterator.next()
			closure.call(row)
		}
	}
}
