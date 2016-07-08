package com.mh.dw.test.sap;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.mh.dw.common.sap.SapInit;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;

@Configuration
public class TestSap {

	private static final Logger logger = LogManager.getLogger(TestSap.class);
	
	public Map<String, Object> selectTestSapData() throws Exception{
		
		logger.info("TestSap... selectTestSapData...");
		
		String functionName = "TEST";
		
		try{
			JCoDestination destination = JCoDestinationManager.getDestination(SapInit.ABAP_AS);
	        JCoFunction function = destination.getRepository().getFunction(functionName);
	        
	        if(function == null){
	            throw new Exception(functionName + " not found in SAP.");
	        }
		
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return null;
		
	}
}
