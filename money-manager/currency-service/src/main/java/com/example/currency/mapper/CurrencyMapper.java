package com.example.currency.mapper;

import com.example.currency.dto.CurrencyDto;
import com.example.currency.entity.CurrencyRate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    CurrencyDto toDto(CurrencyRate rate);
    @Mapping(target = "id", ignore = true)
    CurrencyRate toEntity(CurrencyDto dto);
}