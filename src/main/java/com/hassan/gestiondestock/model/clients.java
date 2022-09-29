package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clients")
public class clients extends AbsractEntity{

    @Embedded
    private Informations InformationsC;
    @Embedded
    private adress adressC;

    @OneToMany(mappedBy = "clientId")
    private List<CommandeClient> commandeClients;

    @ManyToMany
    @JoinTable(
            name = "Clients_Entreprise",
            joinColumns = @JoinColumn(name = "ClientsId"),
            inverseJoinColumns = @JoinColumn(name = "EntrepriseId")
    )
    private List<Entreprise> idEntrepriseC;

}
