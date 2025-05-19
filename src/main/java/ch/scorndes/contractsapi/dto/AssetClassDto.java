package ch.scorndes.contractsapi.dto;

import java.util.List;

public record AssetClassDto(
        Integer id,
        String name,
        String category,
        List<PortfolioAssetClassDto> portfolioAssetClasses
) {}
