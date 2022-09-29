package com.hassan.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hassan.gestiondestock.model.MvtDeStocks;
import com.hassan.gestiondestock.model.TypeMvt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class mvtDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto articleId;

    private TypeMvt typeMvt;

}
