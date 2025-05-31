package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
@Table(name = "portfolio_asset_classes")
public class PortfolioAssetClass {

    @EmbeddedId
    private PortfolioAssetClassId id;

    @ManyToOne
    @MapsId("portfolioId")
    @JoinColumn(name = "portfolio_id", nullable = false)
    @NotNull(message = "Le portefeuille est requis")
    private Portfolio portfolio;

    @ManyToOne
    @MapsId("assetClassId")
    @JoinColumn(name = "asset_class_id", nullable = false)
    @NotNull(message = "La classe d'actifs est requise")
    private AssetClass assetClass;

    @Column(name = "percentage", nullable = false)
    @NotNull(message = "Le pourcentage est requis")
    @PositiveOrZero(message = "Le pourcentage doit être positif ou zéro")
    private double percentage;

}
