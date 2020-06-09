package com.graphql.springboot.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.graphql.springboot.domain.Author;
import com.graphql.springboot.domain.Post;

public class PostResponse {
	private long id;
	private String title;
	private String text;
	private String category;
	private Author author;

	public PostResponse(long id, String title, String text, String category, Author author) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.category = category;
		this.author = author;
	}

	public PostResponse() {
	}

	public static List<PostResponse> from(Collection<Post> entities) {
		return entities.stream().map(PostResponse::from).collect(Collectors.toList());
	}

	public static PostResponse from(Post entity) {
		return PostResponse.builder()
			.id(entity.getId())
			.title(entity.getTitle())
			.text(entity.getText())
			.category(entity.getCategory())
			.author(entity.getAuthor())
			.build();
	}

	public static PostResponseBuilder builder() {
		return new PostResponseBuilder();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public static class PostResponseBuilder {
		private long id;
		private String title;
		private String text;
		private String category;
		private Author author;

		PostResponseBuilder() {
		}

		public PostResponse.PostResponseBuilder id(long id) {
			this.id = id;
			return this;
		}

		public PostResponse.PostResponseBuilder title(String title) {
			this.title = title;
			return this;
		}

		public PostResponse.PostResponseBuilder text(String text) {
			this.text = text;
			return this;
		}

		public PostResponse.PostResponseBuilder category(String category) {
			this.category = category;
			return this;
		}

		public PostResponse.PostResponseBuilder author(Author author) {
			this.author = author;
			return this;
		}

		public PostResponse build() {
			return new PostResponse(id, title, text, category, author);
		}

		public String toString() {
			return "PostResponse.PostResponseBuilder(id=" + this.id + ", title=" + this.title + ", text=" + this.text
				+ ", category=" + this.category + ", author=" + this.author + ")";
		}
	}
}