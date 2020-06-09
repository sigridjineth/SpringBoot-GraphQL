package com.graphql.springboot.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.springboot.domain.Post;
import com.graphql.springboot.dto.PostResponse;
import com.graphql.springboot.repository.AuthorRepository;
import com.graphql.springboot.repository.PostRepository;

@Component
public class MyMutation implements GraphQLMutationResolver {
	private final PostRepository postRepository;
	private final AuthorRepository authorRepository;

	public MyMutation(PostRepository postRepository, AuthorRepository authorRepository) {
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}

	public PostResponse writePost(String title, String text, String category) {
		Post post = new Post();
		post.setTitle(title);
		post.setText(text);
		post.setCategory(category);
		post.setAuthor(authorRepository.getOne(1L));

		final Post save = postRepository.save(post);

		return PostResponse.from(save);
	}
}