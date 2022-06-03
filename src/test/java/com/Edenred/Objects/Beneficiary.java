
package com.Edenred.Objects;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.Edenred.Objects.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"firstName",
"middleName",
"lastName",
"country",
"countryName",
"id",
"bankDetails",
"remarksForFailed",
"cashPickupProvider",
"moneyTransferPurpose",
"transferMethod",
"beneficiaryDate",
"isManualApproval",
"status",
"subStatus"
})
@Generated("jsonschema2pojo")
public class Beneficiary {

@JsonProperty("firstName")
private String firstName;
@JsonProperty("middleName")
private String middleName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("country")
private String country;
@JsonProperty("countryName")
private String countryName;
@JsonProperty("id")
private String id;
@JsonProperty("bankDetails")
private BankDetails bankDetails;
@JsonProperty("remarksForFailed")
private String remarksForFailed;
@JsonProperty("cashPickupProvider")
private String cashPickupProvider;
@JsonProperty("moneyTransferPurpose")
private String moneyTransferPurpose;
@JsonProperty("transferMethod")
private String transferMethod;
@JsonProperty("beneficiaryDate")
private String beneficiaryDate;
@JsonProperty("isManualApproval")
private Boolean isManualApproval;
@JsonProperty("status")
private String status;
@JsonProperty("subStatus")
private String subStatus;


@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("middleName")
public String getMiddleName() {
return middleName;
}

@JsonProperty("middleName")
public void setMiddleName(String middleName) {
this.middleName = middleName;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("countryName")
public String getCountryName() {
return countryName;
}

@JsonProperty("countryName")
public void setCountryName(String countryName) {
this.countryName = countryName;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("bankDetails")
public BankDetails getBankDetails() {
return bankDetails;
}

@JsonProperty("bankDetails")
public void setBankDetails(BankDetails bankDetails) {
this.bankDetails = bankDetails;
}

@JsonProperty("remarksForFailed")
public String getRemarksForFailed() {
return remarksForFailed;
}

@JsonProperty("remarksForFailed")
public void setRemarksForFailed(String remarksForFailed) {
this.remarksForFailed = remarksForFailed;
}

@JsonProperty("cashPickupProvider")
public String getCashPickupProvider() {
return cashPickupProvider;
}

@JsonProperty("cashPickupProvider")
public void setCashPickupProvider(String cashPickupProvider) {
this.cashPickupProvider = cashPickupProvider;
}

@JsonProperty("moneyTransferPurpose")
public String getMoneyTransferPurpose() {
return moneyTransferPurpose;
}

@JsonProperty("moneyTransferPurpose")
public void setMoneyTransferPurpose(String moneyTransferPurpose) {
this.moneyTransferPurpose = moneyTransferPurpose;
}

@JsonProperty("transferMethod")
public String getTransferMethod() {
return transferMethod;
}

@JsonProperty("transferMethod")
public void setTransferMethod(String transferMethod) {
this.transferMethod = transferMethod;
}

@JsonProperty("beneficiaryDate")
public String getBeneficiaryDate() {
return beneficiaryDate;
}

@JsonProperty("beneficiaryDate")
public void setBeneficiaryDate(String beneficiaryDate) {
this.beneficiaryDate = beneficiaryDate;
}

@JsonProperty("isManualApproval")
public Boolean getIsManualApproval() {
return isManualApproval;
}

@JsonProperty("isManualApproval")
public void setIsManualApproval(Boolean isManualApproval) {
this.isManualApproval = isManualApproval;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("subStatus")
public String getSubStatus() {
return subStatus;
}

@JsonProperty("subStatus")
public void setSubStatus(String subStatus) {
this.subStatus = subStatus;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(Beneficiary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("firstName");
sb.append('=');
sb.append(((this.firstName == null)?"<null>":this.firstName));
sb.append(',');
sb.append("middleName");
sb.append('=');
sb.append(((this.middleName == null)?"<null>":this.middleName));
sb.append(',');
sb.append("lastName");
sb.append('=');
sb.append(((this.lastName == null)?"<null>":this.lastName));
sb.append(',');
sb.append("country");
sb.append('=');
sb.append(((this.country == null)?"<null>":this.country));
sb.append(',');
sb.append("countryName");
sb.append('=');
sb.append(((this.countryName == null)?"<null>":this.countryName));
sb.append(',');
sb.append("id");
sb.append('=');
sb.append(((this.id == null)?"<null>":this.id));
sb.append(',');
sb.append("bankDetails");
sb.append('=');
sb.append(((this.bankDetails == null)?"<null>":this.bankDetails));
sb.append(',');
sb.append("remarksForFailed");
sb.append('=');
sb.append(((this.remarksForFailed == null)?"<null>":this.remarksForFailed));
sb.append(',');
sb.append("cashPickupProvider");
sb.append('=');
sb.append(((this.cashPickupProvider == null)?"<null>":this.cashPickupProvider));
sb.append(',');
sb.append("moneyTransferPurpose");
sb.append('=');
sb.append(((this.moneyTransferPurpose == null)?"<null>":this.moneyTransferPurpose));
sb.append(',');
sb.append("transferMethod");
sb.append('=');
sb.append(((this.transferMethod == null)?"<null>":this.transferMethod));
sb.append(',');
sb.append("beneficiaryDate");
sb.append('=');
sb.append(((this.beneficiaryDate == null)?"<null>":this.beneficiaryDate));
sb.append(',');
sb.append("isManualApproval");
sb.append('=');
sb.append(((this.isManualApproval == null)?"<null>":this.isManualApproval));
sb.append(',');
sb.append("status");
sb.append('=');
sb.append(((this.status == null)?"<null>":this.status));
sb.append(',');
sb.append("subStatus");
sb.append('=');
sb.append(((this.subStatus == null)?"<null>":this.subStatus));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}