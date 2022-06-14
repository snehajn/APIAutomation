

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

public class TC_03_FXRATE_Invalid_Tocurrency extends TestBase {
	
	User user;
	String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	
	Response response;
	Money_Transfer M;
	
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
			
	@Test
	public void TC_01_FXRATE_Invalid_Tocurrency()  throws InterruptedException, IOException {
	
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		test.log(LogStatus.INFO,(Throwable) (MarkupHelper.createCodeBlock(user.toString(), CodeLanguage.JSON)));
		
		reportLog("------ Fxrates API Passing Invalid Currency------");
		Response Fxresponse=M.get_Fxrates(UserID,"BD" ,"25",FConstants.BankTransfer);
		
		System.out.println("FX error response   " + Fxresponse.getBody().asString());
		
		
		Assert.assertTrue(Fxresponse.getBody().asString().equalsIgnoreCase("InvalidToCurrency"), "The Error response  : InvalidToCurrency is  displayed in the response");
		
		functionalUtil.checkStatusCode(Fxresponse, 400);
			    
				    
	
			
			
		
	
}
	@Test
public void TC_02_FXRATE_Invalid_USERID()  throws InterruptedException, IOException {
	
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		test.log(LogStatus.INFO,(Throwable) (MarkupHelper.createCodeBlock(user.toString(), CodeLanguage.JSON)));
		
		reportLog("------ Fxrates API Passing Invalid User ID ------");
		Response Fxresponse=M.get_Fxrates("ddddd","BD" ,"25",FConstants.BankTransfer);
		
		System.out.println("FX error response   " + Fxresponse.getBody().asString());
		
		
		Assert.assertTrue(Fxresponse.getBody().asString().equalsIgnoreCase("UserNotExists"), "The Error response  : UserNotExists is  displayed in the response");
		
		functionalUtil.checkStatusCode(Fxresponse, 400);
			    
				    
	
			
			
		
	
}
	@Test
	public void TC_03_FXRATE_AmountNotExists()  throws InterruptedException, IOException {
	
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		test.log(LogStatus.INFO,(Throwable) (MarkupHelper.createCodeBlock(user.toString(), CodeLanguage.JSON)));
		
		reportLog("------ Fxrates API Passing Invalid User ID ------");
		Response Fxresponse=M.get_Fxrates("ddddd","PKR" ,"25",FConstants.BankTransfer);
		
		System.out.println("FX error response   " + Fxresponse.getBody().asString());
		
		
		Assert.assertTrue(Fxresponse.getBody().asString().equalsIgnoreCase("AmountNotExists"), "The Error response  : AmountNotExists is  displayed in the response");
		
		functionalUtil.checkStatusCode(Fxresponse, 400);
			    
				    
	
			
			
		
	
}
	public void TC_04_FXRATE_TransferMethodNotExists()  throws InterruptedException, IOException {
	
		
		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		reportLog(user.toString());
		test.log(LogStatus.INFO,(Throwable) (MarkupHelper.createCodeBlock(user.toString(), CodeLanguage.JSON)));
		
		reportLog("------ Fxrates API Passing Invalid Transfer method ------");
		Response Fxresponse=M.get_Fxrates(UserID,"PKR" ,"25","BANK");
		
		System.out.println("FX error response   " + Fxresponse.getBody().asString());
		
		
		Assert.assertTrue(Fxresponse.getBody().asString().equalsIgnoreCase("TransferMethodNotExists"), "The Error response  : TransferMethodNotExists is  displayed in the response");
		
		functionalUtil.checkStatusCode(Fxresponse, 400);
			    
				    
	
			
			
		
	
}
}