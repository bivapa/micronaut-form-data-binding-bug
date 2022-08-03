package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("UserId")
    private String uppercase;

    @JsonProperty("userId")
    private String lowercase;

    @Override
    public String toString() {
        return "User [uppercase=" + uppercase + ", lowercase=" + lowercase + "]";
    }
}
