/**
 * 
 */
package com.retors.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.retors.model.Mdt01Sales;
import com.retors.service.EntityMoverService;

@RestController
@PropertySource("classpath:tableSheetMapping.properties")
public class ApplicationController {

	@Autowired
	private EntityMoverService entityMoverService; 
	
	@Autowired
	private Environment sheet2TableMap;

	@RequestMapping(value="/uploadExcel", method=RequestMethod.POST)
	public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile multipartFile  ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String status="";
		 try {
			byte[] bytes = multipartFile.getBytes();
			 InputStream inputStream = new ByteArrayInputStream(bytes);
			 Workbook workbook = new XSSFWorkbook(inputStream);
			 Map<String, Map<Integer,String>> metaData= new HashMap<>();
			 for (Sheet sheet : workbook) {
				if(sheet!=null){
			         int colNum = sheet.getRow(0).getLastCellNum();
			         Map<Integer, String> colMapByName = new HashMap<Integer, String>();
			            if (sheet.getRow(0).cellIterator().hasNext()) {
			                for (int j = 0; j < colNum; j++) {
			                    colMapByName.put(j, sheet.getRow(0).getCell(j).getStringCellValue());
			                }
			            }
			            metaData.put(sheet.getSheetName(), colMapByName);
					
				}
			}
			 for (Sheet sheet : workbook) {
					if(sheet!=null){
						Map<Integer, String> colMapByName =metaData.get(sheet.getSheetName());
						for (Row row : sheet) {
							if(row.getRowNum()>0){
								Class c = Class.forName("com.retors.model."+sheet.getSheetName());
								 Object object= c.newInstance();
								for (Cell cell : row) {
									if(cell.getCellTypeEnum().compareTo(CellType.NUMERIC) ==0 ){
										String fieldName= colMapByName.get(cell.getColumnIndex());
										Character firstLetter=fieldName.charAt(0);
										String method= fieldName.substring(1, fieldName.length());
										String methodName="set"+firstLetter.toString().toUpperCase()+method;
										System.out.println(methodName);
										Method setterMethod= c.getMethod(methodName,String.class );
										setterMethod.invoke(object, String.valueOf(cell.getNumericCellValue()));
									}else if(cell.getCellTypeEnum().compareTo(CellType.BOOLEAN) ==0){
										String fieldName= colMapByName.get(cell.getColumnIndex());
										Character firstLetter=fieldName.charAt(0);
										String method= fieldName.substring(1, fieldName.length());
										String methodName="set"+firstLetter.toString().toUpperCase()+method;
										System.out.println(methodName);
										Method setterMethod= c.getMethod(methodName,String.class );
										setterMethod.invoke(object, String.valueOf(cell.getBooleanCellValue()));
									}else if(cell.getCellTypeEnum().compareTo(CellType.STRING) ==0){
										String fieldName= colMapByName.get(cell.getColumnIndex());
										Character firstLetter=fieldName.charAt(0);
										String method= fieldName.substring(1, fieldName.length());
										String methodName="set"+firstLetter.toString().toUpperCase()+method;
										System.out.println(methodName);
										Method setterMethod= c.getMethod(methodName,String.class );
										setterMethod.invoke(object, String.valueOf(cell.getStringCellValue()));
									}
									
									System.out.println(object);
								}
							}

						}
					}
				}
			 
			 
			System.out.println(metaData);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	@RequestMapping(value="/getItem", method=RequestMethod.GET)
	public ResponseEntity<Mdt01Sales> getItem() {
		Mdt01Sales mdt01Sales=  entityMoverService.findMdtSales("1234");
		return new ResponseEntity<Mdt01Sales>(mdt01Sales, HttpStatus.OK);
		
	}
	
}
