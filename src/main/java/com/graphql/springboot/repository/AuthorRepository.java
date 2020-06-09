package com.graphql.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.springboot.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
