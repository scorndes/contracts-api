package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
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
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @ManyToOne @JoinColumn(name = "risk_profile_id")
    private  RiskProfile riskProfile;

    @Column(precision = 5, scale = 2)
    private double stocks;

    @Column(precision = 5, scale = 2)
    private double bonds;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioAssetClass> portfolioAssetClasses;

}
