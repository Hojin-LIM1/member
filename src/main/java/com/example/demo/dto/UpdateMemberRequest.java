package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMemberRequest {

    @NotBlank(message = "필수로 입력해주세요")
    private String name;

    private Integer age;

    private String mbti;
}
