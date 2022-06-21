package com.fms.maboutiqueenligne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.maboutiqueenligne.dao.CategoryRepository;
import com.fms.maboutiqueenligne.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll()  {
		return categoryRepository.findAll();
	}

	@Override
	public Category getOneById(long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(long id) {
		categoryRepository.deleteById(id);
	}

}
