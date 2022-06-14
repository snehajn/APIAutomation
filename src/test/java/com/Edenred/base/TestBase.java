
package com.Edenred.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.Edenred.Objects.FConstants;
import com.Edenred.Objects.LoginCred;
import com.Edenred.utilities.AccessToken;
import com.Edenred.utilities.ExtentListeners;
import com.Edenred.utilities.RestApi;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(ExtentListeners.class)
public class TestBase extends ExtentListeners {

	public static RequestSpecification httpRequest;
	public static Response response;
	public LoginCred testuser;
	// public String token;
	public Logger logger;
	public String baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";
	// protected static ExtentTest test;

	@BeforeClass
	public void setup() {

		logger = Logger.getLogger("EDENRED API");// added Logger
		PropertyConfigurator.configure("Log4j.properties"); // added logger
		logger.setLevel(Level.DEBUG);
		System.out.println("Testbase");
		
		 
	}

	public String userLogin(LoginCred user) {

		AccessToken Token = new AccessToken();
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";

		String path = "api/User/by-phone-number/" + user.getPhone();
		FConstants.Token = Token.getAccessToken(user.getPhone(), user.getPwd());
		response = RestApi.get(path, FConstants.Token);

		System.out.println(response.getBody().asString());

		String userID = response.jsonPath().getString("id");

		System.out.println("UserID " + userID);

		return userID;

	}

	public String GetUserPojo(LoginCred user) {

		AccessToken Token = new AccessToken();
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";

		String path = "api/User/by-phone-number/" + user.getPhone();
		FConstants.Token = Token.getAccessToken(user.getPhone(), user.getPwd());
		response = RestApi.get(path, FConstants.Token);

		System.out.println(response.getBody().asString());

		String userID = response.jsonPath().getString("id");

		System.out.println("UserID " + userID);

		return userID;

	}

	public void generateToken(LoginCred user) {

		AccessToken Token = new AccessToken();
		RestAssured.baseURI = "https://eae-c3pay-web-a.azurewebsites.net/";

		// String path= "api/User/by-phone-number/"+user.getPhone();
		FConstants.Token = Token.getAccessToken(user.getPhone(), user.getPwd());

	}

	public void reportLog(String message) {
		test.log(LogStatus.INFO, message);// For extentTest HTML report
		logger.info("-----" +message+"----");
		// logger.info("Message: " + message);

	}

}
