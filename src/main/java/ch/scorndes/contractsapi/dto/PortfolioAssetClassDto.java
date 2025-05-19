package ch.scorndes.contractsapi.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

public record PortfolioAssetClassDto(
        PortfolioDto portfolio,
        AssetClassDto assetClass,
        double percentage
) {}