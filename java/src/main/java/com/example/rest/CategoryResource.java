package com.example.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Enum.Category;
import com.example.model.to.CategoryTO;

@RestController
@RequestMapping("/category")
public class CategoryResource {
	
	/**
	 * return all the categories
	 * @return  List<CategoryTO>
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@Cacheable(value = "categories")
	@GetMapping
	public List<CategoryTO> getCategories() {

		List<CategoryTO> categoriesTO = new ArrayList<>();

		Arrays.asList(Category.values()).forEach(c -> {
			CategoryTO cat = new CategoryTO();
			cat.setCategoryKey(c.name());
			cat.setCategoryValue(c.getCategory());
			categoriesTO.add(cat);
		});

		return categoriesTO;
	}

}
