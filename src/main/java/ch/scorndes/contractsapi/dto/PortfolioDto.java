package ch.scorndes.contractsapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PortfolioDto(
        UUID id,
        UserDto user,
        String name,
        RiskProfileDto riskProfile,
        double stocks,
        double bonds,
        LocalDateTime createdAt,
        List<PortfolioAssetClassDto> portfolioAssetClasses
) {}