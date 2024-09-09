package com.hanghae.hanghae_market.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ItemRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;
}
