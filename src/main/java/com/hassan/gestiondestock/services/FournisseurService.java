package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.FournisseurMapper;
import com.hassan.gestiondestock.Repository.FournisseurRepository;
import com.hassan.gestiondestock.Validators.FournisseurValidator;
import com.hassan.gestiondestock.dto.fournisseurDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurrepository;
    @Autowired
    private FournisseurMapper fournisseurmapper;

    public fournisseurDto save(fournisseurDto fournisseurdto){
        List<String> errors = FournisseurValidator.validate(fournisseurdto);
        if(!errors.isEmpty()){
            System.out.print("FOURNISSEUR IS NOT VALID");
            throw new InvalidEntityExecption("FOURNISSEUR N'EST PAS VALID", ErrorsCodes.FOURNISSEUR_NOT_VALID_FOUND,errors);
        }
        return fournisseurmapper.toDto(fournisseurrepository.save(fournisseurmapper.toModel(fournisseurdto)));
    }

    public fournisseurDto findById(Integer id){

        if(id==null){
            System.out.print("FOURNISSEUR ID IS NULL");
            return null;
        }

        return fournisseurmapper.toDto(fournisseurrepository.findById(id));
    }

    public List<fournisseurDto> findAllData(){
        return fournisseurmapper.toDtos(fournisseurrepository.findAll());
    }

    public void deleteById(Integer id){
        if(id==null){
            System.out.print("FOURNISSEUR ID IS NULL");
            return ;
        }
        fournisseurrepository.deleteById(id);
    }

}
