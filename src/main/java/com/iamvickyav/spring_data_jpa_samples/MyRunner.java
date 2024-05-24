package com.iamvickyav.spring_data_jpa_samples;

import com.iamvickyav.spring_data_jpa_samples.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class MyRunner implements CommandLineRunner {

    @Autowired
    BookReviewRepository bookReviewRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("my runner 1");
        Author a = new Author();
        a.setName("Bharathiyar");
        a.setCountry("INDIA");
        authorRepository.save(a);

        Book book = new Book();
        book.setIsbn("isbn1");
        book.setName("Bharathiyar Kavithaigal");
        book.setId("1");
        book.setAuthor(a);

        bookRepository.save(book);
    }
}
