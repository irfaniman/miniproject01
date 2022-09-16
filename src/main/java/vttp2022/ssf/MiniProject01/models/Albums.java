package vttp2022.ssf.MiniProject01.models;
import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Albums {
    
    private String idAlbum;
    private String strAlbum;
    private String strArtist;
    private String intYearReleased;
    private String strAlbumCDart;
    private String strDescriptionEN;

    public String getIdAlbum() { return idAlbum; }
    public void setIdAlbum(String idAlbum) { this.idAlbum = idAlbum; }
    
    public String getStrAlbum() { return strAlbum; }
    public void setStrAlbum(String strAlbum) { this.strAlbum = strAlbum; }
    
    public String getStrArtist() { return strArtist; }
    public void setStrArtist(String strArtist) { this.strArtist = strArtist; }
    
    public String getIntYearReleased() { return intYearReleased; }
    public void setIntYearReleased(String intYearReleased) { this.intYearReleased = intYearReleased; }
    
    public String getStrAlbumCDart() { return strAlbumCDart; }
    public void setStrAlbumCDart(String strAlbumCDart) { this.strAlbumCDart = strAlbumCDart; }
    
    public String getStrDescriptionEN() { return strDescriptionEN; }
    public void setStrDescriptionEN(String strDescriptionEN) { this.strDescriptionEN = strDescriptionEN; }

    // Json to model
    public static Albums create(JsonObject jo) {
        Albums a = new Albums();
        a.setIdAlbum(jo.getString("idAlbum"));
        a.setStrAlbum(jo.getString("strAlbum"));
        a.setStrArtist(jo.getString("strArtist"));
        a.setIntYearReleased(jo.getString("intYearReleased"));
        //a.setStrAlbumCDart(jo.getString("strAlbumCDart"));
        //a.setStrDescriptionEN(jo.getString("strDescriptionEN"));
        return a;
    }
    
    // model to Json
    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("idAlbum", this.idAlbum)
        .add("strAlbum", this.strAlbum)
        .add("strArtist", this.strArtist)
        .add("intYearReleased", this.intYearReleased)
        .add("strAlbumCDart", this.strAlbumCDart)
        .add("strDescriptionEN", this.strDescriptionEN)
        .build();
    }
    
    public static Albums create(String json) {
        try (StringReader strReader = new StringReader(json)) {
            JsonReader j = Json.createReader(strReader);
            return create(j.readObject());
        }
    }
    
}
