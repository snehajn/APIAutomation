package com.Edenred.utilities; 
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FunctionalUtil{
	
	public String AccessToken;

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
	//Test Case - isVerified Validation
	@Test
	public void checkResposeBody(Response response)
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("isVerified"), true);
	}
		
	//Test Case - Status code validation
	@Test
	public void checkStatusCode(Response response)
	{
		int statusCode = response.getStatusCode(); 
		Assert.assertEquals(statusCode, 200);
	}
	
	
	public void checkStatusCode(Response response,int expectedstatusCode)
	{
		int statusCode = response.getStatusCode(); 
		Assert.assertEquals(statusCode, expectedstatusCode);
	}
	//Test Case - Response Time check
	@Test
	public void checkResponseTime(Response response)
	{
		long responseTime = response.getTime(); 
		Assert.assertTrue(responseTime<7000);
		
	}
		
	//Test Case - Check status Line
	@Test
	public void checkstatusLine(Response response)
	{
		String statusLine = response.getStatusLine(); 
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	public void checkstatusLine(Response response,String expectedstatusLine)
	{
		String statusLine = response.getStatusLine(); 
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	//Test Case - Check Content-Type
	@Test
	public void checkContentType(Response response)
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
}

