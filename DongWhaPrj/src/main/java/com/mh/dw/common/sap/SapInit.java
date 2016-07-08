package com.mh.dw.common.sap;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.sap.conn.jco.ext.DestinationDataProvider;

@Configuration
public class SapInit {
	
	private static final Logger logger = LogManager.getLogger(SapInit.class);

	public static final String ABAP_AS = "DW_ABAP_AS_WITHOUT_POOL";
	public static final String ABAP_AS_POOLED = "DW_ABAP_AS_WITH_POOL";
	
	@Value("#{prop['server.type']}")
    private String serverType;
	
	@Value("#{sap['jco.client.ashost']}")
	private String jcoAshost;
	
	@Value("#{sap['jco.client.sysnr']}")
	private String jcoSysnr;
	
	@Value("#{sap['jco.client.client']}")
	private String jcoClient;
	
	@Value("#{sap['jco.client.user']}")
	private String jcoUser;
	
	@Value("#{sap['jco.client.passwd']}")
	private String jcoPasswd;
	
	@Value("#{sap['jco.client.lang']}")
	private String jcoLang;
	
	@PostConstruct
    public void init(){
    	logger.info("serverType : " + serverType);
    	try{
	        Properties connectProperties = new Properties();   
	        
	        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, this.jcoAshost);
	        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  this.jcoSysnr);   
	        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, this.jcoClient);   
	        connectProperties.setProperty(DestinationDataProvider.JCO_USER,   this.jcoUser);   
	        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, this.jcoPasswd);   
	        connectProperties.setProperty(DestinationDataProvider.JCO_LANG,   this.jcoLang);
	        
	        createDataFile(ABAP_AS, "jcoDestination", connectProperties);   
	   
	        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "10");   
	        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT,    "50");   
	        createDataFile(ABAP_AS_POOLED, "jcoDestination", connectProperties);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    } 
    
    private static void createDataFile(String name, String suffix, Properties properties) throws Exception{   
        File cfg = new File(name+"."+suffix);
        if(cfg.isFile()){
        	cfg.delete();
        }
        if(!cfg.exists()){   
            FileOutputStream fos = new FileOutputStream(cfg, false);   
            properties.store(fos, "DW SAP INFO...");   
            fos.close();   
        }   
    } 
}
