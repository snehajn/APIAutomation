package com.Edenred.testCases;

import org.hamcrest.Matchers;

import com.Edenred.Objects.APIEndPoint;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BDDStylePostRequest {
	
	
	public static void main(String[] args) {
		
		// There is no need to add escape character manually. Just paste string within double 
		// quotes. It will automatically add escape sequence as required. 
		String jsonString = "{\"client_id\": \"786d6c3c324a4523b348f71be8e71e85\",\r\n"
				+ "\"client_secret\" : \"L9TnxKIGz66u3odtoFGTA0x2jUz2hCXyxz1fNaDc\",\r\n"
				+ "\"grant_type\": \"password\",\r\n"
				+ "\"scope\": \"erae-payrol-beneficiary-api\",\r\n"
				+ "\"acr_values\": \"tenant:ae-ben\",\r\n"
				+ "\"username\": \"00971545091714\",\r\n"
				+ "\"password\": \"test123\"}";
//				
		Response response =
				RestAssured.given()
       
        .contentType(ContentType.URLENC)
        .log().ifValidationFails()
        .formParam("grant_type", "password")
        .formParam("client_id", "786d6c3c324a4523b348f71be8e71e85")
        .formParam("client_secret", "L9TnxKIGz66u3odtoFGTA0x2jUz2hCXyxz1fNaDc")
        .formParam("username", "00971545092398")
        .formParam("scope", "erae-payrol-beneficiary-api")
        .formParam("acr_values", "tenant:ae-ben")
        .formParam("password","test123").when()
        .post("https://sso.sbx.edenred.io/connect/token").then().extract().response();
		
			    
		System.out.println(response.getBody().asString());
		String token =response.path("access_token").toString();
		/*
		 * System.out.println("token "+ token); response = RestAssured.given()
		 * .baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
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
	   response = 
			    RestAssured.given()
				.baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
				.when().log().ifValidationFails()
				.headers("Authorization","Bearer " + token)
				.header("accept" , "text/plain")
				.pathParams("userId", "22fd197f-e0d5-ec11-b656-0050f2f182b8")
				.pathParams("transferType", "BANKTRANSFER")
				.pathParams("countryCode", "IN")
				.pathParams("amount", 20)
				
				.get("/api/MoneyTransfer/transfer-limit-iseligible/{userId}/{transferType}/{countryCode}/{amount}")
	   			.then().assertThat().statusCode(400).extract().response();
	   
	   			System.out.println("Final response "+response.getBody().asString());
	   
		
	
	}

}