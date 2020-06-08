package com.graphql.springboot.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.graphql.springboot.entity.Coffee;

@Repository
public class CoffeeRepository {
	private Map<String, Coffee> coffeeMap = new ConcurrentHashMap<>();

	@PostConstruct
	private void loadSchema() {
		coffeeMap.put("mocha", new Coffee(1L, "mocha", 1200));
		coffeeMap.put("latte", new Coffee(2L, "latte", 1100));
		coffeeMap.put("americano", new Coffee(3L, "americano", 900));
	}

	public Coffee findByName(String name) {
		return coffeeMap.get(name);
	}
}
