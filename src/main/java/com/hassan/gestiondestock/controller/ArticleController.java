package com.hassan.gestiondestock.controller;

import com.hassan.gestiondestock.dto.ArticleDto;
import com.hassan.gestiondestock.services.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hassan.gestiondestock.Utils.Contstants.APP_ROOT;

@Api(APP_ROOT+"/article/")//dire que cest un api
@RestController//GENRER SWAGGER.JSON http://localhost:8080/v2/api-docs
@RequestMapping(APP_ROOT+"/article/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "addArticle")
    @ApiOperation(value = "Ajouter un article ou le modifier" , notes = "Cette methode permet de creer un noveau article ou le modifier",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ajouter ou modifier avec succes")
    })

    public ArticleDto save(@RequestBody ArticleDto articleDto){
          return  articleService.save(articleDto);
    }

    @GetMapping(value ="id/{id}" )
    @ApiOperation(value = "Rechercher un article par son ID" , notes = "Cette methode permet de rechercher un methode par son ID",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a été trouvé"),
            @ApiResponse(code = 404, message = "L'article n'a été pas trouvé")
    })
    public ArticleDto findById(@PathVariable("id") Long id){

        return articleService.findById(id);
    }

    @GetMapping(value = "codeArticle/{codeArticle}")
    @ApiOperation(value = "Rechercher un article par son code" , notes = "Cette methode permet de rechercher un methode par son code",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a été trouvé"),
            @ApiResponse(code = 404, message = "L'article n'a été pas trouvé")
    })
    public ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle){

        return articleService.findByCodeArticle(codeArticle);
    }
    @GetMapping(value = "all")
    @ApiOperation(value = "Retourner la liste de tout les articles " , notes = "Cette methode permet de retourner la liste de tout les articles",responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation avec succes ou liste vide"),
    })
    public List<ArticleDto> findAllData(){
        return articleService.findAllData();
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Supprimer un article par son ID" , notes = "Cette methode permet de supprimer un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a été supprimer avec succs"),
    })
    public void deleteById(@PathVariable Long id){
        articleService.deleteById(id);
    }
}
