package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.model.Article;
import com.hassan.gestiondestock.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<category, Integer>  {
    category findByCodeCtegory(String codeCategory);


}
