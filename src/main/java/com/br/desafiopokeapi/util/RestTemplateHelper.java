package com.br.desafiopokeapi.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateHelper {

    public RestTemplate getInstance(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public HttpEntity getHttpEntity(HttpHeaders headers){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }



}
