package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.model.Article;
import com.hassan.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer>  {
}
