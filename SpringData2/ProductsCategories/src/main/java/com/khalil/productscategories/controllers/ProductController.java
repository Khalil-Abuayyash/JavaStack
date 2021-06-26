package com.khalil.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khalil.productscategories.models.Category;
import com.khalil.productscategories.models.Product;
import com.khalil.productscategories.services.CategoryService;
import com.khalil.productscategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@PostMapping("")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result ) {
		if (result.hasErrors()) {
			return "/products/new.jsp";
		}
		productService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@GetMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		List<Category> categoriesNotinProduct = categoryService.findCategoriesNotInProduct(product);
		model.addAttribute("categoriesNotinProduct", categoriesNotinProduct);
		return "/products/product.jsp";
	}
	
	@PutMapping("{id}/addCategory")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("category") Category category) {
		productService.addCategory(category, id);
		return "redirect:/products/"+id;
	}
	
}
