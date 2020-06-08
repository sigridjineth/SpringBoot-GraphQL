package com.graphql.springboot.provider;

import java.util.List;

import org.springframework.stereotype.Component;

import com.graphql.springboot.entity.coffee.Coffee;
import com.graphql.springboot.repository.CoffeeRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllCoffeesOrderByDataFetcher implements DataFetcher<List<Coffee>> {

	private final CoffeeRepository coffeeRepository;

	public AllCoffeesOrderByDataFetcher(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}

	@Override
	public List<Coffee> get(DataFetchingEnvironment environment) {
		return coffeeRepository.findAll();
	}
}
