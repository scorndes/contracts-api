package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AssetClassDto;
import ch.scorndes.contractsapi.dto.AssetClassWithPortfoliosDto;
import ch.scorndes.contractsapi.model.AssetCategories;
import ch.scorndes.contractsapi.model.AssetClass;
import ch.scorndes.contractsapi.model.PortfolioAssetClass;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AssetClassMapper extends AssetClassMappingSupport{

    default AssetClassWithPortfoliosDto toDtoWithPortfolios(AssetClass assetClass) {
        List<UUID> portfolioIds = assetClass.getPortfolioAssetClasses().stream()
                .map(pac -> pac.getPortfolio().getId())
                .distinct()
                .toList();

        return new AssetClassWithPortfoliosDto(
                assetClass.getId(),
                assetClass.getName(),
                assetClass.getCategory() != null ? assetClass.getCategory().getName() : null,
                portfolioIds
        );
    }

    default String map(AssetCategories category) {
        return category != null ? category.getName() : null;
    }

}
