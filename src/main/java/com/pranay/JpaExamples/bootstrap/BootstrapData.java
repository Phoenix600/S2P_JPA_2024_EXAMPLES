package com.pranay.JpaExamples.bootstrap;


import com.pranay.JpaExamples.entity.Product;
import com.pranay.JpaExamples.entity.Student;
import com.pranay.JpaExamples.repository.ProductRepository;
import com.pranay.JpaExamples.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

//
//        productRepository.deleteAll();
//        studentRepository.deleteAll();
//
//        Student student = Student.builder()
//                .firstName("Pranay")
//                .middleName("Ashok")
//                .lastName("Ramteke")
//                .instituteName("S.B Jain Institute Of Technology, Management And Research")
//                .phoneNumber("7378736963")
//                .email("pranayramteke@613gmail.com")
//                .courseName("ETC")
//                .build();
//
//        studentRepository.save(student);
//
//        Product product = new Product();
//        product.setName("Durex");
//        product.setActive(true);
//        product.setDescription("Long Lasting Extra Delay");
//        product.setPrice(new BigDecimal("3.99"));
//        product.setImageUrl("https://www.bigbasket.com/media/uploads/p/xxl/40241646_8-durex-intense-stimulating-condoms-with-desirex-gel-extra-dotted-ribbed.jpg");
//        product.setSku("nagpur");
//        productRepository.save(product);

    }
}
