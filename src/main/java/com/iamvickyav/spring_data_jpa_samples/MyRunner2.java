package com.iamvickyav.spring_data_jpa_samples;

import com.iamvickyav.spring_data_jpa_samples.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class MyRunner2 implements CommandLineRunner {

    @Autowired
    BookReviewRepository bookReviewRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("my runner 2");

        BookReview bookReview = new BookReview();
        bookReview.setReview("He is a legend");
        bookReview.setBook(bookRepository.getReferenceById("1"));

        bookReviewRepository.save(bookReview);
    }
}
