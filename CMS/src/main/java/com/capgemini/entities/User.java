package com.capgemini.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "group_name", nullable = false, length = 50)
	private String groupName;

	@Column(name = "full_name", nullable = false, length = 50)
	private  String fullName;

	@Column(name = "email", unique = true, length = 50)
	private String email;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "is_locked")
	private boolean isLocked = false;

	@OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
	private Set<Page> page = new  HashSet<>();

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	

	public Set<Page> getPage() {
		return page;
	}

	public void setPage(Set<Page> page) {
		this.page = page;
	}

	public void addPage(Page page) {
		page.setAuthor(this); // this will avoid nested cascade
		this.getPage().add(page);
	}

}
