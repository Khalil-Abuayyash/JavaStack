package com.khalil.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khalil.productscategories.models.Category;
import com.khalil.productscategories.models.Product;
import com.khalil.productscategories.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public List<Product> findProductsNotInCategories(Category category) {
		return productRepository.findByCategoriesNotContaining(category);
	}
	
	public Product addCategory(Category category, Long id) {
		Product product = this.findProduct(id);
		product.getCategories().add(category);
		return productRepository.save(product);
	}
}
