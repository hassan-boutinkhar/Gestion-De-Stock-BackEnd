package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.CommandeClientsMapper;
import com.hassan.gestiondestock.Mapper.LigneCommandeClientsMapper;
import com.hassan.gestiondestock.Repository.CommandeClientRepository;
import com.hassan.gestiondestock.Repository.LigneCommandeClientRepository;
import com.hassan.gestiondestock.Validators.CommandeClientsValidtor;
import com.hassan.gestiondestock.dto.CommandeClientsDto;
import com.hassan.gestiondestock.model.CommandeClient;
import com.hassan.gestiondestock.model.ligneCommandeClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class CommandeClientService {
    @Autowired
    private CommandeClientRepository commandeClientservice;
    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    @Autowired
    private CommandeClientsMapper commandeclientmapper;
    @Autowired
    private LigneCommandeClientsMapper ligneCommandeClientsMapper;

    public CommandeClientsDto save(CommandeClientsDto commandeclientdto){
        List<String> errors = CommandeClientsValidtor.validate(commandeclientdto);
        if(!errors.isEmpty()){
            System.out.print("COMMANDE CLIENT IS NOT VALID");
            throw new InvalidEntityExecption("CATEGORIE N'EST PAS VALID", ErrorsCodes.COMMANDE_CLIENT_NOT_VALID_FOUND,errors);
        }
        CommandeClient objet=commandeClientservice.save(commandeclientmapper.toModel(commandeclientdto));
        commandeclientdto.getLigneCommandeClients().forEach(
                data->{
                    ligneCommandeClients objetLc=ligneCommandeClientsMapper.toModel(data);
                    objetLc.setCommandeClientsId(objet);
                    ligneCommandeClientRepository.save(objetLc);
                }
        );

        return commandeclientmapper.toDto(objet);
    }

    public CommandeClientsDto findById(Integer id){

        if(id==null){
            System.out.print("COMMANDE CLIENT ID IS NULL");
            return null;
        }

        return commandeclientmapper.toDto(commandeClientservice.findById(id));
    }

    public CommandeClientsDto findByCodeCommande(String codeCommande){

        if(!StringUtils.hasLength(codeCommande)){
            System.out.print("COMMANDE CLIENT CODE IS NULL");
            return null;
        }

        return commandeclientmapper.toDto(commandeClientservice.findCommandeClientByCode(codeCommande));
    }
    public List<CommandeClientsDto> findAllData(){
        return commandeclientmapper.toDtos(commandeClientservice.findAll());
    }

    public void deleteById(Integer id){
        if(id==null){
            System.out.print("COMMANDE CLIENT ID IS NULL");
            return ;
        }
        commandeClientservice.deleteById(id);
    }
}
