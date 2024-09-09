package com.hanghae.hanghae_market.service;

import com.hanghae.hanghae_market.dto.ItemRequestDto;
import com.hanghae.hanghae_market.dto.ItemResponseDto;
import com.hanghae.hanghae_market.entity.Item;
import com.hanghae.hanghae_market.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    // 판매 게시글 작성
    public ItemResponseDto saveItem(ItemRequestDto requestDto) {
        Item saveItem = new Item(requestDto);
        itemRepository.save(saveItem);

        ItemResponseDto itemResponseDto = new ItemResponseDto(saveItem);
        return itemResponseDto;
    }

    // 판매 게시글 전체 리스트 조회
    public List<ItemResponseDto> getItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();

        for (Item item : items) {
            itemResponseDtos.add(new ItemResponseDto(item));
        }

        return itemResponseDtos;
    }

    public ItemResponseDto updateItem(ItemRequestDto requestDto, Long id) {
        Item findItem = itemRepository.findById(id).orElseThrow(()->
                new NullPointerException("해당 아이템 조회 불가능")
                );

        // 필드 값이 null이 아닌 경우에만 업데이트
        Item updatedItem = Item.builder()
                .id(findItem.getId())
                .title(requestDto.getTitle() != null ? requestDto.getTitle() : findItem.getTitle())
                .content(requestDto.getContent() != null ? requestDto.getContent() : findItem.getContent())
                .price(requestDto.getPrice() != 0 ? requestDto.getPrice() : findItem.getPrice())
                .username(requestDto.getUsername() != null ? requestDto.getUsername() : findItem.getUsername())
                .build();

        // 수정된 객체 저장
        Item savedItem = itemRepository.save(updatedItem);

        return new ItemResponseDto(savedItem);
    }

    public ResponseEntity<?> deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        // 게시글 삭제
        itemRepository.delete(item);

        // 성공 메시지를 JSON 형식으로 반환
        Map<String, String> responseMsg = new HashMap<>();
        responseMsg.put("msg", "삭제 완료");
        // 성공 메시지 반환
        return ResponseEntity.ok(responseMsg);
    }
}

