package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "L'utilisateur est requis")
    private User user;

    @Column(nullable = false)
    @NotNull(message = "Le nom est requis")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    private String name;

    @ManyToOne
    @JoinColumn(name = "risk_profile_id", nullable = false)
    @NotNull(message = "Le profil de risque est requis")
    private RiskProfile riskProfile;

    @Column(precision = 5, scale = 2, nullable = false)
    @NotNull(message = "La part des actions est requise")
    @PositiveOrZero(message = "La part des actions doit être positive ou zéro")
    private double stocks;

    @Column(precision = 5, scale = 2, nullable = false)
    @NotNull(message = "La part des obligations est requise")
    @PositiveOrZero(message = "La part des obligations doit être positive ou zéro")
    private double bonds;

    @Column(name = "created_at", nullable = false)
    @NotNull(message = "La date de création est requise")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioAssetClass> portfolioAssetClasses;

}
