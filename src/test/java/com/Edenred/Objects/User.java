
package com.Edenred.Objects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"phoneNumber",
"firstName",
"lastName",
"corporateName",
"corporateId",
"employeeId",
"citizenId",
"emiratesId",
"nationality",
"email",
"deviceToken",
"rmtProfileStatus",
"emiratesIdStatus",
"emiratesIdExpiryDate",
"dateOfBirth",
"registrationDate",
"hasMoneyTransferTransactions",
"hasMoneyTransferBeneficiary",
"hasLocalMobileRechargeTransactions",
"hasInternationalMobileRechargeTransactions",
"requiresPasswordReset",
"cardPlasticType",
"atmPinPopupEnabled",
"atmPinBlockEndDate",
"moneyTransferVideoURL",
"moneyTransferVideoThumbnailURL",
"billPaymentVideoURL",
"billPaymentVideoThumbnailURL",
"referralProgramVideoURL",
"referralProgramVideoThumbnailURL",
"referralCode",
"rewardedForReferral",
"moneyTransferReferralCount",
"passportStatus",
"isVerified",
"spendPolicyDetails",
"autoplayMoneyTransferVideo"
})
@Generated("jsonschema2pojo")
public class User {

@JsonProperty("id")
private String id;
@JsonProperty("phoneNumber")
private String phoneNumber;
@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("corporateName")
private String corporateName;
@JsonProperty("corporateId")
private String corporateId;
@JsonProperty("employeeId")
private String employeeId;
@JsonProperty("citizenId")
private String citizenId;
@JsonProperty("emiratesId")
private String emiratesId;
@JsonProperty("nationality")
private String nationality;
@JsonProperty("email")
private Object email;
@JsonProperty("deviceToken")
private String deviceToken;
@JsonProperty("rmtProfileStatus")
private String rmtProfileStatus;
@JsonProperty("emiratesIdStatus")
private String emiratesIdStatus;
@JsonProperty("emiratesIdExpiryDate")
private String emiratesIdExpiryDate;
@JsonProperty("dateOfBirth")
private String dateOfBirth;
@JsonProperty("registrationDate")
private String registrationDate;
@JsonProperty("hasMoneyTransferTransactions")
private Boolean hasMoneyTransferTransactions;
@JsonProperty("hasMoneyTransferBeneficiary")
private Boolean hasMoneyTransferBeneficiary;
@JsonProperty("hasLocalMobileRechargeTransactions")
private Boolean hasLocalMobileRechargeTransactions;
@JsonProperty("hasInternationalMobileRechargeTransactions")
private Boolean hasInternationalMobileRechargeTransactions;
@JsonProperty("requiresPasswordReset")
private Boolean requiresPasswordReset;
@JsonProperty("cardPlasticType")
private Integer cardPlasticType;
@JsonProperty("atmPinPopupEnabled")
private Boolean atmPinPopupEnabled;
@JsonProperty("atmPinBlockEndDate")
private Object atmPinBlockEndDate;
@JsonProperty("moneyTransferVideoURL")
private String moneyTransferVideoURL;
@JsonProperty("moneyTransferVideoThumbnailURL")
private String moneyTransferVideoThumbnailURL;
@JsonProperty("billPaymentVideoURL")
private String billPaymentVideoURL;
@JsonProperty("billPaymentVideoThumbnailURL")
private String billPaymentVideoThumbnailURL;
@JsonProperty("referralProgramVideoURL")
private String referralProgramVideoURL;
@JsonProperty("referralProgramVideoThumbnailURL")
private String referralProgramVideoThumbnailURL;
@JsonProperty("referralCode")
private String referralCode;
@JsonProperty("rewardedForReferral")
private Boolean rewardedForReferral;
@JsonProperty("moneyTransferReferralCount")
private Integer moneyTransferReferralCount;
@JsonProperty("passportStatus")
private String passportStatus;
@JsonProperty("isVerified")
private Boolean isVerified;
@JsonProperty("spendPolicyDetails")
private SpendPolicyDetails spendPolicyDetails;
@JsonProperty("autoplayMoneyTransferVideo")
private Boolean autoplayMoneyTransferVideo;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("phoneNumber")
public String getPhoneNumber() {
return phoneNumber;
}

@JsonProperty("phoneNumber")
public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("corporateName")
public String getCorporateName() {
return corporateName;
}

@JsonProperty("corporateName")
public void setCorporateName(String corporateName) {
this.corporateName = corporateName;
}

@JsonProperty("corporateId")
public String getCorporateId() {
return corporateId;
}

@JsonProperty("corporateId")
public void setCorporateId(String corporateId) {
this.corporateId = corporateId;
}

@JsonProperty("employeeId")
public String getEmployeeId() {
return employeeId;
}

@JsonProperty("employeeId")
public void setEmployeeId(String employeeId) {
this.employeeId = employeeId;
}

@JsonProperty("citizenId")
public String getCitizenId() {
return citizenId;
}

@JsonProperty("citizenId")
public void setCitizenId(String citizenId) {
this.citizenId = citizenId;
}

@JsonProperty("emiratesId")
public String getEmiratesId() {
return emiratesId;
}

@JsonProperty("emiratesId")
public void setEmiratesId(String emiratesId) {
this.emiratesId = emiratesId;
}

@JsonProperty("nationality")
public String getNationality() {
return nationality;
}

@JsonProperty("nationality")
public void setNationality(String nationality) {
this.nationality = nationality;
}

@JsonProperty("email")
public Object getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(Object email) {
this.email = email;
}

@JsonProperty("deviceToken")
public String getDeviceToken() {
return deviceToken;
}

@JsonProperty("deviceToken")
public void setDeviceToken(String deviceToken) {
this.deviceToken = deviceToken;
}

@JsonProperty("rmtProfileStatus")
public String getRmtProfileStatus() {
return rmtProfileStatus;
}

@JsonProperty("rmtProfileStatus")
public void setRmtProfileStatus(String rmtProfileStatus) {
this.rmtProfileStatus = rmtProfileStatus;
}

@JsonProperty("emiratesIdStatus")
public String getEmiratesIdStatus() {
return emiratesIdStatus;
}

@JsonProperty("emiratesIdStatus")
public void setEmiratesIdStatus(String emiratesIdStatus) {
this.emiratesIdStatus = emiratesIdStatus;
}

@JsonProperty("emiratesIdExpiryDate")
public String getEmiratesIdExpiryDate() {
return emiratesIdExpiryDate;
}

@JsonProperty("emiratesIdExpiryDate")
public void setEmiratesIdExpiryDate(String emiratesIdExpiryDate) {
this.emiratesIdExpiryDate = emiratesIdExpiryDate;
}

@JsonProperty("dateOfBirth")
public String getDateOfBirth() {
return dateOfBirth;
}

@JsonProperty("dateOfBirth")
public void setDateOfBirth(String dateOfBirth) {
this.dateOfBirth = dateOfBirth;
}

@JsonProperty("registrationDate")
public String getRegistrationDate() {
return registrationDate;
}

@JsonProperty("registrationDate")
public void setRegistrationDate(String registrationDate) {
this.registrationDate = registrationDate;
}

@JsonProperty("hasMoneyTransferTransactions")
public Boolean getHasMoneyTransferTransactions() {
return hasMoneyTransferTransactions;
}

@JsonProperty("hasMoneyTransferTransactions")
public void setHasMoneyTransferTransactions(Boolean hasMoneyTransferTransactions) {
this.hasMoneyTransferTransactions = hasMoneyTransferTransactions;
}

@JsonProperty("hasMoneyTransferBeneficiary")
public Boolean getHasMoneyTransferBeneficiary() {
return hasMoneyTransferBeneficiary;
}

@JsonProperty("hasMoneyTransferBeneficiary")
public void setHasMoneyTransferBeneficiary(Boolean hasMoneyTransferBeneficiary) {
this.hasMoneyTransferBeneficiary = hasMoneyTransferBeneficiary;
}

@JsonProperty("hasLocalMobileRechargeTransactions")
public Boolean getHasLocalMobileRechargeTransactions() {
return hasLocalMobileRechargeTransactions;
}

@JsonProperty("hasLocalMobileRechargeTransactions")
public void setHasLocalMobileRechargeTransactions(Boolean hasLocalMobileRechargeTransactions) {
this.hasLocalMobileRechargeTransactions = hasLocalMobileRechargeTransactions;
}

@JsonProperty("hasInternationalMobileRechargeTransactions")
public Boolean getHasInternationalMobileRechargeTransactions() {
return hasInternationalMobileRechargeTransactions;
}

@JsonProperty("hasInternationalMobileRechargeTransactions")
public void setHasInternationalMobileRechargeTransactions(Boolean hasInternationalMobileRechargeTransactions) {
this.hasInternationalMobileRechargeTransactions = hasInternationalMobileRechargeTransactions;
}

@JsonProperty("requiresPasswordReset")
public Boolean getRequiresPasswordReset() {
return requiresPasswordReset;
}

@JsonProperty("requiresPasswordReset")
public void setRequiresPasswordReset(Boolean requiresPasswordReset) {
this.requiresPasswordReset = requiresPasswordReset;
}

@JsonProperty("cardPlasticType")
public Integer getCardPlasticType() {
return cardPlasticType;
}

@JsonProperty("cardPlasticType")
public void setCardPlasticType(Integer cardPlasticType) {
this.cardPlasticType = cardPlasticType;
}

@JsonProperty("atmPinPopupEnabled")
public Boolean getAtmPinPopupEnabled() {
return atmPinPopupEnabled;
}

@JsonProperty("atmPinPopupEnabled")
public void setAtmPinPopupEnabled(Boolean atmPinPopupEnabled) {
this.atmPinPopupEnabled = atmPinPopupEnabled;
}

@JsonProperty("atmPinBlockEndDate")
public Object getAtmPinBlockEndDate() {
return atmPinBlockEndDate;
}

@JsonProperty("atmPinBlockEndDate")
public void setAtmPinBlockEndDate(Object atmPinBlockEndDate) {
this.atmPinBlockEndDate = atmPinBlockEndDate;
}

@JsonProperty("moneyTransferVideoURL")
public String getMoneyTransferVideoURL() {
return moneyTransferVideoURL;
}

@JsonProperty("moneyTransferVideoURL")
public void setMoneyTransferVideoURL(String moneyTransferVideoURL) {
this.moneyTransferVideoURL = moneyTransferVideoURL;
}

@JsonProperty("moneyTransferVideoThumbnailURL")
public String getMoneyTransferVideoThumbnailURL() {
return moneyTransferVideoThumbnailURL;
}

@JsonProperty("moneyTransferVideoThumbnailURL")
public void setMoneyTransferVideoThumbnailURL(String moneyTransferVideoThumbnailURL) {
this.moneyTransferVideoThumbnailURL = moneyTransferVideoThumbnailURL;
}

@JsonProperty("billPaymentVideoURL")
public String getBillPaymentVideoURL() {
return billPaymentVideoURL;
}

@JsonProperty("billPaymentVideoURL")
public void setBillPaymentVideoURL(String billPaymentVideoURL) {
this.billPaymentVideoURL = billPaymentVideoURL;
}

@JsonProperty("billPaymentVideoThumbnailURL")
public String getBillPaymentVideoThumbnailURL() {
return billPaymentVideoThumbnailURL;
}

@JsonProperty("billPaymentVideoThumbnailURL")
public void setBillPaymentVideoThumbnailURL(String billPaymentVideoThumbnailURL) {
this.billPaymentVideoThumbnailURL = billPaymentVideoThumbnailURL;
}

@JsonProperty("referralProgramVideoURL")
public String getReferralProgramVideoURL() {
return referralProgramVideoURL;
}

@JsonProperty("referralProgramVideoURL")
public void setReferralProgramVideoURL(String referralProgramVideoURL) {
this.referralProgramVideoURL = referralProgramVideoURL;
}

@JsonProperty("referralProgramVideoThumbnailURL")
public String getReferralProgramVideoThumbnailURL() {
return referralProgramVideoThumbnailURL;
}

@JsonProperty("referralProgramVideoThumbnailURL")
public void setReferralProgramVideoThumbnailURL(String referralProgramVideoThumbnailURL) {
this.referralProgramVideoThumbnailURL = referralProgramVideoThumbnailURL;
}

@JsonProperty("referralCode")
public String getReferralCode() {
return referralCode;
}

@JsonProperty("referralCode")
public void setReferralCode(String referralCode) {
this.referralCode = referralCode;
}

@JsonProperty("rewardedForReferral")
public Boolean getRewardedForReferral() {
return rewardedForReferral;
}

@JsonProperty("rewardedForReferral")
public void setRewardedForReferral(Boolean rewardedForReferral) {
this.rewardedForReferral = rewardedForReferral;
}

@JsonProperty("moneyTransferReferralCount")
public Integer getMoneyTransferReferralCount() {
return moneyTransferReferralCount;
}

@JsonProperty("moneyTransferReferralCount")
public void setMoneyTransferReferralCount(Integer moneyTransferReferralCount) {
this.moneyTransferReferralCount = moneyTransferReferralCount;
}

@JsonProperty("passportStatus")
public String getPassportStatus() {
return passportStatus;
}

@JsonProperty("passportStatus")
public void setPassportStatus(String passportStatus) {
this.passportStatus = passportStatus;
}

@JsonProperty("isVerified")
public Boolean getIsVerified() {
return isVerified;
}

@JsonProperty("isVerified")
public void setIsVerified(Boolean isVerified) {
this.isVerified = isVerified;
}

@JsonProperty("spendPolicyDetails")
public SpendPolicyDetails getSpendPolicyDetails() {
return spendPolicyDetails;
}

@JsonProperty("spendPolicyDetails")
public void setSpendPolicyDetails(SpendPolicyDetails spendPolicyDetails) {
this.spendPolicyDetails = spendPolicyDetails;
}

@JsonProperty("autoplayMoneyTransferVideo")
public Boolean getAutoplayMoneyTransferVideo() {
return autoplayMoneyTransferVideo;
}

@JsonProperty("autoplayMoneyTransferVideo")
public void setAutoplayMoneyTransferVideo(Boolean autoplayMoneyTransferVideo) {
this.autoplayMoneyTransferVideo = autoplayMoneyTransferVideo;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("id");
sb.append('=');
sb.append(((this.id == null)?"<null>":this.id));
sb.append(',');
sb.append("phoneNumber");
sb.append('=');
sb.append(((this.phoneNumber == null)?"<null>":this.phoneNumber));
sb.append(',');
sb.append("firstName");
sb.append('=');
sb.append(((this.firstName == null)?"<null>":this.firstName));
sb.append(',');
sb.append("lastName");
sb.append('=');
sb.append(((this.lastName == null)?"<null>":this.lastName));
sb.append(',');
sb.append("corporateName");
sb.append('=');
sb.append(((this.corporateName == null)?"<null>":this.corporateName));
sb.append(',');
sb.append("corporateId");
sb.append('=');
sb.append(((this.corporateId == null)?"<null>":this.corporateId));
sb.append(',');
sb.append("employeeId");
sb.append('=');
sb.append(((this.employeeId == null)?"<null>":this.employeeId));
sb.append(',');
sb.append("citizenId");
sb.append('=');
sb.append(((this.citizenId == null)?"<null>":this.citizenId));
sb.append(',');
sb.append("emiratesId");
sb.append('=');
sb.append(((this.emiratesId == null)?"<null>":this.emiratesId));
sb.append(',');
sb.append("nationality");
sb.append('=');
sb.append(((this.nationality == null)?"<null>":this.nationality));
sb.append(',');
sb.append("email");
sb.append('=');
sb.append(((this.email == null)?"<null>":this.email));
sb.append(',');
sb.append("deviceToken");
sb.append('=');
sb.append(((this.deviceToken == null)?"<null>":this.deviceToken));
sb.append(',');
sb.append("rmtProfileStatus");
sb.append('=');
sb.append(((this.rmtProfileStatus == null)?"<null>":this.rmtProfileStatus));
sb.append(',');
sb.append("emiratesIdStatus");
sb.append('=');
sb.append(((this.emiratesIdStatus == null)?"<null>":this.emiratesIdStatus));
sb.append(',');
sb.append("emiratesIdExpiryDate");
sb.append('=');
sb.append(((this.emiratesIdExpiryDate == null)?"<null>":this.emiratesIdExpiryDate));
sb.append(',');
sb.append("dateOfBirth");
sb.append('=');
sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
sb.append(',');
sb.append("registrationDate");
sb.append('=');
sb.append(((this.registrationDate == null)?"<null>":this.registrationDate));
sb.append(',');
sb.append("hasMoneyTransferTransactions");
sb.append('=');
sb.append(((this.hasMoneyTransferTransactions == null)?"<null>":this.hasMoneyTransferTransactions));
sb.append(',');
sb.append("hasMoneyTransferBeneficiary");
sb.append('=');
sb.append(((this.hasMoneyTransferBeneficiary == null)?"<null>":this.hasMoneyTransferBeneficiary));
sb.append(',');
sb.append("hasLocalMobileRechargeTransactions");
sb.append('=');
sb.append(((this.hasLocalMobileRechargeTransactions == null)?"<null>":this.hasLocalMobileRechargeTransactions));
sb.append(',');
sb.append("hasInternationalMobileRechargeTransactions");
sb.append('=');
sb.append(((this.hasInternationalMobileRechargeTransactions == null)?"<null>":this.hasInternationalMobileRechargeTransactions));
sb.append(',');
sb.append("requiresPasswordReset");
sb.append('=');
sb.append(((this.requiresPasswordReset == null)?"<null>":this.requiresPasswordReset));
sb.append(',');
sb.append("cardPlasticType");
sb.append('=');
sb.append(((this.cardPlasticType == null)?"<null>":this.cardPlasticType));
sb.append(',');
sb.append("atmPinPopupEnabled");
sb.append('=');
sb.append(((this.atmPinPopupEnabled == null)?"<null>":this.atmPinPopupEnabled));
sb.append(',');
sb.append("atmPinBlockEndDate");
sb.append('=');
sb.append(((this.atmPinBlockEndDate == null)?"<null>":this.atmPinBlockEndDate));
sb.append(',');
sb.append("moneyTransferVideoURL");
sb.append('=');
sb.append(((this.moneyTransferVideoURL == null)?"<null>":this.moneyTransferVideoURL));
sb.append(',');
sb.append("moneyTransferVideoThumbnailURL");
sb.append('=');
sb.append(((this.moneyTransferVideoThumbnailURL == null)?"<null>":this.moneyTransferVideoThumbnailURL));
sb.append(',');
sb.append("billPaymentVideoURL");
sb.append('=');
sb.append(((this.billPaymentVideoURL == null)?"<null>":this.billPaymentVideoURL));
sb.append(',');
sb.append("billPaymentVideoThumbnailURL");
sb.append('=');
sb.append(((this.billPaymentVideoThumbnailURL == null)?"<null>":this.billPaymentVideoThumbnailURL));
sb.append(',');
sb.append("referralProgramVideoURL");
sb.append('=');
sb.append(((this.referralProgramVideoURL == null)?"<null>":this.referralProgramVideoURL));
sb.append(',');
sb.append("referralProgramVideoThumbnailURL");
sb.append('=');
sb.append(((this.referralProgramVideoThumbnailURL == null)?"<null>":this.referralProgramVideoThumbnailURL));
sb.append(',');
sb.append("referralCode");
sb.append('=');
sb.append(((this.referralCode == null)?"<null>":this.referralCode));
sb.append(',');
sb.append("rewardedForReferral");
sb.append('=');
sb.append(((this.rewardedForReferral == null)?"<null>":this.rewardedForReferral));
sb.append(',');
sb.append("moneyTransferReferralCount");
sb.append('=');
sb.append(((this.moneyTransferReferralCount == null)?"<null>":this.moneyTransferReferralCount));
sb.append(',');
sb.append("passportStatus");
sb.append('=');
sb.append(((this.passportStatus == null)?"<null>":this.passportStatus));
sb.append(',');
sb.append("isVerified");
sb.append('=');
sb.append(((this.isVerified == null)?"<null>":this.isVerified));
sb.append(',');
sb.append("spendPolicyDetails");
sb.append('=');
sb.append(((this.spendPolicyDetails == null)?"<null>":this.spendPolicyDetails));
sb.append(',');
sb.append("autoplayMoneyTransferVideo");
sb.append('=');
sb.append(((this.autoplayMoneyTransferVideo == null)?"<null>":this.autoplayMoneyTransferVideo));
sb.append(',');
sb.append("additionalProperties");
sb.append('=');
sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}