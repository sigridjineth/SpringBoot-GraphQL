package com.graphql.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coffee {

	private Long id;
	private String name;
	private Integer price;
}
