package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.RiskProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskProfileRepository extends JpaRepository<RiskProfile, Integer> {
}
