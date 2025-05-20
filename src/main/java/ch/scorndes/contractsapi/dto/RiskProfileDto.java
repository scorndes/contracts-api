package ch.scorndes.contractsapi.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record RiskProfileDto(
        Integer id,

        @NotNull(message = "Le nom est requis")
        @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
        String name,

        @NotNull(message = "Le minimum d'obligations est requis")
        @PositiveOrZero(message = "Le minimum d'obligations doit être positif ou zéro")
        @DecimalMax(value = "100.0", message = "Le minimum d'obligations ne doit pas dépasser 100 %")
        Double minBonds
) {}