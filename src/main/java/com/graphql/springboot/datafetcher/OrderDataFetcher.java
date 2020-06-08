package com.graphql.springboot.datafetcher;

import org.springframework.stereotype.Component;

import com.graphql.springboot.entity.Order;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class OrderDataFetcher implements DataFetcher<Order> {

	@Override
	public Order get(DataFetchingEnvironment environment) {
		return null;
	}
}
