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
public interface PortfolioMapper extends UserIdMapperSupport, AssetClassMappingSupport {

    default PortfolioDto toDto(Portfolio portfolio) {
        return new PortfolioDto(
                portfolio.getId(),
                portfolio.getUser() != null ? portfolio.getUser().getId() : null,
                portfolio.getName(),
                mapRiskProfile(portfolio.getRiskProfile()),
                portfolio.getStocks(),
                portfolio.getBonds(),
                portfolio.getCreatedAt(),
                mapAssetClasses(portfolio)
        );
    }

    default RiskProfileDto mapRiskProfile(RiskProfile riskProfile) {
        if (riskProfile == null) return null;
        return new RiskProfileDto(riskProfile.getId(), riskProfile.getName(), riskProfile.getMinBonds());
    }

    default Portfolio toModel(PortfolioDto dto) {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(dto.id());
        portfolio.setName(dto.name());
        portfolio.setStocks(dto.stocks());
        portfolio.setBonds(dto.bonds());
        portfolio.setCreatedAt(dto.createdAt());

        if (dto.riskProfile() != null) {
            RiskProfile rp = new RiskProfile();
            rp.setId(dto.riskProfile().id());
            portfolio.setRiskProfile(rp);
        }

        portfolio.setPortfolioAssetClasses(mapPortfolioAssetClass(dto));
        // user à injecter côté service
        return portfolio;
    }

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

}
