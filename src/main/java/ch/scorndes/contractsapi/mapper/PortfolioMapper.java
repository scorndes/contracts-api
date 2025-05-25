package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AssetClassDto;
import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.dto.RiskProfileDto;
import ch.scorndes.contractsapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {RiskProfileMapper.class, AssetClassMapper.class})
public interface PortfolioMapper extends UserIdMapperSupport {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "assetClass", expression = "java(mapAssetClasses(portfolio))")
    PortfolioDto toDto(Portfolio portfolio);

    @Mapping(target = "user", source = "userId")
    @Mapping(target = "portfolioAssetClasses", expression = "java(mapPortfolioAssetClass(portfolioDto))")
    Portfolio toModel(PortfolioDto portfolioDto);

    default List<PortfolioAssetClass> mapPortfolioAssetClass(PortfolioDto dto) {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(dto.id());

        return dto.assetClass().stream()
                .map(acDto -> {
                    PortfolioAssetClass pac = new PortfolioAssetClass();
                    AssetClass ac = new AssetClass();
                    ac.setId(ac.getId());
                    pac.setPortfolio(portfolio);
                    pac.setAssetClass(ac);
                    pac.setPercentage(acDto.percentage());
                    return pac;
                })
                .collect(Collectors.toList());
    }

    default List<AssetClassDto> mapAssetClasses(Portfolio portfolio) {
        return portfolio.getPortfolioAssetClasses().stream()
                .map(pac -> toDtoForPortfolio(pac.getAssetClass(), portfolio.getId()))
                .toList();
    }

    AssetClassDto toDtoForPortfolio(AssetClass assetClass, UUID portfolioId);

}
