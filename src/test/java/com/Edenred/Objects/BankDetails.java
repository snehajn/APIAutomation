
package com.Edenred.Objects;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bankName",
"bankBranchName",
"address1",
"address2",
"bankCode",
"bankBranchCode",
"accountNumber",
"isBranchSelected"
})
@Generated("jsonschema2pojo")
public class BankDetails {

@JsonProperty("bankName")
private String bankName;
@JsonProperty("bankBranchName")
private String bankBranchName;
@JsonProperty("address1")
private String address1;
@JsonProperty("address2")
private String address2;
@JsonProperty("bankCode")
private String bankCode;
@JsonProperty("bankBranchCode")
private String bankBranchCode;
@JsonProperty("accountNumber")
private String accountNumber;
@JsonProperty("isBranchSelected")
private Boolean isBranchSelected;

@JsonProperty("bankName")
public String getBankName() {
return bankName;
}

@JsonProperty("bankName")
public void setBankName(String bankName) {
this.bankName = bankName;
}

@JsonProperty("bankBranchName")
public String getBankBranchName() {
return bankBranchName;
}

@JsonProperty("bankBranchName")
public void setBankBranchName(String bankBranchName) {
this.bankBranchName = bankBranchName;
}

@JsonProperty("address1")
public String getAddress1() {
return address1;
}

@JsonProperty("address1")
public void setAddress1(String address1) {
this.address1 = address1;
}

@JsonProperty("address2")
public String getAddress2() {
return address2;
}

@JsonProperty("address2")
public void setAddress2(String address2) {
this.address2 = address2;
}

@JsonProperty("bankCode")
public String getBankCode() {
return bankCode;
}

@JsonProperty("bankCode")
public void setBankCode(String bankCode) {
this.bankCode = bankCode;
}

@JsonProperty("bankBranchCode")
public String getBankBranchCode() {
return bankBranchCode;
}

@JsonProperty("bankBranchCode")
public void setBankBranchCode(String bankBranchCode) {
this.bankBranchCode = bankBranchCode;
}

@JsonProperty("accountNumber")
public String getAccountNumber() {
return accountNumber;
}

@JsonProperty("accountNumber")
public void setAccountNumber(String accountNumber) {
this.accountNumber = accountNumber;
}

@JsonProperty("isBranchSelected")
public Boolean getIsBranchSelected() {
return isBranchSelected;
}

@JsonProperty("isBranchSelected")
public void setIsBranchSelected(Boolean isBranchSelected) {
this.isBranchSelected = isBranchSelected;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(BankDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("bankName");
sb.append('=');
sb.append(((this.bankName == null)?"<null>":this.bankName));
sb.append(',');
sb.append("bankBranchName");
sb.append('=');
sb.append(((this.bankBranchName == null)?"<null>":this.bankBranchName));
sb.append(',');
sb.append("address1");
sb.append('=');
sb.append(((this.address1 == null)?"<null>":this.address1));
sb.append(',');
sb.append("address2");
sb.append('=');
sb.append(((this.address2 == null)?"<null>":this.address2));
sb.append(',');
sb.append("bankCode");
sb.append('=');
sb.append(((this.bankCode == null)?"<null>":this.bankCode));
sb.append(',');
sb.append("bankBranchCode");
sb.append('=');
sb.append(((this.bankBranchCode == null)?"<null>":this.bankBranchCode));
sb.append(',');
sb.append("accountNumber");
sb.append('=');
sb.append(((this.accountNumber == null)?"<null>":this.accountNumber));
sb.append(',');
sb.append("isBranchSelected");
sb.append('=');
sb.append(((this.isBranchSelected == null)?"<null>":this.isBranchSelected));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}