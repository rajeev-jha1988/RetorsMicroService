/**
 * 
 */
package com.retors.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
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

import com.retors.service.EntityMoverService;

@RestController
@PropertySource("classpath:config.properties")
public class ApplicationController {

	@Autowired
	private EntityMoverService entityMoverService; 
	
	@Autowired
	private Environment sheet2TableMap;

	@RequestMapping(value="/uploadExcel", method=RequestMethod.POST)
	public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile multipartFile  ) {
		String status="";
		 try {
			byte[] bytes = multipartFile.getBytes();
			 InputStream inputStream = new ByteArrayInputStream(bytes);
			 Workbook workbook = new XSSFWorkbook(inputStream);
			 for (Sheet sheet : workbook) {
				if(sheet!=null && sheet2TableMap.containsProperty(sheet.getSheetName())){
					for (Row row : sheet) {
						for (Cell cell : row) {
							System.out.println(cell.getStringCellValue());
						}
						
					}
				}
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
}
