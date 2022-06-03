package com.Edenred.Objects;

public class APIEndPoint {

	 public static final String Money_Transfer_Beneficiary = "api/MoneyTransfer/beneficiary/{userId}";
	    public static final String fx = "/api/MoneyTransfer/fx-rate/{userId}/{toCurrency}/{amount}";
	    public static final String eligibility = "/api/MoneyTransfer/transfer-limit-iseligible/{userId}/{transferType}/{countryCode}/{amount}";
	    public static final String sendmoney = "api/MoneyTransfer/send-money";
	    
	    
	    
	    
	    

}
