package br.com.vilara.vilarashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
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

/*	@Test
	public void testAdd() {
		user = new User_detail();

		user.setFirstName("Marcelo Martins");
		user.setLastName("Vilara");
		user.setEmail("marcelovilara@gmail.com");
		user.setContactNumber("13981194156");
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
		address.setUser(user);;

		// add the address
		assertEquals("Failed to add address", true, userDAO.addAddress(address));

		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			// add the cart
			assertEquals("Failed to add address", true, userDAO.add);

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
	}*/
	
	
	@Test
	public void testAdd() {
		user = new User_detail();

		user.setFirstName("Marcelo Martinssss");
		user.setLastName("Vilara");
		user.setEmail("marcelovilara@gmail.com");
		user.setContactNumber("13981194156");
		user.setRole("USER");
		user.setPassword("ole30cram");

		
		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			// attach cart with the user
			user.setCart(cart);
		}
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));

		
		
		
	}

	
	
	/*@Test
	public void testCaseUpdateCart() {
		
		// fetch the user by email
		
		user = userDAO.getByEmail("marcelovilara@gmail.com");
		
		// get the cart of the user
		
		cart = user.getCart();
		
		cart.setGrandTotal(555);
		cart.setCartLines(2);

		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
		
		
	}
*/
	/*@Test
	public void testAddAddress() {
		// we need to add an user
		
		user = new User_detail();

		user.setFirstName("Marco");
		user.setLastName("Vilara");
		user.setEmail("marco@gmail.com");
		user.setContactNumber("13981194156");
		user.setRole("USER");
		user.setPassword("ole30cram");

		assertEquals("Failed to add user", true, userDAO.addUser(user));

		// we are going add the address
		address = new Address();

		address.setAddressLineOne("Rua Ceará 20, AP 102");
		address.setAddressLinetwo("Pompeia Santos-SP");
		address.setCity("Santos");
		address.setState("Sao Paulo");
		address.setCountry("Brasil");
		address.setPostalCode("11065000");
		address.setBilling(true);
		
		//attached the user to the address
		
		address.setUser(user);
		
		
		assertEquals("Failed to add user", true, userDAO.addAddress(address));
		
		// we are going add the shipping address
		address = new Address();

		address.setAddressLineOne("Rua Brasil, AP 102");
		address.setAddressLinetwo("Pompeia Santos-SP");
		address.setCity("Santos");
		address.setState("Sao Paulo");
		address.setCountry("Brasil");
		address.setPostalCode("99065000");
		address.setShipping(true);
		
		address.setUser(user);
		

		assertEquals("Failed to add user", true, userDAO.addAddress(address));
	}*/
	
/*	@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("marco@gmail.com");
		
		// we are going add the shipping address
		address = new Address();

		address.setAddressLineOne("Rua Brasil, AP 102");
		address.setAddressLinetwo("Jacarepagua");
		address.setCity("Rio de Janeiro");
		address.setState("RJ");
		address.setCountry("Brasil");
		address.setPostalCode("40001");
		address.setShipping(true);
		
		address.setUser(user);
				
		assertEquals("Failed to add user", true, userDAO.addAddress(address));
		
	}*/
	
/*	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("marco@gmail.com");
		
						
		assertEquals("Failed to add user", "Santos", userDAO.getBillingsAddress(user).getCity());
		assertEquals("Failed to add user", 2, userDAO.listshippingAddresses(user).size());
		
	}*/
	
	
	
}
