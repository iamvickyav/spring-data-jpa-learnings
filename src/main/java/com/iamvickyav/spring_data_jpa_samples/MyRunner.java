package com.iamvickyav.spring_data_jpa_samples;

import com.iamvickyav.spring_data_jpa_samples.entity.*;
import jakarta.transaction.Transactional;
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
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("my runner 1");
        Author a = new Author();
        a.setAuthorName("Bharathiyar");
        a.setCountry("INDIA");

        Book book = new Book();
        book.setIsbn("isbn1");
        book.setBookName("Bharathiyar Kavithaigal");
        book.setId("1");
        book.setAuthor(a);

        a.addBook(book);
        authorRepository.save(a);
    }
}
