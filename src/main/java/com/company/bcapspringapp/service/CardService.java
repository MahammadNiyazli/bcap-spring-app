package com.company.bcapspringapp.service;

import com.company.bcapspringapp.ResponseCodes;
import com.company.bcapspringapp.dao.repository.CardRepository;
import com.company.bcapspringapp.dto.response.base.SuccessResponse;
import com.company.bcapspringapp.dto.response.CardResponse;
import com.company.bcapspringapp.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public SuccessResponse<List<CardResponse>> getCardsByCustomerId(Long customerId, boolean isActive){
        List<CardResponse> cardResponseList = cardRepository
                .findByCustomer_IdAndIsActiveWithJQPL(customerId, isActive)
                .stream()
                .map(cardMapper::toResponse)
                .toList();

        return SuccessResponse.createBaseResponse(cardResponseList, ResponseCodes.DEFAULT_SUCCESS);
    }
}
