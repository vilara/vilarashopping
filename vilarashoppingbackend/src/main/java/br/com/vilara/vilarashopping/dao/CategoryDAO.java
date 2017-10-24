package br.com.vilara.vilarashopping.dao;

import java.util.List;

import br.com.vilara.vilarashopping.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
