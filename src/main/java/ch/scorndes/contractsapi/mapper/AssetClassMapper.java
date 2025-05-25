package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AssetClassDto;
import ch.scorndes.contractsapi.dto.AssetClassWithPortfoliosDto;
import ch.scorndes.contractsapi.model.AssetClass;
import ch.scorndes.contractsapi.model.Portfolio;
import ch.scorndes.contractsapi.model.PortfolioAssetClass;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AssetClassMapper {

    default AssetClassDto toDtoForPortfolio(AssetClass assetClass, UUID portfolioId) {
        double percentage = assetClass.getPortfolioAssetClasses().stream()
                .filter(pac -> pac.getPortfolio().getId().equals(portfolioId))
                .map(PortfolioAssetClass::getPercentage)
                .findFirst()
                .orElse(0.0);

        return new AssetClassDto(
                assetClass.getId(),
                assetClass.getName(),
                assetClass.getCategory(),
                percentage
        );
    }

    default AssetClassWithPortfoliosDto toDtoWithPortfolios(AssetClass assetClass) {
        List<UUID> portfolioIds = assetClass.getPortfolioAssetClasses().stream()
                .map(pac -> pac.getPortfolio().getId())
                .distinct()
                .toList();

        return new AssetClassWithPortfoliosDto(
                assetClass.getId(),
                assetClass.getName(),
                assetClass.getCategory(),
                portfolioIds
        );
    }
}
