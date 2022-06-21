package com.fms.maboutiqueenligne.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.CategoryRepository;
import com.fms.maboutiqueenligne.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	CategoryRepository categoryRepository;
	
	
	@Override
	public List<Category> getAll() throws Exception {
		return categoryRepository.findAll();
	}

	@Override
	public Category getOneById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
