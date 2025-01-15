package org.example.JavaLambda02.dto;

import lombok.Getter;

@Getter
public class RequestMessage {

    private String name;
    private String feeling;

    public void setName(String name) {
        this.name = name;
    }


    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }
}
