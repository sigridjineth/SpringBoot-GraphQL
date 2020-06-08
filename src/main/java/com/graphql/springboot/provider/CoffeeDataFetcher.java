package com.graphql.springboot.provider;

import org.springframework.stereotype.Component;

import com.graphql.springboot.entity.coffee.Coffee;
import com.graphql.springboot.repository.CoffeeRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CoffeeDataFetcher implements DataFetcher<Coffee> {
	private final CoffeeRepository coffeeRepository;

	public CoffeeDataFetcher(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}

	@Override
	public Coffee get(DataFetchingEnvironment environment) {
		int id = environment.getArgument("id");
		return coffeeRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
