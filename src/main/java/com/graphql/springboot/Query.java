package com.graphql.springboot;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.springboot.entity.Coffee;
import com.graphql.springboot.entity.Order;
import com.graphql.springboot.repository.CoffeeRepository;
import com.graphql.springboot.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

//GraphQLQueryResolver를 구현하는 클래스의 메소드는 스키마에 정의한 Type Query와 매핑된다.
//step1 브랜치와 달리 step2 구현체의 경우에는 별도의 매핑 작업 없이 GraphQLQueryResolver를 구현하면 자동으로 매핑이 된다.
@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
	private final CoffeeRepository coffeeRepository;
	private final OrderRepository orderRepository;

	public Coffee coffee(String name) {
		return coffeeRepository.findByName(name);
	}

	public Order order(String orderId) {
		return null;
	}
}
