package com.iamvickyav.spring_data_jpa_samples.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, String> {
}
