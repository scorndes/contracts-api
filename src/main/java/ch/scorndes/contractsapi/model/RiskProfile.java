package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "risk_profiles")
public class RiskProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "min_bonds", precision = 5, scale = 2)
    private Double minBonds;

}
