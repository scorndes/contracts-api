package ch.scorndes.contractsapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserDto (
        UUID id,

        @NotNull(message = "Le nom d'utilisateur est requis")
        @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et 50 caractères")
        String username,

        @NotNull(message = "Le nom de famille est requis")
        @Size(min = 3, max = 50, message = "Le nom de famille doit avoir entre 3 et 50 caractères")
        String lastname,

        @NotNull(message = "Le prénom est requis")
        @Size(min = 3, max = 50, message = "Le prénom doit avoir entre 3 et 50 caractères")
        String firstname,

        @Size(min = 3, max = 50, message = "Le nom de naissance doit avoir entre 3 et 50 caractères")
        String birthname,

        @NotNull(message = "La date de naissance est requise")
        LocalDateTime birthdate,

        @NotNull(message = "L'email est requis")
        @Email(message = "L'email doit être valide")
        @Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères")
        String email,

        @Size(max = 10, message = "La liste des adresses ne doit pas contenir plus de 10 éléments")
        List<AddressDto> addresses
){}
