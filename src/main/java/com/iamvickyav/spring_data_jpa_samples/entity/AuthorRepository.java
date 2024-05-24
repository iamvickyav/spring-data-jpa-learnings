package com.iamvickyav.spring_data_jpa_samples.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {

}
