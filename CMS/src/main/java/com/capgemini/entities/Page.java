package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "page_table")
public class Page {
	
	@Id
	@Column(name = "page_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pageId;
	
	@Column(name = "page_title")
	private String pageTitle;
	
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryTitle")
	private Category category;
	
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User author;
	
	@Column(name = "page_content")
	private String content;
	
	public Page() {}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
