package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.CategoryDTO;
import com.hassan.gestiondestock.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/category/")//dire que cest un api
@RestController
@RequestMapping(APP_ROOT+"/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "addCategory")
    @ApiOperation(value = "Ajouter un categorie ou le modifier" , notes = "Cette methode permet de creer un noveau categorie ou le modifier",response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })
    public CategoryDTO save(@RequestBody CategoryDTO categorydto){
        return  categoryService.save(categorydto);
    }

    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un categorie par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'categorie a été trouvé"),
            @ApiResponse(code = 404, message = "L'categorie n'a été pas trouvé")
    })
    public CategoryDTO findById(@PathVariable("id") Integer id){

        return categoryService.findById(id);
    }

    @GetMapping(value = "codeCategory/{codeCategory}")
    @ApiOperation(value = "Rechercher un categorie par son code" , notes = "Cette methode permet de rechercher un methode par son code",response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'categorie a été trouvé"),
            @ApiResponse(code = 404, message = "L'categorie n'a été pas trouvé")
    })
    public CategoryDTO findByCodeArticle(@PathVariable("codeCategory") String codeCategory){

        return categoryService.findByCodeCategory(codeCategory);
    }
    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les categories " , notes = "Cette methode permet de retourner la liste de tout les categories",responseContainer = "List<CategoryDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<CategoryDTO> findAllData(){
        return categoryService.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Supprimer un categorie par son ID" , notes = "Cette methode permet de supprimer un categorie par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'categorie a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}
