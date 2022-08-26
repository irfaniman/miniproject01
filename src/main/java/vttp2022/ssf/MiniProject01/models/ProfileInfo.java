package vttp2022.ssf.MiniProject01.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class ProfileInfo {
    
    private String name;
    private String callsign;
    private String country_code;
    private String website;
    private String instagram;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCallsign() { return callsign; }
    public void setCallsign(String callsign) { this.callsign = callsign; }
    
    public String getCountry_code() { return country_code; }
    public void setCountry_code(String country_code) { this.country_code = country_code; }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    
    public String getInstagram() { return instagram; }
    public void setInstagram(String instagram) { this.instagram = instagram; }


    // Json to model
    public static ProfileInfo create(JsonObject jo) {
        ProfileInfo p = new ProfileInfo();
        p.setName(jo.getString("name"));
        p.setCallsign(jo.getString("callsign"));
        p.setCountry_code(jo.getString("country_code"));
        p.setWebsite(jo.getString("website"));
        p.setInstagram(jo.getString("instagram"));
        return p;
    }
    // model to Json
    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("name", name)
        .add("callsign", callsign)
        .add("country_code", country_code)
        .add("webiste", website)
        .add("instagram", instagram)
        .build();
    }

    public static ProfileInfo create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
        }
    }

}
