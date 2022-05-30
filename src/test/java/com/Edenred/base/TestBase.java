
package com.Edenred.base;

import org.apache.log4j.Level;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.Edenred.Objects.LoginCred;

import com.Edenred.utilities.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public  LoginCred testuser ;
	public String token;
	public Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("Fox API");//added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
		
	}
	
	public String userLogin(LoginCred user) {
		
		AccessToken Token =new AccessToken() ;
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
			
		
		String path= "api/User/by-phone-number/"+user.getPhone();
		String token= Token.getAccessToken(user.getPhone(), user.getPwd());
		response = RestApi.get(path,token);
				   
	   System.out.println(response.getBody().asString());
	   
	   
	   
	   String userID=response.jsonPath().getString("id");
	   
	   System.out.println("UserID "+ userID);
	   
	
		return userID;
		
	}
	public String getToken(LoginCred user) {
		
		AccessToken Token =new AccessToken() ;
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
			
		
		String path= "api/User/by-phone-number/"+user.getPhone();
		String token= Token.getAccessToken(user.getPhone(), user.getPwd());
		response = RestApi.get(path,token);
				   
	   System.out.println(response.getBody().asString());
	   
	   
	   
	   String userID=response.jsonPath().getString("id");
	   
	   System.out.println("UserID "+ userID);
	   
	
		return userID;
		
	}
	
	
	
	


}
