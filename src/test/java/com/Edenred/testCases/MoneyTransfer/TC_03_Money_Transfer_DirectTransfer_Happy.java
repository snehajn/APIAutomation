

package com.Edenred.testCases.MoneyTransfer;

import com.Edenred.testCases.UserLogin;
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

public class TC_03_Money_Transfer_DirectTransfer_Happy extends TestBase {
	
	User user;
	String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	
	Response response;
	Money_Transfer M;
	
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
	
		
	@Test
	public void TC01MoneyTransfer_BankTransfer() throws InterruptedException, IOException {

		// Generate token

		reportLog("-----------User login  API--------------");

		generateToken(LoginCred.user3);
		Money_Transfer M = new Money_Transfer(LoginCred.user3);
		UserLogin login = new UserLogin(LoginCred.user3);

		// get User Pojo
		user = login.GetUserpojo();
		UserID = user.getId();
		reportLog(user.toString());
		//test.log(LogStatus.INFO, (Throwable) (MarkupHelper.createCodeBlock(user.toString(), CodeLanguage.JSON)));
		// Get the list of beneficiaries
		reportLog("--------Get Existing beneficiary List API ------");

		Beneficiary[] benList = M.Get_Beneficiary_BankTransfer_Pojo(UserID,FConstants.DirectTransfer);
		// First Beneficiary
		Beneficiary ben1 = benList[1];
		reportLog(ben1.toString());

		System.out.println("beneficiary's ID  " + ben1.getId());

		String Beneficiary_ID = ben1.getId();

		reportLog("Send Money API------");
		// Send Money API

		
		Response Transferresponse = M.SendMoney(FConstants.DirectTransfer, 0.0f, 0.0f, null, Beneficiary_ID);

		String Transaction_ID = Transferresponse.getBody().jsonPath().get("id").toString();
		System.out.println("Transaction was successful and the Transaction ID is  " + Transaction_ID);

	}
}
