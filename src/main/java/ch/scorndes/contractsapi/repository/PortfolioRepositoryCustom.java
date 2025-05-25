package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Portfolio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PortfolioRepositoryCustom {

    List<Portfolio> findByUserId(UUID userId);
    boolean isPortfolioWithId(UUID id);

}
