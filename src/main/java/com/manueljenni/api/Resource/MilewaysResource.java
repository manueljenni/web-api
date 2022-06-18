package com.manueljenni.api.Resource;

import com.google.gson.*;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/articles")
public class MilewaysResource {

  String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxOTg0IiwiaWF0IjoxNjU0OTc5NTA2LCJleHAiOjQ4MTA2NTMxMDZ9.TvgmJiTAIJa9clmuxxtQ2ny4yRuVCVhh9o8twzSxIdDYUsJ5C0w-j5Enqi_sFFPbWY-bVIpZC534dV5lBm4Hvg";

  @GetMapping("/callMileways")
  public String callMileways(
          ) throws URISyntaxException {
    String uri = "https://prod.mileways-flieger.xyz:443/api/v1/users/me/stats/top-airlines";
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + accessToken);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    RestTemplate restTemplate = new RestTemplate();
    System.out.println(headers.toString());

    HttpEntity entity = new HttpEntity(headers);

    ResponseEntity testResult = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    JsonArray result = gson.fromJson((String) testResult.getBody(), JsonArray.class);

    /*
    System.out.println(r);
    JsonObject stats = r.get("stats").getAsJsonObject();
    Long miles = stats.get("miles").getAsLong();

    return miles.toString();
    */

    JsonArray airports = result.getAsJsonArray();
    JsonObject firstAirport = airports.get(0).getAsJsonObject();

    String iata = firstAirport.get("iata").getAsString();

    return iata;

  }
}
