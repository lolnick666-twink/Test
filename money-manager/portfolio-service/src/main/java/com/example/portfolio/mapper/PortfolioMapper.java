package com.example.portfolio.mapper;

import com.example.portfolio.dto.PortfolioDto;
import com.example.portfolio.entity.Portfolio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PortfolioMapper {
    PortfolioMapper INSTANCE = Mappers.getMapper(PortfolioMapper.class);

    @Mapping(source = "currencies", target = "currencies")
    PortfolioDto toDto(Portfolio portfolio);
}