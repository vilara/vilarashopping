package br.com.vilara.vilarashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.vilara.vilarashopping.dao.CategoryDAO;
import br.com.vilara.vilarashopping.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private static Category category;
	
	@BeforeClass
	public static void init() {
		
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.vilara.vilarashopping");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
				
	}
	
	/*@Test
	public void testCategory() {
		category = new Category();
		
		category.setName("Teste");
		category.setDescription("This is the some description about mobile");
		category.setUmageURL("CAT_4.png");
		
		assertEquals("Success added a category inside the table", true, categoryDAO.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(1);
		assertEquals("Success fetched a single category from the table", "Television", category.getName());
		
	}*/
	
	
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Success update a single category in the table", true, categoryDAO.update(category));
		
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(4);
		assertEquals("Success update a single category in the table", true, categoryDAO.delete(category));
		
	}*/
	
	/*@Test
	public void testListCategory() {
		assertEquals("Success list of  categories from the table",3, categoryDAO.list().size());
		
	}*/
	
	
	/*@Test
	public void testCRUDCategory() {
		
	}*/

}
