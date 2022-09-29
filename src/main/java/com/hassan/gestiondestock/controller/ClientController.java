package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.clientsDto;
import com.hassan.gestiondestock.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/client/")//dire que cest un api
@RestController
@RequestMapping(APP_ROOT+"/client/")
public class ClientController {
    @Autowired
    private ClientService clientservice;

    @PostMapping(value = "addClient")
    @ApiOperation(value = "Ajouter un client ou le modifier" , notes = "Cette methode permet de creer un noveau client ou le modifier",response = clientsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })
    public clientsDto save(@RequestBody clientsDto articleDto){
        return  clientservice.save(articleDto);
    }

    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un client par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = clientsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'client a été trouvé"),
            @ApiResponse(code = 404, message = "L'client n'a été pas trouvé")
    })
    public clientsDto findById(@PathVariable("id") Integer id){

        return clientservice.findById(id);
    }

    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les clients " , notes = "Cette methode permet de retourner la liste de tout les clients",responseContainer = "List<clientsDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<clientsDto> findAllData(){
        return clientservice.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Supprimer un client par son ID" , notes = "Cette methode permet de supprimer un client par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'client a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Integer id){
        clientservice.deleteById(id);
    }
}
