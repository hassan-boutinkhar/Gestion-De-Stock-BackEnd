package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.model.Article;
import com.hassan.gestiondestock.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer>  {
}
