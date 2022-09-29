package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.UtilisateurMapper;
import com.hassan.gestiondestock.Repository.UtilisateursRepository;
import com.hassan.gestiondestock.Validators.UtilsateurValuidator;
import com.hassan.gestiondestock.dto.utilisateursDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtilisateurService {

    @Autowired
    private UtilisateursRepository utilisateurrepository;
    @Autowired
    private UtilisateurMapper utilisateurmapper;

    public utilisateursDto save(utilisateursDto utilisateurdto){
        List<String> errors = UtilsateurValuidator.validate(utilisateurdto);
        if(!errors.isEmpty()){
            System.out.print("UTILISATEUR IS NOT VALID");
            throw new InvalidEntityExecption("UTILISATEUR N'EST PAS VALID", ErrorsCodes.UTILISATEUR_NOT_VALID_FOUND,errors);
        }
        return utilisateurmapper.toDto(utilisateurrepository.save(utilisateurmapper.toModel(utilisateurdto)));
    }

    public utilisateursDto findById(Integer id){

        if(id==null){
            System.out.print("UTILISATEUR ID IS NULL");
            return null;
        }

        return utilisateurmapper.toDto(utilisateurrepository.findById(id));
    }

    public List<utilisateursDto> findAllData(){
        return utilisateurmapper.toDtos(utilisateurrepository.findAll());
    }

    public void deleteById(Integer id){
        if(id==null){
            System.out.print("UTILISATEUR ID IS NULL");
            return ;
        }
        utilisateurrepository.deleteById(id);
    }

}
