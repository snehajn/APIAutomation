

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

public class TC_01_Eligibility_User_Not_exists extends TestBase {
	
	User user;
	String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	
	Response response;
	Money_Transfer M;
	
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
	
		
	@Test
	public void TC_02_Eligibility_Country_not_supported()  throws InterruptedException, IOException {
	
		//Generate token
		
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		
	  
						
			
			  	reportLog("-------Checking the eligibility API Response when USER ID is not correct ------");
				//Check eligibility - passing wrong user ID
			  	
				Response elgiresponse=M.get_eligibility("931aeb00-77e5-ec11-b656-0050f2f182b3",FConstants.BankTransfer,FConstants.PakistanCode,"25");
				System.out.println("eligibility"+elgiresponse.getBody().asString());
	
					
				Assert.assertTrue(elgiresponse.getBody().asString().equalsIgnoreCase("UserNotExists"), "The User Not exists is displayed in the respons");
								
			    functionalUtil.checkStatusCode(elgiresponse, 400);
				
	
			
			
		
	}
	public void TC01MoneyTransfer_BankTransfer()  throws InterruptedException, IOException {
		
		//Generate token
		
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		
	  
						
			
			  	reportLog("-------Checking the eligibility API Response when CASHPICKUP is not avaiable as option (India)------");
				//Check eligibility - passing wrong user ID
			  	
				Response elgiresponse=M.get_eligibility(UserID,FConstants.Cashpickup,"IN","25");
				System.out.println("eligibility Response "+elgiresponse.getBody().asString());
	
					
				Assert.assertTrue(elgiresponse.getBody().asString().equalsIgnoreCase("CountryNotSupported"), "The CountryNot supported is  displayed in the response");
								
			    functionalUtil.checkStatusCode(elgiresponse, 400);
				
	
			
			
		
	}
	@Test
	public void TC_07_Eligibility_TransferMethodNotExists()  throws InterruptedException, IOException {
	
		//Generate token
		
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		
	  
						
			
			  	reportLog("-------Checking the eligibility API Response when CASHPICKUP is not avaiable as option (India)------");
				//Check eligibility - passing wrong user ID
			  	
				Response elgiresponse=M.get_eligibility(UserID,"jjk","PKR","25");
				System.out.println("eligibility Response "+elgiresponse.getBody().asString());
	
					
				Assert.assertTrue(elgiresponse.getBody().asString().equalsIgnoreCase("CountryNotSupported"), "The CountryNot supported is  displayed in the response");
								
			    functionalUtil.checkStatusCode(elgiresponse, 400);
				
	
			
			
		
	}
	
}
