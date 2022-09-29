package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.utilisateursDto;
import com.hassan.gestiondestock.services.UtilisateurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/utilisateur/")//dire que cest un api
@RestController
@RequestMapping(APP_ROOT+"/utilisateur/")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurservice;

    @PostMapping(value = "addUtilisateur")
    @ApiOperation(value = "Ajouter un utilisateur ou le modifier" , notes = "Cette methode permet de creer un noveau utilisateur ou le modifier",response = utilisateursDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })
    public utilisateursDto save(@RequestBody utilisateursDto utilisateurdto){
        return  utilisateurservice.save(utilisateurdto);
    }

    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un utilisateur par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = utilisateursDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'utilisateur a été trouvé"),
            @ApiResponse(code = 404, message = "L'utilisateur n'a été pas trouvé")
    })
    public utilisateursDto findById(@PathVariable("id") Integer id){

        return utilisateurservice.findById(id);
    }

    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les utilisateurs " , notes = "Cette methode permet de retourner la liste de tout les utilisateurs",responseContainer = "List<utilisateursDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<utilisateursDto> findAllData(){
        return utilisateurservice.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Supprimer un utilisateur par son ID" , notes = "Cette methode permet de supprimer un utilisateur par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'utilisateur a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Integer id){
        utilisateurservice.deleteById(id);
    }
}
