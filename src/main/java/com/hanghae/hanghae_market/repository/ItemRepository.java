package com.hanghae.hanghae_market.repository;

import com.hanghae.hanghae_market.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item, Long> {
}
