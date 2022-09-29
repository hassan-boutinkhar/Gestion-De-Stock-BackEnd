package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.CommandeFournisseurMapper;
import com.hassan.gestiondestock.Mapper.LigneCommandeFournisseurMapper;
import com.hassan.gestiondestock.Repository.CommandeFournisseurRepository;
import com.hassan.gestiondestock.Repository.LigneComandeFournisseurRepository;
import com.hassan.gestiondestock.Validators.FournisseurCommandeValidator;
import com.hassan.gestiondestock.dto.commandeFournisseurDto;
import com.hassan.gestiondestock.model.LigneCommandeFournisseurs;
import com.hassan.gestiondestock.model.commandeFournisseurs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class CommandeFournisseurService {

    @Autowired
    private CommandeFournisseurRepository commandeFournisseurRepository;
    @Autowired
    private LigneComandeFournisseurRepository lignecommandefournisseur;
    @Autowired
    private CommandeFournisseurMapper commandefourniseurmapper;
    @Autowired
    private LigneCommandeFournisseurMapper lignecommandefournisseurmapper;

    public commandeFournisseurDto save(commandeFournisseurDto commandefournisseurdto){
        List<String> errors = FournisseurCommandeValidator.validate(commandefournisseurdto);
        if(!errors.isEmpty()){
            System.out.print("COMMANDE FOURNISSEUR IS NOT VALID");
            throw new InvalidEntityExecption("CATEGORIE N'EST PAS VALID", ErrorsCodes.COMMANDE_FOURNISSEUR_NOT_VALID_FOUND,errors);
        }
        commandeFournisseurs objet=commandeFournisseurRepository.save(commandefourniseurmapper.toModel(commandefournisseurdto));
        commandefournisseurdto.getLigneCommandeFournisseursF().forEach(
                data->{
                    LigneCommandeFournisseurs objetLc=lignecommandefournisseurmapper.toModel(data);
                    objetLc.setCommandeFournisseursFid(objet);
                    lignecommandefournisseur.save(objetLc);
                }
        );

        return commandefourniseurmapper.toDto(objet);
    }

    public commandeFournisseurDto findById(Integer id){

        if(id==null){
            System.out.print("COMMANDE FOURNISSEUR ID IS NULL");
            return null;
        }

        return commandefourniseurmapper.toDto(commandeFournisseurRepository.findById(id));
    }

   /* public commandeFournisseurDto findByCodeCommande(String codeCommande){

        if(!StringUtils.hasLength(codeCommande)){
            System.out.print("COMMANDE FOURNISSEUR CODE IS NULL");
            return null;
        }

        return commandefourniseurmapper.toDto(commandeFournisseurRepository.findcommandeFournisseursByCode(codeCommande));
    }*/
    public List<commandeFournisseurDto> findAllData(){
        return commandefourniseurmapper.toDtos(commandeFournisseurRepository.findAll());
    }

    public void deleteById(Integer id){
        if(id==null){
            System.out.print("COMMANDE FOURNISSEUR ID IS NULL");
            return ;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
