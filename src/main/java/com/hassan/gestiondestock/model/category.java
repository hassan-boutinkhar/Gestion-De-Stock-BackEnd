package com.hassan.gestiondestock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
public class category extends AbsractEntity{

    @Column(name = "code")
    private String  codeCtegory;

    @Column(name = "designation")
    private String  designation;

    @OneToMany(mappedBy = "categoryId")
    private List<Article> articles;

}
