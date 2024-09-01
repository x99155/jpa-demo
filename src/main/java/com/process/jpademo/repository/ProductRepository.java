package com.process.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.process.jpademo.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    // Création d'une méthode personnelle
    public List<Product> findByNameContainsIgnoreCase(String keyword);

    // pour éviter d'avoir à écrire des méthode trop longue
    // on peut utiliser l'annotation Query (voir exemple 2)
    //public List<Product> findByNameContainsIgnoreCaseAndPriceGreaterThan(String keyword, double price);

    // exemple 2: requete HQL
    @Query("select p from Product p where p.name like %:mc% and p.price>:p")
    public List<Product> search(@Param("mc") String keyword, @Param("p") double price);


}
