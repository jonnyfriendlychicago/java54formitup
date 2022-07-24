package com.jonfriend.java54formitup.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jonfriend.java54formitup.models.CategoryMdl;
import com.jonfriend.java54formitup.models.ProductMdl;
import com.jonfriend.java54formitup.services.CategorySrv;
import com.jonfriend.java54formitup.services.ProductSrv;
import com.jonfriend.java54formitup.services.UserSrv;

@Controller
public class StoreCtl {

//	JRF-FRI: begin cut to HomeController
		@Autowired
		private ProductSrv productSrv;
		
		@Autowired
		private CategorySrv categorySrv;

//	JRF-FRI: end cut to HomeController
	
	@Autowired
	private UserSrv userSrv;

// ***************************************************
// applicable-to-all methods	
// ***************************************************
	
	// display store page with list of product and category
	@GetMapping("/store")
	public String index(
			Model model
			, HttpSession session
			) {
		
		
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
//		JRF-FRI: begin cut to HomeController

			List<ProductMdl> intVar1 = productSrv.allProducts();
			model.addAttribute("productList", intVar1);
	
			List<CategoryMdl> intVar2 = categorySrv.allCategories();
			model.addAttribute("categoryList", intVar2);
		
//		JRF-FRI: end cut to HomeController
		
//		return "store/store.jsp";
		return "store.jsp";
	}

// ***************************************************
// product methods	
// ***************************************************

//	// display create-new product page
//	@GetMapping("/store/product/new")
//	public String newProduct(
//			@ModelAttribute("product") ProductMdl productMdl
//			, Model model
//			, HttpSession session
//			) {
//		
//		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		
//		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
//		Long userId = (Long) session.getAttribute("userId");
//		model.addAttribute("user", userSrv.findById(userId));
//		
//		return "store/product/create.jsp";
//	}
//	
//	// process the create-new product 
//	@PostMapping("/store/product/new")
//	public String addNewProduct(
//			@Valid @ModelAttribute("product") ProductMdl productMdl
//			, BindingResult result
//			, Model model
//			, HttpSession session
//			) {
//		
//		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		
//		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
//		Long userId = (Long) session.getAttribute("userId");
//		model.addAttribute("user", userSrv.findById(userId));
//		
//		if(result.hasErrors()) {
//			return "store/product/create.jsp";
//		}else {
//			productSrv.addProduct(productMdl);
//			return "redirect:/store";
//		}
//	}
//	
//	// view/manage one product
//	@GetMapping("/store/product/{id}")
//	public String showProduct(
//			@PathVariable("id") Long id
//			, Model model
//			, HttpSession session
//			) {
//		
//		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		
//		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
//		Long userId = (Long) session.getAttribute("userId");
//		model.addAttribute("user", userSrv.findById(userId));
//		
//		ProductMdl intVar = productSrv.findById(id);
//		
//		model.addAttribute("product", intVar);
//		model.addAttribute("assignedCategories", categorySrv.getAssignedProducts(intVar));
//		model.addAttribute("unassignedCategories", categorySrv.getUnassignedProducts(intVar));
//		
//		return "/store/product/record.jsp";
//	}
//	
//	// process edits to that one product
//	@PostMapping("/store/product/{id}")
//	public String editProduct(
//			@PathVariable("id") Long id
//			, @RequestParam(value="categoryId") Long catId // requestParam is only used with regular HTML form 
//			,  Model model
//			, HttpSession session
//			) {
//		
//		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		
//		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
//		Long userId = (Long) session.getAttribute("userId");
//		model.addAttribute("user", userSrv.findById(userId));
//		
//		ProductMdl product = productSrv.findById(id);
//		CategoryMdl category = categorySrv.findById(catId);
//		
//		product.getCategoryMdl().add(category);
//		
//		productSrv.updateProduct(product);
//		
//		model.addAttribute("assignedCategories", categorySrv.getAssignedProducts(product));
//		model.addAttribute("unassignedCategories", categorySrv.getUnassignedProducts(product));
//		return "redirect:/store/product/" + id;
//	}
//	
//	// this is JRF method to remove instance of a cat-pro join record from the product. 
//	// don't use deleteMapping here... just use a link on the page to call the 'remove' method to remove item from list, something like that. 
//	
//	
//	
//    @DeleteMapping("/store/whackProdCatJoin")
//    public String whackProdCatJoin(
////    		@PathVariable("publicationId") Long publicationId
//    		@RequestParam(value="categoryId") Long categoryId // requestParam is only used with regular HTML form
//    		, @RequestParam(value="productId") Long productId // requestParam is only used with regular HTML form    		
//    		, HttpSession session
//    		, RedirectAttributes redirectAttributes
//    		) {
//
//    	// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		
////		here is the srv to remove this thing
////		but first need to get the some thing via id's coming from param
//		
//		ProductMdl productObject = productSrv.findById(productId);
//		CategoryMdl categoryObject  = categorySrv.findById(categoryId);
//		
//		productSrv.removeProductCategoryJoin(categoryObject, productObject); 
//		
//		return "redirect:/store/product/" + productId;
//    }
//	
//	
	
// ***************************************************
// category methods	
// ***************************************************
	
//	// display create-new category page
//	@GetMapping("/store/category/new")
//	public String newCategory(
//			@ModelAttribute("category") CategoryMdl categoryMdl
//			) {
//		return "store/category/create.jsp";}
//	
//	// process the create-new category
//	@PostMapping("/store/category/new")
//	public String addNewCategory(
//			@Valid @ModelAttribute("category") CategoryMdl categoryMdl
//			, BindingResult result
//			, Model model) {
//		
//		if(result.hasErrors()) {
//			return "store/category/create.jsp";
//		} else {
//			categorySrv.addCategory(categoryMdl);
//			return "redirect:/store";
//		}	
//	}
//	
//	// view/manage one category
//	@GetMapping("/store/category/{id}")
//	public String showCategory(
//			@PathVariable("id") Long id
//			, Model model
//			) {
//		CategoryMdl category = categorySrv.findById(id);
//		
//		model.addAttribute("category", categorySrv.findById(id));
//		model.addAttribute("assignedProducts", productSrv.getAssignedCategories(category));
//		model.addAttribute("unassignedProducts", productSrv.getUnassignedCategories(category));
//		
//		return "/store/category/record.jsp";
//	}
//	
//	// process edits to that one category
//	@PostMapping("/store/category/{id}")
//	public String editCategory(
//			@PathVariable("id") Long id
//			, @RequestParam(value="productId") Long productId
//			, Model model
//			) {
//		
//		CategoryMdl category = categorySrv.findById(id);
//		ProductMdl product = productSrv.findById(productId);
//		
//		category.getProductMdl().add(product);
//		categorySrv.updateCategory(category);
//		model.addAttribute("assignedProducts", productSrv.getAssignedCategories(category));
//		model.addAttribute("unassignedProducts", productSrv.getUnassignedCategories(category));
//		return "redirect:/store/category/" + id;
//	}

// end ctl
}