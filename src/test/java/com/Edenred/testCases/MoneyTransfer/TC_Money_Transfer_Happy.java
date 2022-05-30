

package com.Edenred.testCases.MoneyTransfer;

import com.Edenred.testCases.UserLogin;
import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.FunctionalUtil;
import com.Edenred.utilities.RestApi;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Edenred.Objects.*;
import com.Edenred.base.TestBase;

public class TC_Money_Transfer_Happy extends TestBase {
	
	public String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	//AccessToken UserID = new AccessToken();
	Response response;
	Money_Transfer M;
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	//super.testuser= LoginCred.User1;
	//testuser= LoginCred.User1;
	
		
	@Test
	public void TC01MoneyTransfer_BankTransfer() throws InterruptedException {
	
		
		//test.log(Status.INFO, "Logging In with User credential : "+ LoginCred.User1.getPhone() );
		Money_Transfer M= new Money_Transfer(LoginCred.User1);
		
		UserID=userLogin(LoginCred.User1);
		
	    if(UserID.equalsIgnoreCase("Error")) {
	    	Assert.assertEquals(UserID, "Error","The User login has error");
	    	//throws exception
	    	
	    	
	    }
	    else {
	    	
	  
		try {
			Response response=M.Get_Beneficiary_BankTransfer(UserID);
			
			functionalUtil.checkStatusCode200(response);
		
			System.out.println(response.getBody().asString());
			String countryCode = response.jsonPath().getString("country[1]");
			System.out.println(countryCode);
			
			
			if (response.getStatusCode() ==200 && response.getBody().asString() != null) {
				
				Response elgiresponse=M.get_eligibility(UserID,Constants.BankTransfer,countryCode,200);
				if (elgiresponse.getBody().asString().equalsIgnoreCase("true")){
					
					Response Fxresponse=M.get_Fxrates(UserID,countryCode ,"10",Constants.BankTransfer);
					System.out.println(Fxresponse.getBody().asString());
					
					
				}else {
					
					
				}
			
				
				
				/*
				 * { "beneficiaryId": "21666c72-dad4-ec11-b656-0050f2f182b8", "sendAmount": {
				 * "amount": 200, "currency": "AED" }, "receiveAmount": { "amount": 200,
				 * "currency": "INR" }, "conversionRate": 20.507, "feeAmount": 0,
				 * "referralCode": "ff" }
				 */
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
		
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
}
