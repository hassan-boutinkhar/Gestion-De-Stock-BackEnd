package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.ClientMapper;
import com.hassan.gestiondestock.Repository.ClientRepository;
import com.hassan.gestiondestock.Validators.ClientsValidator;
import com.hassan.gestiondestock.dto.clientsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientService {
    @Autowired
    private ClientRepository clientrepository;
    @Autowired
    private ClientMapper clientMapper;

    public clientsDto save(clientsDto clientdto){
        List<String> errors = ClientsValidator.validate(clientdto);
        if(!errors.isEmpty()){
            System.out.print("CLIENT IS NOT VALID");
            throw new InvalidEntityExecption("CLIENT N'EST PAS VALID", ErrorsCodes.CLIENT_NOT_VALID_FOUND,errors);
        }
        return clientMapper.toDto(clientrepository.save(clientMapper.toModel(clientdto)));
    }

    public clientsDto findById(Integer id){

        if(id==null){
            System.out.print("CLIENT ID IS NULL");
            return null;
        }

        return clientMapper.toDto(clientrepository.findById(id));
    }

    public List<clientsDto> findAllData(){
        return clientMapper.toDtos(clientrepository.findAll());
    }

    public void deleteById(Integer id){
        if(id==null){
            System.out.print("CLIENT ID IS NULL");
            return ;
        }
        clientrepository.deleteById(id);
    }
}
