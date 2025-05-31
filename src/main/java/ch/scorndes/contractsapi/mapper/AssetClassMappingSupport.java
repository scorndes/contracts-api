package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AssetClassDto;
import ch.scorndes.contractsapi.model.AssetClass;
import ch.scorndes.contractsapi.model.PortfolioAssetClass;

import java.util.UUID;

public interface AssetClassMappingSupport {

    default AssetClassDto toDtoForPortfolio(AssetClass assetClass, UUID portfolioId) {
        double percentage = assetClass.getPortfolioAssetClasses().stream()
                .filter(pac -> pac.getPortfolio().getId().equals(portfolioId))
                .map(PortfolioAssetClass::getPercentage)
                .findFirst()
                .orElse(0.0);

        return new AssetClassDto(
                assetClass.getId(),
                assetClass.getName(),
                assetClass.getCategory() != null ? assetClass.getCategory().getName() : null,
                percentage
        );
    }
}
