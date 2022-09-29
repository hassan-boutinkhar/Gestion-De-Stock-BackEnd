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
@Table(name = "commandeFournisseurs")
public class commandeFournisseurs extends AbsractEntity{

    @Column(name = "code")
    private String  code;

    @Column(name = "dateCommande")
    private Instant dateComande;

    @ManyToOne
    @JoinColumn(name = "fournisseurid")
    private Fournisseur fournisseurid;

    @OneToMany(mappedBy = "commandeFournisseursFid")
    private List<LigneCommandeFournisseurs> ligneCommandeFournisseursF;


}
