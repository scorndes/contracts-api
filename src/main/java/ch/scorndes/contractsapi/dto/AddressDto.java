package ch.scorndes.contractsapi.dto;

public record AddressDto(
        Integer id,
        UserDto user,
        boolean principale,
        int numero,
        String ligne1,
        String ligne2,
        String codePostal,
        String ville,
        String pays
) {}

