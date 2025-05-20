package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
}
