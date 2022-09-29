package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article  findByCodeArticle(String codeArticle);
/*    @Query(value = "select * from Article where codeArticle =: code", nativeQuery = true)
    List<Article> findArticlesByCode(@Param("code") String c); // si le code qui se trouve dans la requete est le meme dans la methode alors nous ne sommes oubliges de mettre @Parm..*/
}
