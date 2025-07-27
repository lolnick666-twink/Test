package com.example.currency.mapper;

import com.example.currency.dto.CurrencyDto;
import com.example.currency.entity.CurrencyRate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    // Явно игнорируем id при маппинге из DTO в Entity
    @Mapping(target = "id", ignore = true)
    CurrencyRate toEntity(CurrencyDto dto);

    // Обратное маппинг — из Entity в DTO
    CurrencyDto toDto(CurrencyRate rate);
}