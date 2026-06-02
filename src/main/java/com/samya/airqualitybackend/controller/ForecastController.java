package com.samya.airqualitybackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ForecastController {

    @GetMapping("/forecast")
    public String forecast() {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "https://airsense-ml-zzkk.onrender.com/forecast",
                String.class
        );
    }
}