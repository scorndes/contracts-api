package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.AssetClassDto;
import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.dto.RiskProfileDto;
import ch.scorndes.contractsapi.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<PortfolioDto> getPortfolioForUser(UUID userId) {
        return portfolioRepository.findByUserId(userId).stream().map(pf -> {
                   return new PortfolioDto(
                           pf.getId(),
                           userId,
                           pf.getName(),
                           new RiskProfileDto(pf.getRiskProfile().getId(),
                                   pf.getRiskProfile().getName(),
                                   pf.getRiskProfile().getMinBonds()),
                           pf.getStocks(),
                           pf.getBonds(),
                           pf.getCreatedAt(),
                           pf.getPortfolioAssetClasses().stream()
                                   .map(ac -> new AssetClassDto(ac.getAssetClass().getId(),
                                           ac.getAssetClass().getName(),
                                           ac.getAssetClass().getCategory(),
                                           ac.getPercentage()))
                                   .collect(Collectors.toList())
                   );
                }).collect(Collectors.toList());
    }

}
