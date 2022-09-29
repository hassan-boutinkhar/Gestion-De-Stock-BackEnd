package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.dto.clientsDto;
import com.hassan.gestiondestock.model.clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<clients,Integer> {


}
