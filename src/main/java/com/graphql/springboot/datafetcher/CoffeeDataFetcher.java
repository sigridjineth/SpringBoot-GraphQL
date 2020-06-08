package com.graphql.springboot.datafetcher;

import org.springframework.stereotype.Component;

import com.graphql.springboot.entity.Coffee;
import com.graphql.springboot.repository.CoffeeRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CoffeeDataFetcher implements DataFetcher<Coffee> {
	private final CoffeeRepository coffeeRepository;

	@Override
	public Coffee get(DataFetchingEnvironment environment) {
		String name = environment.getArgument("name");
		return coffeeRepository.findByName(name);
	}
}
