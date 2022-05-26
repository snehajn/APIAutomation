package com.Edenred.apiUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccessToken{
	

	public Response response ;
	
	public static String Token ;

	public String getAccessToken(String user, String password) {
		
		Token =
				RestAssured.given()
       
        .contentType(ContentType.URLENC)
        .log().ifValidationFails()
        .formParam("grant_type", "password")
        .formParam("client_id", "786d6c3c324a4523b348f71be8e71e85")
        .formParam("client_secret", "L9TnxKIGz66u3odtoFGTA0x2jUz2hCXyxz1fNaDc")
        .formParam("username", user)
        .formParam("scope", "erae-payrol-beneficiary-api")
        .formParam("acr_values", "tenant:ae-ben")
        .formParam("password",password).when()
        .post("https://sso.sbx.edenred.io/connect/token").then().extract().path("access_token").toString() ;
		
			    
		System.out.println(Token);
	    return(Token);
	}
}