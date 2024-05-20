package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.MarketRequestDto;
import com.sparta.hanghaemarket.dto.MarketResponseDto;
import com.sparta.hanghaemarket.entity.Market;
import com.sparta.hanghaemarket.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketResponseDto createMarket(MarketRequestDto marketRequestDto) {
        Market market = new Market(marketRequestDto);

        Market saveMarket = marketRepository.save(market);

        MarketResponseDto marketResponseDto = new MarketResponseDto(saveMarket);

        return marketResponseDto;
    }

    public List<MarketResponseDto> getMarkets() {
        return marketRepository.findAll().stream().map(MarketResponseDto::new).toList();
    }

    public Market getMarketById(Long id) {
        return marketRepository.findById(id).orElse(null);
    }

    @Transactional
    public Long updateMarket(Long id, MarketRequestDto marketRequestDto) {
        // 있는지 확인
        Market market = findMarket(id);

        // 수정
        market.update(marketRequestDto);

        return id;

    }


    public Long deleteMarket(Long id) {
        // 있는지 확인
        Market market = findMarket(id);

        // 삭제
        marketRepository.delete(market);

        return id;
    }

    // 게시글 있는지 확인하는 함수
    private Market findMarket(Long id) {
        return marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글이 없습니다.")
        );
    }
}
