package vttp2022.ssf.MiniProject01.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class RealTimeInfo {
    
    private String reg_number;
    private String flag;
    private String flight_icao;
    private String status;

    public String getReg_number() { return reg_number; }
    public void setReg_number(String reg_number) { this.reg_number = reg_number; }
    
    public String getFlag() { return flag; }
    public void setFlag(String flag) { this.flag = flag; }
    
    public String getFlight_icao() { return flight_icao; }
    public void setFlight_icao(String flight_icao) { this.flight_icao = flight_icao; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Json to model
    public static RealTimeInfo create(JsonObject jo) {
        RealTimeInfo p = new RealTimeInfo();
        p.setReg_number(jo.getString("reg_number"));
        p.setFlag(jo.getString("flag"));
        p.setFlight_icao(jo.getString("flight_icao"));
        p.setStatus(jo.getString("status"));
        return p;
    }

    // model to Json
    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("reg_number", reg_number)
        .add("flag", flag)
        .add("flight_icao", flight_icao)
        .add("status", status)
        .build();
    }

    public static RealTimeInfo create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
        }
    }

}

