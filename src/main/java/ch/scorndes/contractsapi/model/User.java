package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    private UUID id;

    @Column(name = "username")
    @NotNull(message = "Le nom d'utilisateur est requis")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et 50 caractères")
    private String username;

    @Column(name = "password")
    @NotNull(message = "Le mot de passe est requis")
    @Size(min = 8, message = "Le mot de passe doit avoir au moins 8 caractères")
    private String password;

    @Column(name = "email")
    @NotNull(message = "L'email' est requis")
    @Email(message = "L'email doit être valide")
    private String email;

    @Column(name = "role")
    private String role = "USER";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
