package br.com.vilara.vilarashopping.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vilara.vilarashopping.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	boolean add(Category category);	
	boolean update(Category category);	
	boolean delete(Category category);	

}
