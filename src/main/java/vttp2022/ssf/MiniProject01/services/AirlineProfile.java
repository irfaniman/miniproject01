package vttp2022.ssf.MiniProject01.services;


import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2022.ssf.MiniProject01.models.ProfileInfo;

@Service
public class AirlineProfile {
    
    private static final String AIRLABS_URL = "https://airlabs.co/api/v9/airlines";
        
    @Value("${AIRLABS_KEY}")
    private String key;

    public List<ProfileInfo> getAirlineProfile() {

        String payload;

        String url = UriComponentsBuilder
                .fromHttpUrl(AIRLABS_URL)
                .queryParam("iata_code", "SQ")
                .queryParam("api_key", key)
                .toUriString();

        RequestEntity<Void> req = RequestEntity
                .get(url)
                .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp; // from the response body, we are expecting string
    
        try {
        //Throws an exception if status code not in between 200-399
            resp = template.exchange(req, String.class);
        } catch(Exception ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
            return Collections.emptyList();
        }
             
        // Get the payload and do something with it
        payload = resp.getBody();
        System.out.println("payload: " + payload);
    
        // Convert payload to JsonObject
        // Convert String to a Reader
        Reader strReader = new StringReader(payload);
        // Create a JsonReader from reader
        JsonReader jsonReader = Json.createReader(strReader);
        // Read the payload ad Json Object
        JsonObject profileInfoResult = jsonReader.readObject();
        JsonArray cities = profileInfoResult.getJsonArray("weather");
        List<ProfileInfo> list = new LinkedList<>();
        for (int i = 0; i <cities.size(); i++ ) {
            // weather [0]
            JsonObject jo = cities.getJsonObject(i);
            list.add(ProfileInfo.create(jo));
        }

        return list;

    }
    

} 
