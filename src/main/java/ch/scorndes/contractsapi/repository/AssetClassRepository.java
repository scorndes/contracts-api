package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.AssetClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetClassRepository extends JpaRepository<AssetClass, Integer> {
}
