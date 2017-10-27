package br.com.vilara.vilarashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.vilara.vilarashopping.dao.CategoryDAO;
import br.com.vilara.vilarashopping.dao.ProductDAO;
import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Category;
import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.dto.User_detail;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private static Product product;
	
	private static CategoryDAO categoryDAO;
	
	private static Category category;
	
	private static User_detailDAO userDetailDAO;
	
	private static User_detail userDetail;
	
	
	@BeforeClass
	public static void init() {
		
		
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.vilara.vilarashopping");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("ProductDAO");
		categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
		userDetailDAO = (User_detailDAO) context.getBean("UserDetailDAO");
				
	}
	
	
	@Test
	public void testCRUDProduct() {
		
		category = new Category();
		category.setId(1);
		
		userDetail = new User_detail();
		userDetail.setId(1);
		
		product = new Product();
		
		/*product = productDAO.get(16);
		product.setId(22);*/
		
		// create operation
		product.setName("Brasil");
		product.setBrand("Oppo");
		product.setDescription("This the some description oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(category);
		product.setSupplierId(userDetail);
		product.setPurchases(1);
		product.setViews(1);
		product.setQuatity(4);
		assertEquals("Success added a product inside the table", true, productDAO.add(product));
	}

	
	/*	@Test
	public void testGetProduct() {
			product = productDAO.get(16);
		assertEquals("Success fetched a single category from the table", "iPhone 5s", product.getName());
		
	}*/
	
/*	@Test
	public void testUpdateProduct() {
		product = productDAO.get(16);
		product.setName("iPhone 6s");
		assertEquals("Success update a single category in the table", true, productDAO.update(product));
		
	}*/
	
	/*@Test
	public void testDeleteProduct() {
		product = productDAO.get(16);
		assertEquals("Success delete a single category in the table", true, productDAO.delete(product));
		
	}*/
	
/*	@Test
	public void testListProduct() {
		assertEquals("Success list of  products from the table",5, productDAO.list().size());
		
	}*/
	
/*		@Test
	public void testListActiveProduct() {
		assertEquals("Success list of  products from the table",5, productDAO.listActiveProducts().size());
		
	}
	*/
	
/*		@Test
	public void testActiveProductsByCategory() {
		assertEquals("Success list of  products from the table",3, productDAO.listActiveProductsByCategory(3).size());
		
	}*/
	
	/*		@Test
	public void testActiveProductsByCategory() {
		assertEquals("Success list of  products from the table",3, productDAO.getLatestActiveProducts(3).size());
		
	}*/
	
}
