package br.com.vilara.vilarashopping.dao;

import java.util.List;

import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.CartLine;



public interface CartLineDAO {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateCart(Cart cart);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	// adding order details
//	boolean addOrderDetail(OrderDetail orderDetail);

	
}