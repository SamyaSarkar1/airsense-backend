package com.samya.airqualitybackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AQIController {

    // 🔑 Replace with your OpenWeather API key
    private final String API_KEY = "eed2a0cd49eee0a04e110098051929cb";

    // =========================
    // ✅ TEST API
    // =========================
    @GetMapping("/test")
    public String test() {
        return "Backend is working!";
    }

    // =========================
    // ✅ AQI API (REAL DATA)
    // =========================
    @GetMapping("/aqi")
    public Map<String, Object> getAQI(
            @RequestParam double lat,
            @RequestParam double lon
    ) {

        String url = "https://api.openweathermap.org/data/2.5/air_pollution?lat="
                + lat + "&lon=" + lon + "&appid=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(url, Map.class);

        Map first = (Map) ((java.util.List) response.get("list")).get(0);
        Map main = (Map) first.get("main");

        int aqiLevel = (int) main.get("aqi");

        // Convert (1–5 → approx AQI)
        int aqi = aqiLevel * 50;

        String advice;

        if (aqi <= 50) advice = "Good - Safe";
        else if (aqi <= 100) advice = "Moderate - Be Careful";
        else if (aqi <= 200) advice = "Unhealthy - Wear Mask";
        else advice = "Hazardous - Stay Indoors";

        Map<String, Object> result = new HashMap<>();
        result.put("aqi", aqi);
        result.put("advice", advice);

        return result;
    }

    // =========================
    // ✅ ML PREDICT API (FOR LATER)
    // =========================
    @PostMapping("/predict")
    public Map<String, Object> predict(@RequestBody Map<String, Object> input) {

        int baseAQI = (int) input.get("aqi");

        // Dummy prediction (replace with Python ML later)
        int[] hourly = new int[6];
        int[] weekly = new int[7];
        int[] tenDays = new int[10];

        for (int i = 0; i < 6; i++) {
            hourly[i] = baseAQI + (int)(Math.random() * 20 - 10);
        }

        for (int i = 0; i < 7; i++) {
            weekly[i] = baseAQI + (int)(Math.random() * 30 - 15);
        }

        for (int i = 0; i < 10; i++) {
            tenDays[i] = baseAQI + (int)(Math.random() * 40 - 20);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("hourly", hourly);
        result.put("weekly", weekly);
        result.put("ten_days", tenDays);

        return result;
    }
}