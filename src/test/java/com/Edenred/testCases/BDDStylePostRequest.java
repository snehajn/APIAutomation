package com.Edenred.testCases;

import java.io.File;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.json.JSONObject;

import com.Edenred.Objects.APIEndPoint;
import com.Edenred.Objects.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class BDDStylePostRequest {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		
//		//get token		
		Response response = RestAssured.given()

				.contentType(ContentType.URLENC).log().ifValidationFails().formParam("grant_type", "password")
				.formParam("client_id", "786d6c3c324a4523b348f71be8e71e85")
				.formParam("client_secret", "L9TnxKIGz66u3odtoFGTA0x2jUz2hCXyxz1fNaDc")
				.formParam("username", "00971545092159").formParam("scope", "erae-payrol-beneficiary-api")
				.formParam("acr_values", "tenant:ae-ben").formParam("password", "test123").when()
				.post("https://sso.sbx.edenred.io/connect/token").then().extract().response();

		System.out.println(response.getBody().asString());
		String token = response.path("access_token").toString();
		
		
		/*
		 * 
		 * 
		 * 
		 * response =
		 * RestAssured.given().baseUri("https://eae-c3pay-web-a.azurewebsites.net/").
		 * when().log() .ifValidationFails().headers("Authorization", "Bearer " +
		 * token).header("accept", "text/plain") .pathParam("phoneNumber",
		 * "00971545092159")
		 * 
		 * .get("api/User/by-phone-number/{phoneNumber}")
		 * .then().assertThat().statusCode(200).extract().response();
		 * 
		 * System.out.println("Final response " + response.getBody().asString());
		 * 
		 * String jsonresponse =response.getBody().asString(); ObjectMapper objectMapper
		 * = new ObjectMapper(); //objectMapper.con User user1 =new User(); try { user1
		 * = objectMapper.readValue(jsonresponse, User.class); } catch
		 * (JsonParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println("user pojo creatd " + user1.getId());
		 * 
		 */		/*
		 * 
		 * //get beneficiary System.out.println("token "+ token); response =
		 * RestAssured.given() .baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
		 * .when().log().ifValidationFails() .headers("Authorization","Bearer " + token)
		 * .header("accept" , "text/plain") .pathParams("userId",
		 * "22fd197f-e0d5-ec11-b656-0050f2f182b8") .queryParam("transferMethod",
		 * "BANKTRANSFER")
		 * 
		 * .get("api/MoneyTransfer/beneficiary/{userId}")
		 * .then().assertThat().statusCode(200).extract().response();
		 * 
		 * System.out.println(response.getBody().asString());
		 */
		
		JSONObject Jsonnode = new JSONObject();

		JSONObject sendAmount = new JSONObject();
		
		sendAmount.put("amount", 25);
		sendAmount.put("currency", "AED");
		

		JSONObject receiveAmount = new JSONObject();
		receiveAmount.put("amount", 25);
		receiveAmount.put("currency", "INR");
		
		Jsonnode.put("beneficiaryId","d72385bd-d4df-ec11-b656-0050f2f182b8" );
		Jsonnode.put("sendAmount", sendAmount);
		Jsonnode.put("receiveAmount", receiveAmount);
		Jsonnode.put("conversionRate", 24.1);
		Jsonnode.put("feeAmount", 5.1);
		Jsonnode.put("referralCode", "ff");
		
		
		
		
String jsin= "\r\n"
		+ "  \"beneficiaryId\":\"d72385bd-d4df-ec11-b656-0050f2f182b8\",\r\n"
		+ "  \"sendAmount\": {\r\n"
		+ "    \"amount\": 200,\r\n"
		+ "    \"currency\": \"AED\"\r\n"
		+ "  },\r\n"
		+ "  \"receiveAmount\": {\r\n"
		+ "    \"amount\": 200,\r\n"
		+ "    \"currency\": \"INR\"\r\n"
		+ "  },\r\n"
		+ "  \"conversionRate\": 20.507,\r\n"
		+ "  \"feeAmount\": 0,\r\n"
		+ "  \"referralCode\": \"ff\"\r\n"
		+ "}";
		

File jsonDataInFile = new File("src/Resources/AuthPayload.json");
		 response = RestAssured.given().baseUri("https://eae-c3pay-web-a.azurewebsites.net/").when().log()
				.ifValidationFails().headers("Authorization", "Bearer " + token).header("accept", "text/plain")
				.queryParam("transferMethod", "BANKTRANSFER")
				.contentType(ContentType.JSON)
				.body(jsonDataInFile)
				.post("api/MoneyTransfer/send-money")
				.then().assertThat().statusCode(200).extract().response();

		System.out.println("Final response " + response.getBody().asString());

	}

}