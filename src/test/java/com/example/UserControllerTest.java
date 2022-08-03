package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest 
class UserControllerTest {

    @Inject
    @Client("/")  
    HttpClient client;

    @Test
    public void testUserIdUppercase() {
        HttpRequest<String> request = HttpRequest.POST("/user", "UserId=Bob").contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        String response = client.toBlocking().retrieve(request);
        assertEquals("User [uppercase=Bob, lowercase=null]", response);
        assertNotEquals("User [uppercase=null, lowercase=Bob]", response);
    }

    @Test
    public void testUserIdLowerCase() {
        HttpRequest<String> request = HttpRequest.POST("/user", "userId=Bob").contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        String response = client.toBlocking().retrieve(request);
        assertEquals("User [uppercase=null, lowercase=Bob]", response);
        assertNotEquals("User [uppercase=Bob, lowercase=null]", response);
    }
}