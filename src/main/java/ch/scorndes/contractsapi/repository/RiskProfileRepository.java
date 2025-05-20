package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.RiskProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskProfileRepository extends JpaRepository<RiskProfile, Integer> {
}
