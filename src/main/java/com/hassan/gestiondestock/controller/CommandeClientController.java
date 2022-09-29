package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.CommandeClientsDto;
import com.hassan.gestiondestock.services.CommandeClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/commandeClient/")//dire que cest un api
@RestController
@RequestMapping(APP_ROOT+"/commandeClient/")
public class CommandeClientController {
    @Autowired
    private CommandeClientService commandeClientsService;

    @PostMapping(value = "addCommandeClient")
    @ApiOperation(value = "Ajouter un commande client ou le modifier" , notes = "Cette methode permet de creer un noveau commande client ou le modifier",response = CommandeClientsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })
    public CommandeClientsDto save(@RequestBody CommandeClientsDto commandeclientdto){
        return  commandeClientsService.save(commandeclientdto);
    }

    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un commandes de client par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = CommandeClientsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'commandes de client a été trouvé"),
            @ApiResponse(code = 404, message = "L'commandes de client n'a été pas trouvé")
    })
    public CommandeClientsDto findById(@PathVariable("id") Integer id){

        return commandeClientsService.findById(id);
    }

    @GetMapping(value = "codeCommande/{codeCommande}")
    @ApiOperation(value = "Rechercher un commandes de client par son code" , notes = "Cette methode permet de rechercher un methode par son code",response = CommandeClientsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'commandes de client a été trouvé"),
            @ApiResponse(code = 404, message = "L'commandes de client n'a été pas trouvé")
    })
    public CommandeClientsDto findByCodeArticle(@PathVariable("codeCommande") String codeCommande){

        return commandeClientsService.findByCodeCommande(codeCommande);
    }
    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les commandes de clients " , notes = "Cette methode permet de retourner la liste de tout les commandes de clients",responseContainer = "List<CommandeClientsDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<CommandeClientsDto> findAllData(){
        return commandeClientsService.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Supprimer un commandes de client par son ID" , notes = "Cette methode permet de supprimer un commandes de client par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'commandes de client a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Integer id){
        commandeClientsService.deleteById(id);
    }
}
