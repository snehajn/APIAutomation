package com.Edenred.utilities;

import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestApi {
	

	public static Response response;
	 HashMap<String, String> QueryParam = new HashMap<String, String>();
	 HashMap<String, String> PathParam = new HashMap<String, String>();
	 HashMap<String, String> Header = new HashMap<String, String>();
	    // Add keys and values (Country, City)
	
	/*
	 * public static Response post(String path, String token, Object
	 * requestPlaylist){ return given(getRequestSpec()). body(requestPlaylist).
	 * auth().oauth2(token). when().post(path). then().spec(getResponseSpec()).
	 * extract(). response(); }
	 * 
	 * public static Response postAccount(HashMap<String, String> formParams){
	 * return given(getAccountRequestSpec()). formParams(formParams).
	 * when().post(API + TOKEN). then().spec(getResponseSpec()). extract().
	 * response(); }
	 */
	 
	 
	  public static Response get(String path, String token,ResponseSpecification specs ){

			 try {
				response = 
					    RestAssured.given()
						.baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
						.when()
						.headers("Authorization","Bearer " + token)
						.get(path)
						.then().extract().response();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		   System.out.println(response.getBody().asString());

	    	
	    	return response;
	    }
    public static Response get(String path, String token){

		 try {
			response = 
				    RestAssured.given()
					.baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
					.when()
					.headers("Authorization","Bearer " + token)
					.get(path)
					.then().extract().response();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   System.out.println(response.getBody().asString());

    	
    	return response;
    }
    
    public static  Response get(RequestSpecBuilder req){

    	RequestSpecification  specreq= req.build();
		 try {
			response = 
				    RestAssured.given()
				    .spec(specreq).log().ifValidationFails()
					.baseUri("https://eae-c3pay-web-a.azurewebsites.net/")
					.when()			
					.get()
				
					.then().assertThat().statusCode(200).extract().response();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   System.out.println("bne"+response.getBody().asString());

   	
   	return response;
   }
	/*
	 * public static Response update(String path, String token, Object
	 * requestPlaylist){ return given(getRequestSpec()). auth().oauth2(token).
	 * body(requestPlaylist). when().put(path). then().spec(getResponseSpec()).
	 * extract(). response(); }
	 */
}
