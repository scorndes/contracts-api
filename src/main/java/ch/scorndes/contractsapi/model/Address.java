package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "L'utilisateur est requis")
    private User user;

    @Column(name = "principale", nullable = false)
    private boolean principale;

    @Column(name = "numero", nullable = false)
    @Positive(message = "Le numéro doit être positif")
    private int numero;

    @Column(name = "ligne_1", nullable = false)
    @NotNull(message = "La ligne 1 est requise")
    @Size(max = 100, message = "La ligne 1 ne doit pas dépasser 100 caractères")
    private String ligne1;

    @Column(name = "ligne_2")
    private String ligne2;

    @Column(name = "code_postal", nullable = false)
    @NotNull(message = "Le code postal est requis")
    @Size(max = 10, message = "Le code postal ne doit pas dépasser 10 caractères")
    private String codePostal;

    @Column(name = "ville", nullable = false)
    @NotNull(message = "La ville est requise")
    @Size(max = 50, message = "La ville ne doit pas dépasser 50 caractères")
    private String ville;

    @Column(name = "pays", nullable = false)
    @NotNull(message = "Le pays est requis")
    @Size(max = 50, message = "Le pays ne doit pas dépasser 50 caractères")
    private String pays;

}
