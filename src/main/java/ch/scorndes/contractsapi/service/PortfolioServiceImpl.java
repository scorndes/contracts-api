package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.mapper.PortfolioMapper;
import ch.scorndes.contractsapi.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<PortfolioDto> getSpecificPortfolio(UUID id) {
        return portfolioRepository.findById(id).map(portfolioMapper::toDto);
    }

//    public PortfolioDto createPortefolio(PortfolioDto portfolioDto) {
//
//        return portfolioMapper.toDto(portfolioRepository.save(portfolioMapper.toModel(portfolioDto)));
//    }

    public Optional<PortfolioDto> updatePortefolio(PortfolioDto portfolioDto) {
        if (this.portfolioRepository.isPortfolioWithId(portfolioDto.id()))
            return Optional.of(portfolioMapper.toDto(portfolioRepository.save(portfolioMapper.toModel(portfolioDto))));
        return Optional.empty();
    }

    public boolean deletePortefolio(UUID id) {
        if (this.portfolioRepository.isPortfolioWithId(id)) {
            portfolioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
