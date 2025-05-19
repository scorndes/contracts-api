package ch.scorndes.contractsapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "principale")
    private boolean principale;

    @Column(name = "numero")
    private int numero;

    @Column(name = "ligne_1")
    private String ligne1;

    @Column(name = "ligne_2")
    private String ligne2;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

}
