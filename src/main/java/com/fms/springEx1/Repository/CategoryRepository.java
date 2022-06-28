package com.fms.springEx1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.springEx1.Entities.Category;
import com.fms.springEx1.Entities.CategoryEnum;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findByName(String name);
	
}
