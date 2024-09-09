package com.hanghae.hanghae_market.controller;

import com.hanghae.hanghae_market.dto.ItemRequestDto;
import com.hanghae.hanghae_market.dto.ItemResponseDto;
import com.hanghae.hanghae_market.entity.Item;
import com.hanghae.hanghae_market.repository.ItemRepository;
import com.hanghae.hanghae_market.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @PostMapping()
    public ItemResponseDto saveItem(@RequestBody ItemRequestDto requestDto){
        return itemService.saveItem(requestDto);
    }

    @GetMapping()
    public List<ItemResponseDto> getItems(){
        return itemService.getItems();
    }

    @PutMapping("{id}")
    public ItemResponseDto updateItem(@RequestBody ItemRequestDto requestDto, @PathVariable Long id){
        return itemService.updateItem(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }



}
