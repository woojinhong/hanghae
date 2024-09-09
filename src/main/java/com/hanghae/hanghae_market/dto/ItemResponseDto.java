package com.hanghae.hanghae_market.dto;

import com.hanghae.hanghae_market.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;


    public ItemResponseDto(Item saveItem) {
        this.id = saveItem.getId();
        this.username = saveItem.getUsername();
        this.title = saveItem.getTitle();
        this.content = saveItem.getContent();
        this.price = saveItem.getPrice();
    }
}
