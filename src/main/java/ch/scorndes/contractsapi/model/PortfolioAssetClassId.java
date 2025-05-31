package ch.scorndes.contractsapi.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioAssetClassId implements Serializable {
    private UUID portfolioId;
    private Integer assetClassId;
}
