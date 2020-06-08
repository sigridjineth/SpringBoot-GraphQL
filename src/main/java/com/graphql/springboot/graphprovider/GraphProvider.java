package com.graphql.springboot.graphprovider;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.graphql.springboot.datafetcher.CoffeeDataFetcher;
import com.graphql.springboot.datafetcher.OrderDataFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class GraphProvider implements GraphUseCase {

	private final CoffeeDataFetcher coffeeDataFetcher;
	private final OrderDataFetcher orderDataFetcher;

	@Value("classpath:cafe.graphqls")
	Resource resource;

	private GraphQL graphQL;

	@Override
	public ExecutionResult execute(String query) {
		return graphQL.execute(query);
	}

	//GraphQL을 요청한 RequestBody에 다음과 같이 실행한다.
	@PostConstruct
	private void loadSchema() throws IOException {
		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
			.type("Query", typeWiring -> typeWiring
				//coffee가 요청되면 coffeeDataFetcher를 실행한다.
			.dataFetcher("coffee", coffeeDataFetcher)
				//order가 요청되면 orderDataFetcher를 실행한다.
			.dataFetcher("order", orderDataFetcher))
			.build();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}
}
