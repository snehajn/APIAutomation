
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
"spendPolicyActive",
"spendPolicyId"
})
@Generated("jsonschema2pojo")
public class SpendPolicyDetails {

@JsonProperty("spendPolicyActive")
private Boolean spendPolicyActive;
@JsonProperty("spendPolicyId")
private Object spendPolicyId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("spendPolicyActive")
public Boolean getSpendPolicyActive() {
return spendPolicyActive;
}

@JsonProperty("spendPolicyActive")
public void setSpendPolicyActive(Boolean spendPolicyActive) {
this.spendPolicyActive = spendPolicyActive;
}

@JsonProperty("spendPolicyId")
public Object getSpendPolicyId() {
return spendPolicyId;
}

@JsonProperty("spendPolicyId")
public void setSpendPolicyId(Object spendPolicyId) {
this.spendPolicyId = spendPolicyId;
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
sb.append(SpendPolicyDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("spendPolicyActive");
sb.append('=');
sb.append(((this.spendPolicyActive == null)?"<null>":this.spendPolicyActive));
sb.append(',');
sb.append("spendPolicyId");
sb.append('=');
sb.append(((this.spendPolicyId == null)?"<null>":this.spendPolicyId));
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