package com.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GroqService {

    @Value("${groq.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String URL =
            "https://api.groq.com/openai/v1/chat/completions";

    public String test() {
        return apiKey;
    }
    public String getResponse(String message) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("model", "llama-3.3-70b-versatile");

        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", message);

        requestBody.put("messages", List.of(userMessage));

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                URL,
                entity,
                Map.class
        );

        Map<String, Object> responseBody = response.getBody();

        List<Map<String, Object>> choices =
                (List<Map<String, Object>>) responseBody.get("choices");

        Map<String, Object> firstChoice = choices.get(0);

        Map<String, Object> messageMap =
                (Map<String, Object>) firstChoice.get("message");

        String aiResponse = (String) messageMap.get("content");

        return aiResponse;
    }
}