package com.graphql.springboot.repository;

import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.springboot.entity.coffee.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
	@NotNull
	Optional<Coffee> findById(int id);
}
