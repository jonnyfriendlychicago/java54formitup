package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.CategoryMdl;
import com.jonfriend.java54formitup.models.ProductMdl;
import com.jonfriend.java54formitup.repositories.ProductRpo;

@Service
public class ProductSrv {
	
	// adding the product repository as a dependency
	private final ProductRpo productRpo;
	
	public ProductSrv(ProductRpo productRpo) {this.productRpo = productRpo;}
	
	// creates one product >> rename as createNew
	public ProductMdl addProduct(ProductMdl x) {
		return productRpo.save(x);
	}

	// updates one product >> rename as update
	public ProductMdl updateProduct(ProductMdl x) {
		return productRpo.save(x);
	}
	
	// delete product by id >> rename as delete
	// JRF: this srv is very different from myu publicationSrv.delete.  what gives?
	public void deleteProduct(ProductMdl x) {
		productRpo.delete(x);
	}
	
	// returns one product by id >> no need rename
	public ProductMdl findById(Long id) {
		Optional<ProductMdl> optionalProduct = productRpo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	// returns all product >> RENAME AS returnAll
	public List<ProductMdl> allProducts(){
		return productRpo.findAll();
	}
	
	// get all joined product >> rename as returnJoinedCategory
	public List<ProductMdl> getAssignedCategories(CategoryMdl x){
//		return productRpo.findAllByCategories(x);
		return productRpo.findAllByCategoryMdl(x);
	}
	
	// get all un-joined product >> rename as returnNotJoinedProduct
	public List<ProductMdl> getUnassignedCategories(CategoryMdl x){
//		return productRpo.findByCategoriesNotContains(x);
		return productRpo.findByCategoryMdlNotContains(x);
	}
	
	// this is for removing a product-category join record/entry
	// we are approaching the targeted bomb site (join entry) from the product air force base.
	
	public void removeProductCategoryJoin(CategoryMdl c, ProductMdl p ) {
		List<CategoryMdl> categoryList = p.getCategoryMdl(); 
		categoryList.remove(c); 
		this.productRpo.save(p); 
	}
	
	
}