

package com.Edenred.testCases.MoneyTransfer;

import com.Edenred.testCases.UserLogin;
import com.Edenred.utilities.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.http.entity.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Edenred.Objects.*;
import com.Edenred.base.TestBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

public class Money_Transfer extends TestBase{
	
	public String UserID;
	String AccessToken;
	FunctionalUtil functionalUtil = new FunctionalUtil();
	//
	
	Response response;
	RequestSpecBuilder requestSpecification = new RequestSpecBuilder();
	
	public Money_Transfer(LoginCred user){
		
		generateToken(user);
		
		
	}
	
	@Test
	public  Response Get_Beneficiary_BankTransfer(String UserID) throws InterruptedException {
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + FConstants.Token);
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "BANKTRANSFER");
		
		Response response1 = RestApi.get(requestSpecification);
		
		return  response1;
	
		
	}
	@Test
public  Beneficiary[] Get_Beneficiary_BankTransfer_Pojo(String UserID, String TransferMethod) throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		
		Beneficiary ben1 =new Beneficiary();
		//List<Beneficiary> benelist =new <Beneficiary>ArrayList();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + FConstants.Token);
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", TransferMethod);
		
		Response response1 = RestApi.get(requestSpecification);
		System.out.println("response beneficiau"+response1.getBody().asString());
		
		
		    ObjectMapper objectMapper = new ObjectMapper();
			String jsonpath=response1.getBody().asString();
			
			
			
			Beneficiary[] list =  objectMapper.readValue(jsonpath,Beneficiary[].class) ; 
			ben1=list[0];
			System.out.println (ben1.getCountryName());
			
		return  list;
	
		
	}
	
	public Response get_Beneficiary_CashPickup() throws InterruptedException, IOException {
		
		UserLogin userid= new UserLogin(LoginCred.User1);
		UserID= userid.GetUserID();
		
		
		requestSpecification.setBasePath(APIEndPoint.Money_Transfer_Beneficiary);
		requestSpecification.setAccept("text/plain");
		requestSpecification.addHeader("Authorization","Bearer " + AccessToken);
		requestSpecification.addPathParam("userId", UserID);
		requestSpecification.addQueryParam("transferMethod", "CASHPICKUP");
		
		response = RestApi.get(requestSpecification);
		return response;
		
		
	}
	

	public Response get_Fxrates(String UserID,String toCurrency,String amount,String transferMethod) throws InterruptedException, IOException {
		
		RequestSpecBuilder requestSpecification2 = new RequestSpecBuilder();
		Response response2;
		
		
		requestSpecification2.setBasePath(APIEndPoint.fx);
		requestSpecification2.setAccept("text/plain");
		requestSpecification2.addHeader("Authorization","Bearer " + FConstants.Token);
		requestSpecification2.addPathParam("userId", UserID);
		requestSpecification2.addPathParam("toCurrency", "BDT");
		requestSpecification2.addPathParam("amount", 25);
		requestSpecification2.addQueryParam("transferMethod", transferMethod);
		
		response2 = RestApi.get(requestSpecification2);
		System.out.println(response2.body().asString());
		return response2;
		
	}
	
	
	public Response SendMoney(String transferMethod,float transferrate,float fee,String ReceiverCurrency,String BeneficiaryID) throws InterruptedException, IOException {
		
		RequestSpecBuilder requestSpecification3 = new RequestSpecBuilder();
		Response response3;
		String jsonArrayAsString="";
		ObjectMapper objectMapper = new ObjectMapper();
		
		if(transferMethod.equalsIgnoreCase(FConstants.DirectTransfer)) {
			
			
			//Payload creation
			// Create an array which will hold two JSON objects
			ArrayNode parentArray =  objectMapper.createArrayNode();
			
			// Creating Node that maps to JSON Object structures in JSON content
			ObjectNode Jsonnode = objectMapper.createObjectNode();
			
			Jsonnode.put("beneficiaryId", BeneficiaryID);
			ObjectNode sendAmount = objectMapper.createObjectNode();
			sendAmount.put("amount", 25);
			Jsonnode.set("sendAmount", sendAmount);
			parentArray.add(Jsonnode);
			

			jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Jsonnode);
			System.out.println("Created Json Array is : ");
			System.out.println(Jsonnode.toString());
	
			
		}
		else if (transferMethod.equalsIgnoreCase("BankTransfer")) {
		//Payload Request 
	
		
		//Payload creation
		// Create an array which will hold two JSON objects
		ArrayNode parentArray =  objectMapper.createArrayNode();
		
		// Creating Node that maps to JSON Object structures in JSON content
		ObjectNode Jsonnode = objectMapper.createObjectNode();
		
		Jsonnode.put("beneficiaryId", BeneficiaryID);
		ObjectNode sendAmount = objectMapper.createObjectNode();
		sendAmount.put("amount", 25);
		sendAmount.put("currency", "AED");
		ObjectNode receiveAmount = objectMapper.createObjectNode();
		receiveAmount.put("amount", 25);
		receiveAmount.put("currency", ReceiverCurrency);
		
		Jsonnode.set("sendAmount", sendAmount);
		Jsonnode.set("receiveAmount", receiveAmount);
		Jsonnode.put("conversionRate", transferrate);
		Jsonnode.put("feeAmount", fee);
		Jsonnode.put("referralCode", "ff");
		
		parentArray.add(Jsonnode);
		

		jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Jsonnode);
		System.out.println("Created Json Array is : ");
		System.out.println(Jsonnode.toString());
		
		}		
		
		
		requestSpecification3.setBasePath(APIEndPoint.sendmoney);
		requestSpecification3.setAccept("text/plain");
		//requestSpecification3.setContentType()
		requestSpecification3.setContentType(ContentType.JSON);
		requestSpecification3.addHeader("Authorization","Bearer " + FConstants.Token);
		requestSpecification3.addQueryParam("transferMethod", transferMethod);
		//requestSpecification3.setBody(jsonDataInFile);
		
		response3 = RestApi.post(requestSpecification3,jsonArrayAsString);
		System.out.println(response3.body().asString());
		return response3;
		
		
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
	@Test
	public Response get_eligibility(String UserID,String transfermethod, String Countrycode, String amount) throws InterruptedException, IOException {

		RequestSpecBuilder requestSpecification1 = new RequestSpecBuilder();
		Response response1;
		
		
				/*transfermethod
		Countrycode
		amount
		
		*/
		requestSpecification1.setBasePath(APIEndPoint.eligibility);
		requestSpecification1.setAccept("text/plain");
		requestSpecification1.addHeader("Authorization","Bearer " +FConstants.Token);
		requestSpecification1.addPathParam("userId", UserID);
		requestSpecification1.addPathParam("transferType", transfermethod);
		requestSpecification1.addPathParam("countryCode", Countrycode);
		requestSpecification1.addPathParam("amount", 25);
		

		
		response1 = RestApi.get(requestSpecification1);
		return response1;
	}
}
