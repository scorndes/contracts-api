package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.PortfolioAssetClass;
import ch.scorndes.contractsapi.model.PortfolioAssetClassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioAssetClassRepository extends JpaRepository<PortfolioAssetClass, PortfolioAssetClassId> {

}
