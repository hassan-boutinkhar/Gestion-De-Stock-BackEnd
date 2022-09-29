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
@Table(name = "ligneCommandeClients")
public class ligneCommandeClients extends AbsractEntity{


    @ManyToOne
    @JoinColumn(name = "articleIdCC")
    private Article articleIdCC;

    @ManyToOne
    @JoinColumn(name = "commandeClientsId")
    private CommandeClient commandeClientsId;
}
