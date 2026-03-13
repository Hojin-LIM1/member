package com.example.demo.dto;

import lombok.Getter;

@Getter
public class UpdateMemberResponse {
    private final Long id;
    private final String name;
    private final Integer age;
    private final String mbti;

    public UpdateMemberResponse(Long id, String name, Integer age, String mbti) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }
}
