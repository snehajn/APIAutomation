
package com.Edenred.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.Edenred.Objects.LoginCred;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public  LoginCred testuser ;
	
	public Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("Fox API");//added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
		
	}
	


}
