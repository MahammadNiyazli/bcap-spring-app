package com.company.bcapspringapp.mapper;

import com.company.bcapspringapp.dao.entity.Card;
import com.company.bcapspringapp.dto.response.CardResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardResponse toResponse(Card card);
    List<CardResponse> toResponse(List<Card> card);
}
