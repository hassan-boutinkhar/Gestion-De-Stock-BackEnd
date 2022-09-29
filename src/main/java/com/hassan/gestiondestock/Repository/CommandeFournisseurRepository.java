package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.model.commandeFournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<commandeFournisseurs, Integer> {
    //Optional<commandeFournisseurs> findcommandeFournisseursByCode(String codeCommande);
}
