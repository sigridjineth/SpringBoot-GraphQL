package com.graphql.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.graphql.springboot.entity.Order;

@Repository
public class OrderRepository {
	private List<Order> orderList = new ArrayList<>();
}
