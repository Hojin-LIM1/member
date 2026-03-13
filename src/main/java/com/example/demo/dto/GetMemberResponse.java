package com.example.demo.dto;


import lombok.Getter;

@Getter
public class GetMemberResponse {

    private final Long id;
    private final String name;
    private final Integer age;
    private final String mbti;
    private final String profileImageUrl;

    public GetMemberResponse(Long id, String name, Integer age, String mbti, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbti;
        this.profileImageUrl = profileImageUrl;
    }
}
