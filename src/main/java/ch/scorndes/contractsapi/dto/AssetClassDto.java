package ch.scorndes.contractsapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record AssetClassDto(
        Integer id,

        @NotNull(message = "Le nom est requis")
        @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
        String name,

        @NotNull(message = "La catégorie est requise")
        @Size(max = 50, message = "La catégorie ne doit pas dépasser 50 caractères")
        String category,

        @Size(max = 50, message = "La liste des portefeuilles ne doit pas contenir plus de 50 éléments")
        List<UUID> portfolioIds
) {}
