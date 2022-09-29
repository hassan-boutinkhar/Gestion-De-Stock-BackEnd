package com.hassan.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Integer id;

    private String  codeArticle;

    private String  designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal  prixUnitaireTtc;

    private BigDecimal  touxTva;

    private String  photo;


    private CategoryDTO categoryId;

    @JsonIgnore
    private List<mvtDto> mvtDeStocks;

    private EntrepriseDto idEntreprise;

    @JsonIgnore
    private List<LigneVenteDto> ligneVentes;

    @JsonIgnore
    private List<ligneCommandeFournisseurDto> ligneCommandeFournisseurs;

    @JsonIgnore
    private List<ligneCommandeClientsDto> ligneCommandeClientsList;


}
