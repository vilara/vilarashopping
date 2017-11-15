package br.com.vilara.vilarashopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vilara.vilarashopping.dao.CartLineDAO;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.CartLine;
import br.com.vilara.vilarashopping.model.UserModel;

@Service("cartService")
public class CartService {
	@Autowired
	private CartLineDAO cartLIneDAO;
	
	@Autowired
	private HttpSession session;
	
	private Cart getCart() {
		
		
		 return ((UserModel)session.getAttribute("userModel")).getCart();
		 
		 
	}
	
	// returns the entire cart lines
	public List<CartLine> getCartLInes(){
		Cart cart = this.getCart();
		return cartLIneDAO.list(cart.getId());
	}
}
