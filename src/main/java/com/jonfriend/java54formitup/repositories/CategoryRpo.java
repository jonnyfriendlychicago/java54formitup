package com.jonfriend.java54formitup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.java54formitup.models.CategoryMdl;
import com.jonfriend.java54formitup.models.ProductMdl;

@Repository
public interface CategoryRpo extends CrudRepository<CategoryMdl, Long> {
	
	List<CategoryMdl> findAll();
	
	CategoryMdl findByIdIs(Long id);
	
//	List<CategoryMdl> findAllByProducts(ProductMdl productMdl);
	List<CategoryMdl> findAllByProductMdl(ProductMdl productMdl);
	
//	List<CategoryMdl> findByProductsNotContains(ProductMdl productMdl);
	List<CategoryMdl> findByProductMdlNotContains(ProductMdl productMdl);
}
