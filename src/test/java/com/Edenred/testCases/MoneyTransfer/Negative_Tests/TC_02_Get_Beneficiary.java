
package com.Edenred.testCases.MoneyTransfer.Negative_Tests;

import com.Edenred.testCases.UserLogin;
import com.Edenred.testCases.MoneyTransfer.Money_Transfer;
import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.FunctionalUtil;
import com.Edenred.utilities.RestApi;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonSerializer;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.ArrayList;
import com.relevantcodes.extentreports.LogStatus;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.model.Log;
import com.Edenred.Objects.APIEndPoint;
import com.Edenred.Objects.Beneficiary;
import com.Edenred.Objects.FConstants;
import com.Edenred.Objects.LoginCred;
import com.Edenred.Objects.User;
import com.Edenred.base.TestBase;

public class TC_02_Get_Beneficiary extends TestBase {

	User user;
	String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();

	Response response;
	Money_Transfer M;

	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();

	@Test
	public void TC_01_Get_Beneficiary()  throws InterruptedException, IOException {
	
		

		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		
			//Get the list of beneficiaries
			
				
			  reportLog("--------Get Existing beneficiary List API ------");
			  
			  Response Beneficiary =M.Get_Beneficiary_BankTransfer("931aeb00-77e5-ec11-b656-0050f2f182b4");
			  String Error =Beneficiary.jsonPath().get("title").toString();
			  System.out.println("error" +Error);
			  Assert.assertEquals(Error, "Unauthorized","The Error response  : Unauthorized is  displayed in the response");
		      functionalUtil.checkStatusCode(Beneficiary, 401);
		    
				    
	
			
			
		
	
}

}