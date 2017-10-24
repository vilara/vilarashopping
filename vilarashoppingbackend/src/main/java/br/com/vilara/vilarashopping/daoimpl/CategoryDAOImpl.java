package br.com.vilara.vilarashopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.vilara.vilarashopping.dao.CategoryDAO;
import br.com.vilara.vilarashopping.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
			
			static {
				
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is the some description about television");
		category.setUmageURL("CAT_1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is the some description about mobile");
		category.setUmageURL("CAT_2.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is the some description about laptop");
		category.setUmageURL("CAT_3.png");
		
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
	for(Category category : categories) {
		if(category.getId() == id) return category;
	}
	return null;
	}

}
