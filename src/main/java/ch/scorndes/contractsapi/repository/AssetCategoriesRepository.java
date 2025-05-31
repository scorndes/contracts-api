package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.AssetCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetCategoriesRepository extends JpaRepository<AssetCategories, Integer> {
}
