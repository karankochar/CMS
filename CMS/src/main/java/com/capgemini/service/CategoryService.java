package com.capgemini.service;

import com.capgemini.entities.Category;

public interface CategoryService {
	public Category addCategory(Category category);
	public Category findCategoryById(int categoryId) throws NoSuchCategoryException;
}
