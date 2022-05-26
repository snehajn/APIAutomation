

package com.Edenred.testCases.MoneyTransfer;

import com.Edenred.testCases.UserLogin;
import com.Edenred.utilities.FunctionalUtil;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Edenred.Objects.*;
import com.Edenred.apiUtils.AccessToken;
import com.Edenred.apiUtils.RestApi;

public class Money_Transfer{
	
	public String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	AccessToken Token = new AccessToken();
	Response response;
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
	
		
	@Test
	public void TC01Get_Beneficiary_BankTransfer() throws InterruptedException {
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath("api/MoneyTransfer/beneficiary/"+UserID);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		//requestSpecification.addPathParameter("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "BANKTRANSFER");
		
		response = RestApi.get(requestSpecification);
		
		
	}
}
