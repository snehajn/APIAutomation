
package com.Edenred.Objects;

import java.util.HashMap;
import java.util.Map;

public enum LoginCred {



    User1("00971545091714", "test123"),
    user2("00971545092159", "test123"),
   ;

    private String phone;
    private String password;
    private String user;
    private String token;

   

    LoginCred(String phone, String password) {
        this.phone = phone;
        this.password = password;
  
    }

    /**
     * Gets the HTTP status code
     * @return the status code number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the HTTP status code as a text string
     * @return the status code as a text string
     */
    public String asUser() {
        return user;
    }

    /**
     * Get the description
     * @return the description of the status code
     */
    public String getPwd() {
        return password;
    }
    public void setToken(String token) {
    	this.token =token;
    }
    public String getToken() {
        return token;
    }


}
