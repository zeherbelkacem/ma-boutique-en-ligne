package com.fms.maboutiqueenligne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.maboutiqueenligne.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByName(String catName);

	
	
}
