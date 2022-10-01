package com.qaselenium.testscirpts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericMethods {
	
	public static String getDataFromExcel(String path,String sheet,int row,int col) throws IOException {
		FileInputStream ip=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(ip);
		Sheet sh=wb.getSheet(sheet);
		String data=sh.getRow(row).getCell(col).toString();
		return data;
	}
	
	public static String getDataFromProperties(String path,String key) throws IOException {
		FileInputStream ip=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(ip);
		String data=prop.getProperty(key);
		return data;
	}

}
