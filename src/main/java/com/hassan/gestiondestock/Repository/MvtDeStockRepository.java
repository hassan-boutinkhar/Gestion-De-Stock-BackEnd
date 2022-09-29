package com.hassan.gestiondestock.Repository;

import com.hassan.gestiondestock.model.Article;
import com.hassan.gestiondestock.model.MvtDeStocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtDeStockRepository extends JpaRepository<MvtDeStocks, Integer>  {
}
