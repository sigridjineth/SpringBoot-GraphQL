package com.graphql.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.springboot.graphprovider.GraphUseCase;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/graphql")
public class GraphController {

	private final GraphUseCase graphUseCase;

	@PostMapping
	public ResponseEntity<Object> graphByQuery(@RequestBody String query) {
		ExecutionResult execute = graphUseCase.execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
