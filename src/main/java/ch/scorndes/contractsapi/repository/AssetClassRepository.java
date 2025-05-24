package ch.scorndes.contractsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetClassRepository extends JpaRepository<AssetClassRepository, Integer> {
}
