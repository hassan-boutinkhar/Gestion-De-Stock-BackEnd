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
@Table(name = "CommandeClient")
public class CommandeClient extends AbsractEntity{

    @Column(name = "code")
    private String  code;

    @Column(name = "dateCommande")
    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private clients clientId;

    @OneToMany(mappedBy = "commandeClientsId")
    private List<ligneCommandeClients> ligneCommandeClients;

}
