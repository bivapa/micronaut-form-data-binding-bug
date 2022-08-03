package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/user")
public class UserController {

    @Post(consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public String user(@Body User user) {
        return user.toString();
    }
}