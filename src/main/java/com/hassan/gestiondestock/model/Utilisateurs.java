package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Utilisateurs")
public class Utilisateurs extends AbsractEntity{

    @Embedded
    private Informations info;

    @Embedded
    private adress adressU;

    @Column(name = "motDePass")
    private String motDepass;

    @Column(name = "dateDeNaissance")
    private Instant dateDeNaissance;

    @ManyToOne
    @JoinColumn(name = "idEntrepriseU")
    private Entreprise idEntrepriseU;

    @OneToMany(mappedBy = "utilisateurId")
    private List<Roles> roles;
}
