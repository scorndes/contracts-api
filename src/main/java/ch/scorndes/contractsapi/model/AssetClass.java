package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "asset_classes")
public class AssetClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Le nom est requis")
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
    private String name;

    @Column(name = "category", nullable = false)
    @NotNull(message = "La catégorie est requise")
    @Size(max = 50, message = "La catégorie ne doit pas dépasser 50 caractères")
    private String category;

    @OneToMany(mappedBy = "assetClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioAssetClass> portfolioAssetClasses;

}
