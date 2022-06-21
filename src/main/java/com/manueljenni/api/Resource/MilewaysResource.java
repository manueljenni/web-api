package com.manueljenni.api.Resource;

import com.google.gson.*;
import com.manueljenni.api.Service.MilewaysService;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  MilewaysService milewaysService;

  @GetMapping("/callMileways")
  public String callMileways() {
      return milewaysService.updateAllFlights();
  }
}
