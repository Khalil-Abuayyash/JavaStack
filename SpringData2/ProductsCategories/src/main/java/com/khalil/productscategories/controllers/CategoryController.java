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
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/categories/new.jsp";
		}
		categoryService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	@GetMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		List<Product> productsNotinCategory = productService.findProductsNotInCategories(category);
		model.addAttribute("productsNotinCategory", productsNotinCategory);
		return "/categories/category.jsp";
	}
	
	@PutMapping("{id}/addProduct")
	public String addProdcut(@PathVariable("id") Long id, @RequestParam("product") Product product) {
		categoryService.addProduct(product, id);
		return "redirect:/categories/"+id;
	}
}
