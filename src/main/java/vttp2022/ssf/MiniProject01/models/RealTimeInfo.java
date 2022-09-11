package vttp2022.ssf.MiniProject01.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class RealTimeInfo {
    
    private String reg_number;
    private String flag;
    private String aircraft_icao;
    private String status;

    public String getReg_number() { return reg_number; }
    public void setReg_number(String reg_number) { this.reg_number = reg_number; }
    
    public String getFlag() { return flag; }
    public void setFlag(String flag) { this.flag = flag; }
    
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAircraft_icao() {
        return aircraft_icao;
    }
    public void setAircraft_icao(String aircraft_icao) {
        this.aircraft_icao = aircraft_icao;
    }

    // Json to model
    public static RealTimeInfo create(JsonObject jo) {
        RealTimeInfo p = new RealTimeInfo();
        // p.setReg_number(jo.getString("reg_number"));
        // p.setFlag(jo.getString("flag"));
        // p.setAircraft_icao(jo.getString("flight_icao"));
        p.setStatus(jo.getString("status"));
        return p;
    }

    // model to Json
    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("reg_number", this.reg_number)
        .add("flag", this.flag)
        .add("flight_icao", this.aircraft_icao)
        .add("status", this.status)
        .build();
    }

    public static RealTimeInfo create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
        }
    }

}

