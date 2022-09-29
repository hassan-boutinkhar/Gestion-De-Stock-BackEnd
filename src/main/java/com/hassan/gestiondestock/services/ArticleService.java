package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.ArticleMapper;
import com.hassan.gestiondestock.Repository.ArticleRepository;
import com.hassan.gestiondestock.Validators.ArticleValidator;
import com.hassan.gestiondestock.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;

    public ArticleDto save(ArticleDto articleDto){
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
             System.out.print("ARTICLE IS NOT VALID");
            throw new InvalidEntityExecption("ARTICLE N'EST PAS VALID", ErrorsCodes.ARTICLE_NOT_VALID_FOUND,errors);
        }
        return articleMapper.toDto(articleRepository.save(articleMapper.toModel(articleDto)));
    }

    public ArticleDto findById(Long id){

        if(id==null){
            System.out.print("ARTICLE ID IS NULL");
            return null;
        }

        return articleMapper.toDto(articleRepository.findById(id));
    }

    public ArticleDto findByCodeArticle(String codeArticle){

        if(!StringUtils.hasLength(codeArticle)){
            System.out.print("ARTICLE CODE IS NULL");
            return null;
        }

        return articleMapper.toDto(articleRepository.findByCodeArticle(codeArticle));
    }
    public List<ArticleDto> findAllData(){
        return articleMapper.toDtos(articleRepository.findAll());
    }

    public void deleteById(Long id){
        if(id==null){
            System.out.print("ARTICLE ID IS NULL");
            return ;
        }
         articleRepository.deleteById(id);
    }
}
