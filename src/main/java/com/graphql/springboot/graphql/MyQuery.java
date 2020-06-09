package com.graphql.springboot.graphql;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.springboot.domain.Post;
import com.graphql.springboot.dto.PostResponse;
import com.graphql.springboot.repository.PostRepository;

@Component
public class MyQuery implements GraphQLQueryResolver {
	private final PostRepository postRepository;

	public MyQuery(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<PostResponse> getRecentPosts(int count, int offset) {
		final List<Post> all = postRepository.findAll();
		return PostResponse.from(all);
	}
}
