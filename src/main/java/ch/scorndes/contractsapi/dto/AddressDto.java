package ch.scorndes.contractsapi.dto;

import java.util.UUID;

public record AddressDto(
        Integer id,
        boolean principale,
        UUID userId,
        int numero,
        String ligne1,
        String ligne2,
        String codePostal,
        String ville,
        String pays
) {}

