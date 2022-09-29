package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "LigneCommandeFournisseurs")
public class LigneCommandeFournisseurs extends AbsractEntity{
    @ManyToOne
    @JoinColumn(name = "articleIdCF")
    private Article articleIdCF;

    @ManyToOne
    @JoinColumn(name = "commandeFournisseursFid")
    private commandeFournisseurs commandeFournisseursFid;

}
