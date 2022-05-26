


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
import com.Edenred.utilities.FunctionalUtil;
public class TC002_LOGIN_user extends TestBase{

	RequestSpecification httpRequest;
	Response response;
	String email = "hemant12@fox.com";
	String password = "abcdef";
	String AccessToken;
		
	@BeforeClass
	void getUser() throws InterruptedException
	{
		logger.info("********* Started TC002_LOGIN_user **********");
		
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
		
		
		AccessToken =getAccessToken();
		   
		    response = 
				    RestAssured.given()
					.baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
					.when()
					.headers("Authorization","Bearer " +  "E868B6E09A44E96167055C005BB020E887CDFEB3E8372BA2D15FA3E9EF0D23C8")
					.get("api/User/by-phone-number/00971543434343")
		   			.then().extract().response();
		  
		   System.out.println(response.getBody().asString());
		
		   
		   
		Thread.sleep(7000);
		
		
	}
	public  String getAccessToken() {
		
		 AccessToken =
					RestAssured.given()
	       
	        .contentType(ContentType.URLENC)
	        .log().ifValidationFails()
	        .formParam("grant_type", "password")
	        .formParam("client_id", "786d6c3c324a4523b348f71be8e71e85")
	        .formParam("client_secret", "L9TnxKIGz66u3odtoFGTA0x2jUz2hCXyxz1fNaDc")
	        .formParam("username", "00971543434343")
	        .formParam("scope", "erae-payrol-beneficiary-api")
	        .formParam("acr_values", "tenant:ae-ben")
	        .formParam("password","test123").when()
	        .post("https://sso.sbx.edenred.io/connect/token").then().assertThat()
			.statusCode(200)
			.extract().path("access_token").toString();
			
		   return(AccessToken);
	}
	
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_LOGIN_user  **********");
	}
	
}
