package com.shopme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Category;
import com.shopme.repository.CategoryRepository;
import com.shopme.service.impl.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired 
	private CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Category> listNoChildrenCategories() {
		
		List<Category> listNoChildrenCategories = new ArrayList<>();

		List<Category> listEnabledCategories = repo.findAllEnabled();

		listEnabledCategories.forEach(category -> {
			Set<Category> children = category.getChildren();
			if (children == null || children.size() == 0) {
				listNoChildrenCategories.add(category);
			}
		});

		return listNoChildrenCategories;
	}

}
