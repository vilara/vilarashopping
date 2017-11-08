package br.com.vilara.vilarashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.User_detail;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;

	private static User_detailDAO userDAO;

	private User_detail user;
	
	private Cart cart;
	
	private Address address;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.vilara.vilarashopping");
		context.refresh();

		userDAO = (User_detailDAO) context.getBean("User_detailDAO");

	}
	
	@Test
	public void testAdd() {
		user = new User_detail();
		
		user.setFirst_name("Marcelo Martins");
		user.setLast_name("Vilara");
		user.setEmail("marcelovilara@gmail.com");
		user.setContact_number("13981194156");
		user.setRole("USER");
		user.setPassword("ole30cram");
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		
		address = new Address();
		
		address.setAddressLineOne("Rua Ceará 20, AP 102");
		address.setAddressLinetwo("Pompeia Santos-SP");
		address.setCity("Santos");
		address.setState("Sao Paulo");
		address.setCountry("Brasil");
		address.setPostalCode("11065430");
		address.setBilling(true);
		
		// link the usere with address using user id		
		address.setUserId(user.getId());
		
		// add the address
		assertEquals("Failed to add address", true, userDAO.addAddress(address));
		
		
		if (user.getRole().equals("USER")) {
		
			// create a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());
			
			// add the cart
			assertEquals("Failed to add address", true, userDAO.addCart(cart));
			
			// add a shipping address for this user
			address = new Address();
			
			address.setAddressLineOne("Rua Ceará 20, AP 102");
			address.setAddressLinetwo("Pompeia Santos-SP");
			address.setCity("Santos");
			address.setState("Sao Paulo");
			address.setCountry("Brasil");
			address.setPostalCode("11065000");
			address.setShipping(true);
			
			// link it with the user
			address.setUserId(user.getId());
			
			// add the shipping address
			assertEquals("Failed to add address", true, userDAO.addAddress(address));

		}
	}
	
	
	
}
