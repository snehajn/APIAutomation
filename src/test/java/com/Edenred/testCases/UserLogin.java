


package com.Edenred.testCases;

import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.*;

import com.Edenred.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.FunctionalUtil;
import com.Edenred.utilities.RestApi;
public class UserLogin extends TestBase{

	RequestSpecification httpRequest;
	Response response;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	AccessToken Token = new AccessToken();
	String Phoneno;

	String password;
	
	public UserLogin(String Phoneno, String password) {
		
		this.Phoneno =Phoneno;
		this.password=password;
		this.AccessToken=Token.getAccessToken(Phoneno, password);
		// TODO Auto-generated constructor stub
	}
	
	public String getAccessToken() {
		
		return this.AccessToken;
	}


	@BeforeClass
	void Login() throws InterruptedException
	{
		logger.info("********* Started TC002_LOGIN_user **********");
		
	}
	
	
	@Test
	public void UsersuccessfulLogin() throws InterruptedException
	{
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
					
		 Phoneno="00971543434343";

		password="test123";
		String path= "api/User/by-phone-number/"+Phoneno;
		String token= Token.getAccessToken(Phoneno, password);
		Response response;
		    response = RestApi.get(path,token);
				   
	   System.out.println(response.getBody().asString());
	   
		functionalUtil.checkStatusCode(response);
		functionalUtil.checkResposeBody(response);
		functionalUtil.checkResponseTime(response);
		functionalUtil.checkContentType(response);
			Thread.sleep(7000);
		
		
	}
	@Test
	public String GetUserID() throws InterruptedException
	{
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
					
		 
		String path= "api/User/by-phone-number/"+Phoneno;
		String token= Token.getAccessToken(Phoneno, password);
		response = RestApi.get(path,token);
				   
	   System.out.println(response.getBody().asString());
	   
	   functionalUtil.checkStatusCode(response);
	   String userID=response.jsonPath().getString("id");
	   System.out.println("UserID "+ userID);
		Thread.sleep(7000);
		return userID; 
		
	}
	public String GetRandomUserID() throws InterruptedException
	{
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
					
		 Phoneno="00971543434343";
		 password="test123";
		String path= "api/User/by-phone-number/"+Phoneno;
		String token= Token.getAccessToken(Phoneno, password);
		response = RestApi.get(path,token);
				   
	   System.out.println(response.getBody().asString());
	   
	   functionalUtil.checkStatusCode(response);
	   String userID=response.jsonPath().getString("id");
	   System.out.println("UserID "+ userID);
		Thread.sleep(7000);
		return userID; 
		
	}

	//Test Case - isVerified Validation
	

	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_LOGIN_user  **********");
	}
	
}
