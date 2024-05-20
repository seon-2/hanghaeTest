package com.sparta.hanghaemarket.dto;

import com.sparta.hanghaemarket.entity.Market;

public class MarketResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private int price;

    public MarketResponseDto(Market market) {
        this.id = market.getId();
        this.username = market.getUsername();
        this.title = market.getTitle();
        this.contents = market.getContents();
        this.price = market.getPrice();
    }

    public MarketResponseDto(Long id, String username, String title, String contents, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.price = price;
    }
}
