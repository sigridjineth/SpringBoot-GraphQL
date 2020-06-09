package com.graphql.springboot.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.springboot.domain.Author;
import com.graphql.springboot.dto.PostResponse;
import com.graphql.springboot.repository.AuthorRepository;

@Component
public class PostResolver implements GraphQLResolver<PostResponse> {
	private final AuthorRepository authorRepository;

	public PostResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(PostResponse postResponse) {
		return authorRepository.findById(postResponse.getAuthor().getId()).orElseThrow(NullPointerException::new);
	}
}