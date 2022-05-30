

package com.Edenred.testCases.MoneyTransfer;

import com.Edenred.testCases.UserLogin;
import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.FunctionalUtil;
import com.Edenred.utilities.RestApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Edenred.Objects.*;

public class Money_Transfer{
	
	public String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	AccessToken Token = new AccessToken();
	
	Response response;
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
	public Money_Transfer(LoginCred user){
		AccessToken=Token.getAccessToken(user.getPhone(), user.getPwd());
		
	}
	
	@Test
	public  Response Get_Beneficiary_BankTransfer(String UserID) throws InterruptedException {
		
		
		/*
		 * UserLogin userid= new
		 * UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd()); UserID=
		 * userid.GetUserID();
		 */
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + AccessToken);
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "BANKTRANSFER");
		
		Response response1 = RestApi.get(requestSpecification);
		System.out.println("response beneficiau"+response1.getBody().asString());
		return response1;
		
	}
	
	public Response get_Beneficiary_CashPickup() throws InterruptedException {
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + AccessToken);
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "CASHPICKUP");
		
		response = RestApi.get(requestSpecification);
		return response;
		
		
	}
	

	public Response get_Fxrates(String UserID,String toCurrency,String amount,String transferMethod) throws InterruptedException {
		
		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.fx);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addPathParam("toCurrency", toCurrency);
		requestSpecification.addPathParam("amount", amount);
		requestSpecification.addQueryParam("transferMethod", transferMethod);
		
		response = RestApi.get(requestSpecification);
		return response;
		
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
	public Response get_eligibility(String UserID,String transfermethod, String Countrycode, double amount) throws InterruptedException {

		UserLogin userid= new UserLogin(LoginCred.User1.getPhone(),LoginCred.User1.getPwd());
		UserID= userid.GetUserID();
		
		
		/*
		
		
		transfermethod
		Countrycode
		amount
		
		*/
		requestSpecification.setBasePath(APIEndPoint.eligibility);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addPathParam("transferType ", transfermethod);
		requestSpecification.addPathParam("countryCode", Countrycode);
		requestSpecification.addPathParam("amount", amount);
		

		
		response = RestApi.get(requestSpecification);
		return response;
	}
}
