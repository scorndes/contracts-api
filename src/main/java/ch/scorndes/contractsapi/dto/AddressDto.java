package ch.scorndes.contractsapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AddressDto(
        Integer id,

        boolean principale,

        @NotNull(message = "L'ID utilisateur est requis")
        UUID userId,

        @Positive(message = "Le numéro doit être positif")
        int numero,

        @NotNull(message = "La ligne 1 est requise")
        @Size(max = 100, message = "La ligne 1 ne doit pas dépasser 100 caractères")
        String ligne1,

        @Size(max = 100, message = "La ligne 2 ne doit pas dépasser 100 caractères")
        String ligne2,

        @NotNull(message = "Le code postal est requis")
        @Size(max = 10, message = "Le code postal ne doit pas dépasser 10 caractères")
        String codePostal,

        @NotNull(message = "La ville est requise")
        @Size(max = 50, message = "La ville ne doit pas dépasser 50 caractères")
        String ville,

        @NotNull(message = "Le pays est requis")
        @Size(max = 50, message = "Le pays ne doit pas dépasser 50 caractères")
        String pays
) {}

