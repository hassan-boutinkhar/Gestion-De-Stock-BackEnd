package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article extends AbsractEntity{

    @Column(name = "codeArticle")
    private String  codeArticle;

    @Column(name = "designation")
    private String  designation;

    @Column(name = "prixUnitaireHt")
    private BigDecimal prixUnitaireHt;

    @Column(name = "prixUnitaireTtc")
    private BigDecimal  prixUnitaireTtc;

    @Column(name = "touxTva")
    private BigDecimal  touxTva;

    @Column(name = "photo")
    private String  photo;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private category categoryId;

    @OneToMany(mappedBy = "articleId")
    private List<MvtDeStocks> mvtDeStocks;

    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise idEntreprise;

    @OneToMany(mappedBy = "articleIdlv")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "articleIdCF")
    private List<LigneCommandeFournisseurs> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "articleIdCC")
    private List<ligneCommandeClients> ligneCommandeClientsList;



}
