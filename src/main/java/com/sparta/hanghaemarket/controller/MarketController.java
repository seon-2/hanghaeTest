package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.MarketRequestDto;
import com.sparta.hanghaemarket.dto.MarketResponseDto;
import com.sparta.hanghaemarket.entity.Market;
import com.sparta.hanghaemarket.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class MarketController {
    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    // 판매 게시글 작성
    @PostMapping()
    public MarketResponseDto createMarket(MarketRequestDto marketRequestDto) {
        return marketService.createMarket(marketRequestDto);
    }

    // 판매 게시글 전체 조회
    @GetMapping()
    public List<MarketResponseDto> getMarket() {
        return marketService.getMarkets();
    }

    // 판매 게시글 상세 조회
    @GetMapping("/{id}")
    public Market getMarketById(@PathVariable("id") Long id) {
        return marketService.getMarketById(id);
    }

    // 판매 게시글을 수정하는 API
    @PutMapping("/{id}")
    public Long updateMarket(@PathVariable Long id, MarketRequestDto marketRequestDto) {
        return marketService.updateMarket(id, marketRequestDto);
    }

    // 판매 게시글을 삭제하는 API
    @DeleteMapping("/{id}")
    public Long deleteMarket(@PathVariable Long id) {
        return marketService.deleteMarket(id);
    }
}
