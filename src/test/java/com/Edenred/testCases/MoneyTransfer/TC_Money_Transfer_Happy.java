

package com.Edenred.testCases.MoneyTransfer;

import com.Edenred.testCases.UserLogin;
import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.FunctionalUtil;
import com.Edenred.utilities.RestApi;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonSerializer;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Edenred.Objects.APIEndPoint;
import com.Edenred.Objects.Beneficiary;
import com.Edenred.Objects.FConstants;
import com.Edenred.Objects.LoginCred;
import com.Edenred.Objects.User;
import com.Edenred.base.TestBase;


public class TC_Money_Transfer_Happy extends TestBase {
	
	User user;
	String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	
	Response response;
	Money_Transfer M;
	
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
	
		
	@Test
	public void TC01MoneyTransfer_BankTransfer() throws InterruptedException, IOException {
	
		//Generate token
		generateToken(LoginCred.user2);
		Money_Transfer M= new Money_Transfer(LoginCred.user2);
		UserLogin login =new UserLogin (LoginCred.user2);
		
		//get User Pojo
		user=login.GetUserpojo();
		UserID =user.getId();
		
		
	    	
	  
		try {
			//Get the list of beneficiaries
			
			
			  Beneficiary[] benList=M.Get_Beneficiary_BankTransfer_Pojo(UserID);
		      //First Beneficiary 
			  Beneficiary ben1=benList[0];
			  
			  System.out.println("beneficiary's Country code  "+ben1.getCountry());
		
			  String countryCode = ben1.getCountry();
			
			
			
				
				//Check eligibility
				Response elgiresponse=M.get_eligibility(UserID,FConstants.BankTransfer,countryCode,"25");
				System.out.println("eligibility"+elgiresponse.getBody().asString());
				if (elgiresponse.getBody().asString().equalsIgnoreCase("true")){
					
					//if(countryCode.equalsIgnoreCase(BD)) {
					Response Fxresponse=M.get_Fxrates(UserID,"BDT" ,"25",FConstants.BankTransfer);
				
				
					
					
					System.out.println("FX FXrate  " +Fxresponse.path("fxRates.fxRate").toString());
					ArrayList<Float> Fxrate= new <Float>ArrayList();
					Fxrate =Fxresponse.path("fxRates.fxRate");
				
					System.out.println("totalFeeAmount " +Fxresponse.path("fxRates.totalFeeAmount").toString());
					ArrayList<Float> totalFeeAmount= new <Float>ArrayList();
					totalFeeAmount =Fxresponse.path("fxRates.totalFeeAmount");
				
					
					
				
				
				
					Response Transferresponse=M.SendMoney(FConstants.BankTransfer,Fxrate.get(0),totalFeeAmount.get(0),"BDT",ben1.getId());
					
					String Transactio_ID=Transferresponse.getBody().jsonPath().get("id").toString();
					System.out.println("Transaction was successful and the Transaction ID  " +Transactio_ID);
					
					
				}
				
	
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}
	
	public void get_Beneficiary_CashPickup() throws InterruptedException, IOException {
		
		UserLogin userid= new UserLogin(LoginCred.User1);
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "CASHPICKUP");
		
		response = RestApi.get(requestSpecification);
		
		
	}
	

	public void get_Fxrates() throws InterruptedException, IOException {
		
		UserLogin userid= new UserLogin(LoginCred.User1);
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.fx);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		//requestSpecification.addPathParameter("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "DIRECTTRANSFER");
		
		response = RestApi.get(requestSpecification);
		
		
	}
	public void get_Beneficiary_DirectTransfer() throws InterruptedException, IOException {
		
		UserLogin userid= new UserLogin(LoginCred.User1);
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + userid.getAccessToken());
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "DIRECTTRANSFER");
		
		response = RestApi.get(requestSpecification);
		
		
	}
}
