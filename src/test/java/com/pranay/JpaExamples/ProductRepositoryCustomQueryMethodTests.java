package com.pranay.JpaExamples;


import com.pranay.JpaExamples.entity.Product;
import com.pranay.JpaExamples.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ProductRepositoryCustomQueryMethodTests {



    @Autowired
    ProductRepository repository;


    ///  Selecting Entity From Single Field
    @Test
    void FindProductsByName()
    {
        Product product =  repository.findByName("Britania Biscuits");
        System.out.println("Product Found : " + product);
    }

    @Test
    void FindByIdCustomMethod()
    {
        Long id = 8084L;
        Product product = repository.findById(id).get();
        System.out.println("product with id " + id + "  " + product);
    }


    ///  Selecting Entity From Multiple Fields
    @Test
    void FindByNameAndDescription()
    {
        List<Product> products = repository.findByNameAndDescription("Britania Biscuits","Not Good For Health");
        System.out.println(products);
    }

    @Test
    void FindByNameOrDescription()
    {
        List<Product> products = repository.findByNameOrDescription("Britania Biscuits","Dreamy iPhone 11");
        System.out.println(products);
    }

    @Test
    void FindDistinctByName()
    {
        Product product = repository.findDistinctByName("Samsung Galaxy S21");
        System.out.println(product);
    }

    @Test
    void FindByPriceGreaterThan()
    {
        List<Product> products = repository.findByPriceGreaterThan(new BigDecimal("100"));
        System.out.println("All Products : " + repository.count());
        products.forEach(System.out::println);
    }

    @Test
    void FindByPriceLessThan()
    {
        List<Product> products = repository.findByPriceLessThan(new BigDecimal("100"));
        System.out.println("All Products : " + repository.count());
        products.forEach(System.out::println);
    }

    @Test
    void FindByNameContaining()
    {
        List<Product> products = repository.findByNameContaining("a");
        products.forEach(System.out::println);
    }

    @Test
    void FindByNameLike()
    {
        List<Product> list = repository.findByNameLike("%ap%");
        list.forEach(System.out::println);
    }

    @Test
    void FindProductsByPriceBetween()
    {
       List<Product> list = repository.findByPriceBetween(new BigDecimal("100"),new BigDecimal("1000"));
       list.forEach(System.out::println);
    }

    @Test
    void FindProductsByDateCreatedBetween()
    {
        List<Product> list = repository.findByDateCreatedBetween(LocalDateTime.of(2024,12,3,23,40,13),LocalDateTime.of(2024,12,5,23,40,13));
        list.forEach(System.out::println);
    }

    @Test
    void FindByProductNameIn()
    {
        List<Product> list = repository.findByNameIn(List.of("Britania Biscuits","Samsung Galaxy S21"));
        list.forEach(System.out::println);
    }

    @Test
    void FindFirst2ByOrderByName()
    {
        var products = repository.findFirst2ByOrderByNameAsc();
        products.forEach(System.out::println);
    }

    @Test
    void FindTop3ByOrderByPriceDesc()
    {
        var products = repository.findTop3ByOrderByPriceDesc();
        products.forEach(System.out::println);
    }
}
