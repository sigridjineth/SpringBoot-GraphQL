package com.graphql.springboot.entity.coffee;

import graphql.ExecutionResult;

public interface CoffeeDetails {
	ExecutionResult execute(String query);
}
