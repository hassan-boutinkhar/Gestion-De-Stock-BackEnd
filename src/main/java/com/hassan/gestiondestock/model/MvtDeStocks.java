package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MvtDeStocks")
public class MvtDeStocks extends AbsractEntity{

    @Column(name = "dateMvt")
    private Instant dateMvt;

    @Column(name = "quantite")
    private BigDecimal quantite;


    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article articleId;

    @Column(name = "typeMvt")
    private TypeMvt typeMvt;
}
