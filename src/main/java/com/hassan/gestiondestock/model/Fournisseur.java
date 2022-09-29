package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Fournisseur")
public class Fournisseur extends AbsractEntity{

    @Embedded
    private Informations InformationsF;

    @Embedded
    private adress adressF;

    @OneToMany(mappedBy = "fournisseurid")
    private List<commandeFournisseurs> commandeFournisseur;

    @ManyToMany
    @JoinTable(
            name = "Fournisseur_Entreprise",
            joinColumns = @JoinColumn(name = "FournisseurId"),
            inverseJoinColumns = @JoinColumn(name = "EntrepriseId")
    )
    private List<Entreprise> idEntrepriseF;
}
