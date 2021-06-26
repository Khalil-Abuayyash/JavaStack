package com.khalil.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khalil.productscategories.models.Category;
import com.khalil.productscategories.models.Product;
import com.khalil.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
	
	public List<Category> findCategoriesNotInProduct(Product product) {
		return categoryRepository.findByProductsNotContaining(product);
	}
	
	public Category addProduct(Product product, Long id) {
		Category category = this.findCategory(id);
		category.getProducts().add(product);
		return categoryRepository.save(category);
	}
	

}
