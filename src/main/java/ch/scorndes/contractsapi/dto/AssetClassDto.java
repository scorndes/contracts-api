package ch.scorndes.contractsapi.dto;

import java.util.List;
import java.util.UUID;

public record AssetClassDto(
        Integer id,
        String name,
        String category,
        List<UUID> portfolioIds
) {}
