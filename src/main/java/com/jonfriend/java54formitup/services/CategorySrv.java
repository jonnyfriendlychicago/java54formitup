package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.CategoryMdl;
import com.jonfriend.java54formitup.models.ProductMdl;
import com.jonfriend.java54formitup.repositories.CategoryRpo;

@Service
public class CategorySrv {
	
	// adding the category repository as a dependency
	private final CategoryRpo categoryRpo;
	
	public CategorySrv (CategoryRpo categoryRpo) {this.categoryRpo = categoryRpo;}
	
	// creates one category >> rename as createNew
	public CategoryMdl addCategory(CategoryMdl x) {
		return categoryRpo.save(x);
	}

	// updates one category >> rename as update
	public CategoryMdl updateCategory(CategoryMdl x) {
		return categoryRpo.save(x);
	}
	
	// delete category by id >> rename as delete
	// JRF: this srv is very different from myu publicationSrv.delete.  what gives? 
	public void deleteCategory(CategoryMdl x) {
		categoryRpo.delete(x);
	}
	
	// returns one category by id >> no need rename
	public CategoryMdl findById(Long id) {
		Optional<CategoryMdl> optionalCategory = categoryRpo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	// returns all category >> RENAME AS returnAll
	public List<CategoryMdl> allCategories(){
		return categoryRpo.findAll();
	}
	
	// get all joined product >> rename as returnJoinedProduct
	public List<CategoryMdl> getAssignedProducts(ProductMdl x){
		return categoryRpo.findAllByProductMdl(x);
	}
	
	// get all un-joined product >> rename as returnNotJoinedProduct
	public List<CategoryMdl> getUnassignedProducts(ProductMdl x){
		return categoryRpo.findByProductMdlNotContains(x);
	}
	
// end srv
}