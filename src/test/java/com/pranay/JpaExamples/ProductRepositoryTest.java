package com.pranay.JpaExamples;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatReflectiveOperationException;

import com.pranay.JpaExamples.entity.Product;
import com.pranay.JpaExamples.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


// Creating JUNIT Test To Execute Code

// Allows to load full spring boot application context 
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    void addProduct()
    {
        // Create Product
        Product product = new Product();
        product.setName("Britania Biscuits");
        product.setActive(true);
        product.setDescription("Not Good For Health");
        product.setPrice(new BigDecimal("1.99"));
        product.setImageUrl("https://rukminim2.flixcart.com/image/850/1000/k2jbyq80pkrrdj/mobile-refurbished/u/z/t/iphone-11-256-c-mwmd2hn-a-apple-0-original-imafkg24wszdhzy3.jpeg?q=90&crop=false");
        product.setSku("DB-MART-13");

        // Save Product
        Product productSaved = repository.save(product);

        // Display Product
        System.out.println(productSaved);
    }



    @Test
    void updateProduct()
    {

        ///  Create The Product
        Product product = new Product();
        product.setName("Apple Iphone");
        product.setActive(true);
        product.setDescription("Dreamy Iphone 11");
        product.setPrice(new BigDecimal("999.99"));
        product.setImageUrl("https://rukminim2.flixcart.com/image/850/1000/k2jbyq80pkrrdj/mobile-refurbished/u/z/t/iphone-11-256-c-mwmd2hn-a-apple-0-original-imafkg24wszdhzy3.jpeg?q=90&crop=false");
        product.setSku("nagpur-1");
        Product productSaved = repository.save(product);
        System.out.println(productSaved);

        ///  Retrieve The Product
        Product findProduct = repository.findById(productSaved.getId()).get();

        ///  Update The Product
        findProduct.setName("Apple 12 Pro");

        ///  Save The Updated Product
        productSaved =  repository.save(findProduct);

        ///  save method internally calls the merge() from EntityManager.
        ///  Print The Updated Product
        System.out.println(productSaved);

    }


    @Test
    void findProductById()
    {
        Long id = 9531L;
        Product product = repository.findById(id).get();

        System.out.println( "Product Found -> " + product);
    }


    @Test
    void addAllProducts()
    {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Apple iPhone 11");
        product1.setActive(true);
        product1.setDescription("Dreamy iPhone 11");
        product1.setPrice(new BigDecimal("999.99"));
        product1.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-11-select-2019-family");
        product1.setSku("nagpur-1");

        Product product2 = new Product();
        product2.setName("Samsung Galaxy S21");
        product2.setActive(true);
        product2.setDescription("High-performance smartphone");
        product2.setPrice(new BigDecimal("799.99"));
        product2.setImageUrl("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s21/");
        product2.setSku("mumbai-2");

        Product product3 = new Product();
        product3.setName("OnePlus 9 Pro");
        product3.setActive(true);
        product3.setDescription("Flagship killer");
        product3.setPrice(new BigDecimal("969.99"));
        product3.setImageUrl("https://image01.oneplus.net/ebp/202103/26/1-m00-09-38-rb8bwlguyjgaajn4aafpygy8y_o253.png");
        product3.setSku("delhi-3");

        Product product4 = new Product();
        product4.setName("Google Pixel 6");
        product4.setActive(true);
        product4.setDescription("Smartphone with the ultimate Google experience");
        product4.setPrice(new BigDecimal("699.99"));
        product4.setImageUrl("https://store.google.com/us/product/images/pixel_6");
        product4.setSku("chennai-4");

        // Add products to the list
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        // Adding To Database
        List<Product> allSavedProducts =  repository.saveAll(products);

        // Printing All Products
        System.out.println(allSavedProducts);
    }

    @Test
    void findAllProducts()
    {
        // Reading All Products From Database
        List<Product> allProducts = repository.findAll();

        System.out.println("All Products : " +allProducts);
    }

    @Test
    void deleteProductById()
    {
        // Create Product
        Product product = new Product();
        product.setName("Apple Iphone");
        product.setActive(true);
        product.setDescription("Dreamy Iphone 11");
        product.setPrice(new BigDecimal("999.99"));
        product.setImageUrl("https://rukminim2.flixcart.com/image/850/1000/k2jbyq80pkrrdj/mobile-refurbished/u/z/t/iphone-11-256-c-mwmd2hn-a-apple-0-original-imafkg24wszdhzy3.jpeg?q=90&crop=false");
        product.setSku("nagpur-1");

        // Save Product
        Product productSaved =  repository.save(product);

        // Delete Product
        repository.deleteById(productSaved.getId());
    }


    @Test
    void deleteProduct()
    {
        ///  Find Entity By id
        Long id = 9581L;
        Product product = repository.findById(id).orElseThrow(()->new RuntimeException("Entity Not Found"));
        ///  delete(entity)
        repository.delete(product);
    }

    @Test
    void deleteAllProducts()
    {
        repository.deleteAll();
    }

    @Test
    void deleteAllProductsWithIterator()
    {
        List<Product> list = repository.findAll();
        repository.deleteAll(list);
    }

    @Test
    void countProducts()
    {
        Long count = repository.count();
        System.out.println("Count -> " + count);
    }

    @Test
    void productExistsById()
    {
        Long id = 9843L;
        Boolean isPresent = repository.existsById(id);

        if(isPresent)
        {
            System.out.println("Entity Exists With Id : " + id);
        }
        else {
            System.out.println("Entity Does Not Exists With Id : " + id);
        }
    }

}
