package ch.scorndes.contractsapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record UserDto (
        UUID id,

        @NotNull(message = "Le nom d'utilisateur est requis")
        @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et 50 caractères")
        String username,

        @NotNull(message = "L'email est requis")
        @Email(message = "L'email doit être valide")
        @Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères")
        String email,

        @Size(max = 10, message = "La liste des adresses ne doit pas contenir plus de 10 éléments")
        List<AddressDto> addresses
){}
