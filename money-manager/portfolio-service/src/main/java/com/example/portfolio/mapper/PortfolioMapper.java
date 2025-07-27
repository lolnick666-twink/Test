package com.example.portfolio.mapper;

import com.example.portfolio.dto.PortfolioDto;
import com.example.portfolio.entity.Portfolio;
import com.example.portfolio.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PortfolioMapper {
    PortfolioMapper INSTANCE = Mappers.getMapper(PortfolioMapper.class);

    @Mapping(source = "currencies", target = "currencies")
    @Mapping(source = "user.id", target = "userId")  // Добавлено: userId из user.id
    @Mapping(source = "portfolio", target = "totalValue", qualifiedByName = "calculateTotalValue")
    PortfolioDto toDto(Portfolio portfolio);

    @Named("calculateTotalValue")
    default double calculateTotalValue(Portfolio portfolio) {
        // Здесь будет логика вычисления стоимости портфеля
        // Пока заглушка
        return 0.0;
    }
}