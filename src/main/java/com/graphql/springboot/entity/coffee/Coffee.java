package com.graphql.springboot.entity.coffee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Coffee {

	@Id
	private Integer id;
	private String name;
	private Integer price;

	public Coffee() {
	}

	public Coffee(Integer id, String name, Integer price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
