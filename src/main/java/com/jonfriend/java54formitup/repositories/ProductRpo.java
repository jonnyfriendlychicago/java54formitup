package com.jonfriend.java54formitup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.java54formitup.models.CategoryMdl;
import com.jonfriend.java54formitup.models.ProductMdl;

@Repository
public interface ProductRpo extends CrudRepository<ProductMdl, Long> {
	
	List<ProductMdl> findAll();
	
	ProductMdl findByIdIs(Long id);
	
//	List<ProductMdl> findAllByCategories(CategoryMdl categoryMdl);
	List<ProductMdl> findAllByCategoryMdl(CategoryMdl categoryMdl);
	
//	List<ProductMdl> findByCategoriesNotContains(CategoryMdl categoryMdl);
	List<ProductMdl> findByCategoryMdlNotContains(CategoryMdl categoryMdl);
}
