


package com.Edenred.testCases;

import java.io.IOException;

import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.*;

import com.Edenred.Objects.APIEndPoint;
import com.Edenred.Objects.FConstants;
import com.Edenred.Objects.LoginCred;
import com.Edenred.Objects.User;
import com.Edenred.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.ExtentListeners;
import com.Edenred.utilities.FunctionalUtil;
import com.Edenred.utilities.RestApi;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Test
@Listeners(ExtentListeners.class)
public class UserLogin extends TestBase{

	RequestSpecification httpRequest;
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	Response response;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	com.Edenred.utilities.AccessToken Token = new AccessToken();
	String Phoneno;
	String password;
	
	public UserLogin(LoginCred login) {
		
		this.Phoneno =login.getPhone();
		this.password=login.getPwd();
		//this.AccessToken=Token.getAccessToken(Phoneno, password);
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
	
	
	//@Test
	public void UsersuccessfulLogin() throws InterruptedException
	{
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
					
		 Phoneno="00971543434343";

		password="test123";
		String path= "api/User/by-phone-number/"+Phoneno;
	
		Response response;
		    response = RestApi.get(path,FConstants.Token);
				   
	   System.out.println(response.getBody().asString());
	   
		functionalUtil.checkStatusCode(response);
		functionalUtil.checkResposeBody(response);
		functionalUtil.checkResponseTime(response);
		functionalUtil.checkContentType(response);
			Thread.sleep(7000);
		
		
	}
	public String GetUserID() throws InterruptedException, IOException
	{
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
					
		 
		String path= "api/User/by-phone-number/"+Phoneno;
		String token= Token.getAccessToken(Phoneno, password);
		response = RestApi.get(path,token);

	
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
	
	public User GetUserpojo() throws InterruptedException, IOException
	{
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
					
		 
		String path= "api/User/by-phone-number/{phoneNumber}";

		requestSpecification.setBasePath("api/User/by-phone-number/{phoneNumber}");
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + FConstants.Token);
		requestSpecification.addPathParam("phoneNumber", Phoneno);
	
		
		Response response = RestApi.get(requestSpecification);
		
		User user1 =new User();
		
		 
		Assert.assertTrue(functionalUtil.checkStatusCode200(response),"The User login Response status code is 200");
		
		Assert.assertNotNull(response.path("id").toString(), "User ID is not null in the response");
		String jsonString =response.getBody().asString();
		
		
				   
	   System.out.println(response.getBody().asString());
		
	   ObjectMapper objectMapper = new ObjectMapper();
		// Pass JSON string and the POJO class 
		try {
			
			user1 = objectMapper.readValue(jsonString, User.class);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   
	   System.out.println("UserID "+ user1.getId());
	   return user1;
	   
		
		
	
		
	}
	
	
	
	

	//Test Case - isVerified Validation
	

	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_LOGIN_user  **********");
	}
	
}
