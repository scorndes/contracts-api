package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.mapper.PortfolioMapper;
import ch.scorndes.contractsapi.repository.PortfolioRepository;
import ch.scorndes.contractsapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;
    private final PortfolioMapper portfolioMapper;

    PortfolioServiceImpl(PortfolioRepository portfolioRepository, UserRepository userRepository, PortfolioMapper portfolioMapper) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
        this.portfolioMapper = portfolioMapper;
    }

    @Override
    public PortfolioDto createPortefolio(PortfolioDto portfolioDto) {
        var portfolio = portfolioMapper.toModel(portfolioDto);

        // Lien utilisateur
        portfolio.setUser(
                userRepository.findById(portfolioDto.userId())
                        .orElseThrow(() -> new IllegalArgumentException("Utilisateur inconnu"))
        );

        return portfolioMapper.toDto(
                portfolioRepository.save(portfolio)
        );
    }

    @Override
    public List<PortfolioDto> getPortfolioForUser(UUID userId) {
        return portfolioRepository.findByUserId(userId).stream().map(portfolioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PortfolioDto> getSpecificPortfolio(UUID id) {
        return portfolioRepository.findById(id).map(portfolioMapper::toDto);
    }

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
