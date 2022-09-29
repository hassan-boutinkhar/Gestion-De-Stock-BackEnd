package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.fournisseurDto;
import com.hassan.gestiondestock.services.FournisseurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/fournisseur/")//dire que cest un api
@RestController
@RequestMapping(APP_ROOT+"/fournisseur/")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurservice;

    @PostMapping(value = "addFournisseur")
    @ApiOperation(value = "Ajouter un fournisseur ou le modifier" , notes = "Cette methode permet de creer un noveau fournisseur ou le modifier",response = fournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })
    public fournisseurDto save(@RequestBody fournisseurDto fournisseurdto){
        return  fournisseurservice.save(fournisseurdto);
    }
    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un fournisseur par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = fournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'fournisseur a été trouvé"),
            @ApiResponse(code = 404, message = "L'fournisseur n'a été pas trouvé")
    })
    public fournisseurDto findById(@PathVariable("id") Integer id){

        return fournisseurservice.findById(id);
    }

    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les fournisseurs " , notes = "Cette methode permet de retourner la liste de tout les fournisseurs",responseContainer = "List<fournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<fournisseurDto> findAllData(){
        return fournisseurservice.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")// SI JE VEUX SUPPRIMER UN FOURNISSEUR JE DOIT SUPPRIMER SES COMMZNDES AUTOMATIQUEMENT SI LES LIGNES DE COMMANDES
    @ApiOperation(value = "Supprimer un fournisseur par son ID" , notes = "Cette methode permet de supprimer un fournisseur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'fournisseur a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Integer id){
        fournisseurservice.deleteById(id);
    }
}
