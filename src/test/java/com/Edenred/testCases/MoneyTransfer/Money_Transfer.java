

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
	
	
	Money_Transfer(UserLogin userid){
		
	}
		
	@Test
	public  Response Get_Beneficiary_BankTransfer() throws InterruptedException {
		
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "BANKTRANSFER");
		
		response = RestApi.get(requestSpecification);
		return response;
		
	}
	
	public void get_Beneficiary_CashPickup() throws InterruptedException {
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "CASHPICKUP");
		
		response = RestApi.get(requestSpecification);
		
		
	}
	

	public void get_Fxrates() throws InterruptedException {
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.fx);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		//requestSpecification.addPathParameter("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "DIRECTTRANSFER");
		
		response = RestApi.get(requestSpecification);
		
		
	}
	public void get_Beneficiary_DirectTransfer() throws InterruptedException {
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "DIRECTTRANSFER");
		
		response = RestApi.get(requestSpecification);
		
		
	}
	@Test
	public void get_eligibility(String transfermethod, String Countrycode, double amount) throws InterruptedException {

		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		requestSpecification.setBasePath(APIEndPoint.eligibility);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addPathParam("transferType ", transfermethod);
		requestSpecification.addPathParam("countryCode", Countrycode);
		requestSpecification.addPathParam("amount", amount);
		

		
		response = RestApi.get(requestSpecification);
		
	}
}
