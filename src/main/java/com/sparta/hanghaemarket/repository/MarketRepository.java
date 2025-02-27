package com.sparta.hanghaemarket.repository;

import com.sparta.hanghaemarket.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {


}
