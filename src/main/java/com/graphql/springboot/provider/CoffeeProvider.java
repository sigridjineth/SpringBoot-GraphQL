package com.graphql.springboot.provider;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.graphql.springboot.entity.coffee.Coffee;
import com.graphql.springboot.entity.coffee.CoffeeDetails;
import com.graphql.springboot.repository.CoffeeRepository;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class CoffeeProvider implements CoffeeDetails {

	private final CoffeeRepository coffeeRepository;

	private final AllCoffeesOrderByDataFetcher allCoffeesDataFetcher;

	private final AllCoffeesOrderByDataFetcher allCoffeesOrderByDataFetcher;

	private final CoffeeDataFetcher coffeeDataFetcher;

	@Value("classpath:coffees.graphqls")
	Resource resource;

	private GraphQL graphQL;

	public CoffeeProvider(CoffeeRepository coffeeRepository,
		AllCoffeesOrderByDataFetcher allCoffeesDataFetcher,
		AllCoffeesOrderByDataFetcher allCoffeesOrderByDataFetcher,
		CoffeeDataFetcher coffeeDataFetcher) {
		this.coffeeRepository = coffeeRepository;
		this.allCoffeesDataFetcher = allCoffeesDataFetcher;
		this.allCoffeesOrderByDataFetcher = allCoffeesOrderByDataFetcher;
		this.coffeeDataFetcher = coffeeDataFetcher;
	}

	@PostConstruct
	private void loadSchema() throws IOException {

		loadDataIntoHSQL(); // 데이터 초기화

		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
			.type("Query", typeWiring -> typeWiring
				.dataFetcher("allCoffees", allCoffeesDataFetcher)
				.dataFetcher("allCoffeesOrderBy", allCoffeesOrderByDataFetcher)
				.dataFetcher("coffee", coffeeDataFetcher))
			.build();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private void loadDataIntoHSQL() {

		Stream.of(
			new Coffee(1, "latte", 1000),
			new Coffee(2, "mocha", 2000),
			new Coffee(3, "americano", 900)
		).forEach(coffeeRepository::save);
	}

	@Override
	public ExecutionResult execute(String query) {
		return graphQL.execute(query);
	}
}