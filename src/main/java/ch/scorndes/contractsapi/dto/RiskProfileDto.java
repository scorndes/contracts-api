package ch.scorndes.contractsapi.dto;

public record RiskProfileDto(
        Integer id,
        String name,
        double minBonds
) {}