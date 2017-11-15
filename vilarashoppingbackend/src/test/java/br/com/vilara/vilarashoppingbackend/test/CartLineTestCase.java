package br.com.vilara.vilarashoppingbackend.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.vilara.vilarashopping.dao.CartLineDAO;
import br.com.vilara.vilarashopping.dao.ProductDAO;
import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.CartLine;
import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.dto.User_detail;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static User_detailDAO userDAO;
	
	
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("br.com.vilara.vilarashopping");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (User_detailDAO)context.getBean("user_detailDAO");
	}
	
	
	@Test
	public void testAddNewCartLIne() {
		
		// 1. get the user
		User_detail user = userDAO.getByEmail("marco@gmail.com");
		
		//2. get the cart
		Cart cart = user.getCart();
		
		//3. get the product
		Product product = productDAO.get(1);
		
		//4. create a new CartLine
		
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		
		// update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.updateCart(cart));
	}
	
/*	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(2);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	
	*/
	
/*	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User_detail user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	

		
	}*/
	
	
	
}
