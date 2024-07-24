package com.company.bcapspringapp.controller;

import com.company.bcapspringapp.dto.response.base.SuccessResponse;
import com.company.bcapspringapp.dto.response.CardResponse;
import com.company.bcapspringapp.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cards") // localhost:8080/api/v1/cards/customer-id/2
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @GetMapping
    public SuccessResponse<List<CardResponse>> getCardsByCustomerId(
            @RequestHeader(name = "x-customer-id") Long customerId,
            @RequestParam(name = "isActive", required = false, defaultValue = "true") Boolean isActive) {
        return cardService.getCardsByCustomerId(customerId, isActive); // TDD - Test driven development
    }
}
