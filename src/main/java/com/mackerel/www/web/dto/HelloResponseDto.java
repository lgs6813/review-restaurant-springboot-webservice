package com.mackerel.www.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
//선언된 모든 필드의 get 메소드를 생성해줌
@Getter
//RequiredArgsConstructor
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}

