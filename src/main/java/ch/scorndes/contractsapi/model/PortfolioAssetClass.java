package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "portfolio_asset_classes")
@IdClass(PortfolioAssetClassId.class)
public class PortfolioAssetClass {

    @Id
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portefolio portefolio;

    @Id
    @ManyToOne
    @JoinColumn(name = "asset_class_id")
    private AssetClass assetClass;

    @Column(name = "percentage", precision = 5, scale = 2)
    private Double percentage;

}
