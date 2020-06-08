package com.graphql.springboot.graphprovider;

import graphql.ExecutionResult;

public interface GraphUseCase {
	ExecutionResult execute(String query);
}
