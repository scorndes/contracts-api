package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.mapper.PortfolioMapper;
import ch.scorndes.contractsapi.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    PortfolioServiceImpl(PortfolioRepository portfolioRepository, PortfolioMapper portfolioMapper) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioMapper = portfolioMapper;
    }

    @Override
    public List<PortfolioDto> getPortfolioForUser(UUID userId) {
        return portfolioRepository.findByUserId(userId).stream().map(portfolioMapper::toDto).collect(Collectors.toList());
    }

}
