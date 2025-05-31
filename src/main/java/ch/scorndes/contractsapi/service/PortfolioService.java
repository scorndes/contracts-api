package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.PortfolioDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PortfolioService {

    PortfolioDto createPortefolio(PortfolioDto portfolioDto);
    List<PortfolioDto> getPortfolioForUser(UUID userId);
    Optional<PortfolioDto> getSpecificPortfolio(UUID id);
    Optional<PortfolioDto> updatePortefolio(PortfolioDto portfolioDto);
    boolean deletePortefolio(UUID id);
}
