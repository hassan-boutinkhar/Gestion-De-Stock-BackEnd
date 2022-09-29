package com.hassan.gestiondestock.services;

import com.hassan.gestiondestock.Exeptions.ErrorsCodes;
import com.hassan.gestiondestock.Exeptions.InvalidEntityExecption;
import com.hassan.gestiondestock.Mapper.CategoryMapper;
import com.hassan.gestiondestock.Repository.CategoryRepository;
import com.hassan.gestiondestock.Validators.CategoryValidator;
import com.hassan.gestiondestock.dto.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDTO save(CategoryDTO categorydto){
        List<String> errors = CategoryValidator.validate(categorydto);
        if(!errors.isEmpty()){
            System.out.print("CATEGORY IS NOT VALID");
            throw new InvalidEntityExecption("CATEGORIE N'EST PAS VALID", ErrorsCodes.CATEGORY_NOT_VALID_FOUND,errors);
        }
        return categoryMapper.toDto(categoryRepo.save(categoryMapper.toModel(categorydto)));
    }

    public CategoryDTO findById(Integer id){

        if(id==null){
            System.out.print("CATEGORY ID IS NULL");
            return null;
        }

        return categoryMapper.toDto(categoryRepo.findById(id));
    }

    public CategoryDTO findByCodeCategory(String codeCategory){

        if(!StringUtils.hasLength(codeCategory)){
            System.out.print("CATEGORY CODE IS NULL");
            return null;
        }

        return categoryMapper.toDto(categoryRepo.findByCodeCtegory(codeCategory));
    }
    public List<CategoryDTO> findAllData(){
        return categoryMapper.toDtos(categoryRepo.findAll());
    }

    public void deleteById(Integer id){
        if(id==null){
            System.out.print("CATEGORY ID IS NULL");
            return ;
        }
        categoryRepo.deleteById(id);
    }
}
