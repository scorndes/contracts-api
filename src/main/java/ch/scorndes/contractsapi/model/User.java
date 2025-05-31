package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    @Column(name = "username", nullable = false)
    @NotNull(message = "Le nom d'utilisateur est requis")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et 50 caractères")
    private String username;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Le mot de passe est requis")
    @Size(min = 8, message = "Le mot de passe doit avoir au moins 8 caractères")
    private String password;

    @Column(name = "email", nullable = false)
    @NotNull(message = "L'email' est requis")
    @Email(message = "L'email doit être valide")
    private String email;

    @Column(name = "lastname", nullable = false)
    @NotNull(message = "Le nom de famille est requis")
    private String lastname;

    @Column(name = "firstname", nullable = false)
    @NotNull(message = "Le prénom est requis")
    private String firstname;

    @Column(name = "birthname", nullable = true)
    private String birthname;

    @Column(name = "birthdate", nullable = false)
    @NotNull(message = "La date de naissance est requise")
    private LocalDateTime birthdate;

    @Column(name = "role", nullable = false)
    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios;

}
