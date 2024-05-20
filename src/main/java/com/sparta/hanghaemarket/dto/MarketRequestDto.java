package com.sparta.hanghaemarket.dto;

import lombok.Getter;

@Getter
public class MarketRequestDto {
    private int id;
    private String username;
    private String title;
    private String contents;
    private int price;
}
