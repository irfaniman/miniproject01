package vttp2022.ssf.MiniProject01.services;


import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import vttp2022.ssf.MiniProject01.models.RealTimeInfo;

@Service
public class RealTimeService {

    @Autowired 
    private static final String AIRLABS_URL = "https://airlabs.co/api/v9/flights";
        
    @Value("${AIRLABS_KEY}")
    private String key;

    public List<RealTimeInfo> getRealTimeFlights() {

        String payload;

        System.out.println("Getting information from Airlabs");

        // Creating url with query string
        String url = UriComponentsBuilder.fromUriString(AIRLABS_URL)
                .queryParam("api_key", key)
                .toUriString();

            // Create the GET request, get URL
            RequestEntity<Void> req = RequestEntity.get(url).build();

            // Make the call to cryptoCompare
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp;
    
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

            Reader strReader = new StringReader(payload);
            // Create a JsonReader from reader
            JsonReader jsonReader = Json.createReader(strReader);
            // Read the payload as Json Object
            JsonObject ProfileResult = jsonReader.readObject();

            JsonArray data = ProfileResult.getJsonArray("response");
            List<RealTimeInfo> list = new LinkedList<>();
            for (int i = 0; i <data.size(); i++ ) {
                JsonObject jo = data.getJsonObject(i);
                list.add(RealTimeInfo.create(jo));
                
            }

        return list;
        
    }

}



