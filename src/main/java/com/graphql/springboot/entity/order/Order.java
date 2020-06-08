package com.graphql.springboot.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

	private String orderId;
	private String description;
}
