/**
 * 
 */
package com.retors.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.retors.config.RetorsConstant;
import com.retors.model.Dat01aSales;
import com.retors.model.Mdt01Sales;
import com.retors.model.Mdt02Entity;
import com.retors.service.EntityMoverService;

@RestController
@PropertySource("classpath:tableSheetMapping.properties")
public class ApplicationController {

	@Autowired
	private EntityMoverService entityMoverService; 

	@RequestMapping(value="/uploadExcel", method=RequestMethod.POST)
	public ResponseEntity<Map> uploadExcel(@RequestParam("file") MultipartFile multipartFile  )  {
		byte[] bytes=null;
		try {
			bytes = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ReaderConfig.getInstance().setSkipErrors( true );
		InputStream inputXLS = new ByteArrayInputStream(bytes);
		Dat01aSales dat01aSales = new Dat01aSales();
		Mdt02Entity mdt02Entity = new Mdt02Entity();
		Mdt01Sales mdt01Sale = new Mdt01Sales();

		XLSReader mainReader=null;
		try {
			mainReader = ReaderBuilder.buildFromXML(this.getClass().getClassLoader().getResourceAsStream(RetorsConstant.excel2PojoConfigFile));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		List<Dat01aSales> sales = new ArrayList<>();
		List<Mdt02Entity> mdt02Entities = new ArrayList<>();
		List<Mdt01Sales> mdt01Sales = new ArrayList<>();
		Map beans = new HashMap();

		beans.put(RetorsConstant.DAT_01A_SALES, dat01aSales);
		beans.put(RetorsConstant.MDT_02_ENTITY, mdt02Entity);
		beans.put(RetorsConstant.MDT_01_SALES, mdt01Sale);


		beans.put(RetorsConstant.DAT_01A_SALES_LIST, sales);
		beans.put(RetorsConstant.MDT_02_ENTITY_LIST, mdt02Entities);
		beans.put(RetorsConstant.MDT_01_SALES_LIST, mdt01Sales);
		try {
			XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		entityMoverService.batchInsert(sales);
		entityMoverService.batchInsert(mdt02Entities);
		entityMoverService.batchInsert(mdt01Sales);
		
		return new ResponseEntity<Map>(beans, HttpStatus.OK);
	}
	@RequestMapping(value="/getItem", method=RequestMethod.GET)
	public ResponseEntity<Mdt01Sales> getItem() {
		Mdt01Sales mdt01Sales=  entityMoverService.findMdtSales("1234");
		return new ResponseEntity<Mdt01Sales>(mdt01Sales, HttpStatus.OK);
		
	}
	
}
