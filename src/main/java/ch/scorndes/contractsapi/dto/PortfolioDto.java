package ch.scorndes.contractsapi.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PortfolioDto(
        UUID id,

        @NotNull(message = "L'ID utilisateur est requis")
        UUID userId,

        @NotNull(message = "Le nom est requis")
        @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
        String name,

        @NotNull(message = "Le profil de risque est requis")
        RiskProfileDto riskProfile,

        @NotNull(message = "La part des actions est requise")
        @PositiveOrZero(message = "La part des actions doit être positive ou zéro")
        @DecimalMax(value = "100.0", message = "La part des actions ne doit pas dépasser 100 %")
        Double stocks,

        @NotNull(message = "La part des obligations est requise")
        @PositiveOrZero(message = "La part des obligations doit être positive ou zéro")
        @DecimalMax(value = "100.0", message = "La part des obligations ne doit pas dépasser 100 %")
        Double bonds,

        @NotNull(message = "La date de création est requise")
        LocalDateTime createdAt,

        @Size(max = 50, message = "La liste des classes d'actifs ne doit pas contenir plus de 50 éléments")
        List<AssetClassDto> assetClass
) {}