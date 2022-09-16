package vttp2022.ssf.MiniProject01.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Artist {

    private String idArtist;
    private String strArtist;
    private String strLabel;
    private String intFormedYear;
    private String strStyle;
    private String strGenre;
    private String strBiographyEN;
    private String strCountry;
    private String strArtistThumb;
    private String strArtistLogo;


    public String getStrArtistLogo() { return strArtistLogo; }
    public void setStrArtistLogo(String strArtistLogo) { this.strArtistLogo = strArtistLogo; }
    
    public String getIdArtist() { return idArtist; }
    public void setIdArtist(String idArtist) { this.idArtist = idArtist; }
    
    public String getStrArtist() { return strArtist; }
    public void setStrArtist(String strArtist) { this.strArtist = strArtist; }
    
    public String getStrLabel() { return strLabel; }
    public void setStrLabel(String strLabel) { this.strLabel = strLabel; }
    
    public String getIntFormedYear() { return intFormedYear; }
    public void setIntFormedYear(String intFormedYear) { this.intFormedYear = intFormedYear; }
    
    public String getStrStyle() { return strStyle; }
    public void setStrStyle(String strStyle) { this.strStyle = strStyle; }
    
    public String getStrGenre() { return strGenre; }
    public void setStrGenre(String strGenre) { this.strGenre = strGenre; }
    
    public String getStrBiographyEn() { return strBiographyEN; }
    public void setStrBiographyEn(String strBiographyEN) { this.strBiographyEN = strBiographyEN; }
    
    public String getStrCountry() { return strCountry; }
    public void setStrCountry(String strCountry) { this.strCountry = strCountry; }
    
    public String getStrArtistThumb() { return strArtistThumb; }
    public void setStrArtistThumb(String strArtistThumb) { this.strArtistThumb = strArtistThumb; }


    // Json to model
    public static Artist create(JsonObject jo) {
        Artist p = new Artist();
        p.setIdArtist(jo.getString("idArtist"));
        p.setStrArtist(jo.getString("strArtist"));
        p.setStrLabel(jo.getString("strLabel"));
        p.setIntFormedYear(jo.getString("intFormedYear"));
        p.setStrStyle(jo.getString("strStyle"));
        p.setStrGenre(jo.getString("strGenre"));
        p.setStrBiographyEn(jo.getString("strBiographyEN"));
        p.setStrCountry(jo.getString("strCountry"));
        p.setStrArtistThumb(jo.getString("strArtistThumb"));
        p.setStrArtistLogo(jo.getString("strArtistLogo"));
        return p;
    }

    // model to Json
    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("idArtist", this.idArtist)
        .add("strArtist", this.strArtist)
        .add("strLabel", this.strLabel)
        .add("intFormedYear", this.intFormedYear)
        .add("strStyle", this.strStyle)
        .add("strGenre", this.strGenre)
        .add("strBiographyEN", this.strBiographyEN)
        .add("strCountry", this.strCountry)
        .add("strArtistThumb", this.strArtistThumb)
        .add("strArtistThumb", this.strArtistLogo)
        .build();
    }

    public static Artist create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
        }
    }

}

