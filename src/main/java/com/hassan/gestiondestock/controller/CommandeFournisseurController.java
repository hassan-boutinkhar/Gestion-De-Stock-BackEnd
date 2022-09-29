package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.commandeFournisseurDto;
import com.hassan.gestiondestock.dto.commandeFournisseurDto;
import com.hassan.gestiondestock.services.CategoryService;
import com.hassan.gestiondestock.services.CommandeClientService;
import com.hassan.gestiondestock.services.CommandeFournisseurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/commandeFournisseur/")//dire que cest un api
@RestController
@RequestMapping(APP_ROOT+"/commandeFournisseur/")
public class CommandeFournisseurController {
    @Autowired
    private CommandeFournisseurService commandeFournisseurService;

    @PostMapping(value = "addCommandeFournisseur")
    @ApiOperation(value = "Ajouter un commande de fournisseur ou le modifier" , notes = "Cette methode permet de creer un noveau commande de fournisseur ou le modifier",response = commandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })
    public commandeFournisseurDto save(@RequestBody commandeFournisseurDto commandeFournisseurdto){
        return  commandeFournisseurService.save(commandeFournisseurdto);
    }

    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un commandes de fournisseur par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = commandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'commandes de fournisseur a été trouvé"),
            @ApiResponse(code = 404, message = "L'commandes de fournisseur n'a été pas trouvé")
    })
    public commandeFournisseurDto findById(@PathVariable("id") Integer id){

        return commandeFournisseurService.findById(id);
    }

    /*@GetMapping(value = "codeCommande/{codeCommande}")
    public commandeFournisseurDto findByCodeArticle(@PathVariable("codeCommande") String codeCommande){

        return commandeFournisseurService.findByCodeCommande(codeCommande);
    }*/
    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les commandes de fournisseurs " , notes = "Cette methode permet de retourner la liste de tout les commandes de fournisseurs",responseContainer = "List<commandeFournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<commandeFournisseurDto> findAllData(){
        return commandeFournisseurService.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Supprimer un commandes de fournisseur par son ID" , notes = "Cette methode permet de supprimer un commandes de fournisseur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'commandes de fournisseur a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Integer id){
        commandeFournisseurService.deleteById(id);
    }
}
