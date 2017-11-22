package br.com.vilara.vilarashopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vilara.vilarashopping.dao.CartLineDAO;
import br.com.vilara.vilarashopping.dao.ProductDAO;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.CartLine;
import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private HttpSession session;
	
	public List<CartLine> getCartLines() {

		return cartLineDAO.list(getCart().getId());

	}

	private Cart getCart() {

		return ((UserModel) session.getAttribute("userModel")).getCart();

	}

	// returns the entire cart lines
	public List<CartLine> getCartLInes() {
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {

		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		} else {

			Product product = cartLine.getProduct();

			double oldTotal = cartLine.getTotal();

			if (product.getQuantity() <= count) {

				count = product.getQuantity();

			}

			cartLine.setProductCount(count);

			cartLine.setBuyingPrice(product.getUnitPrice());

			cartLine.setTotal(product.getUnitPrice() * count);

			cartLineDAO.update(cartLine);

			Cart cart = this.getCart();

			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());

			cartLineDAO.updateCart(cart);

			return "result=update";
		}

	}

	public String deleteCartLine(int cartLineId) {

		// fetch the cartliline

		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		} else {

			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);

			// remove the cart line
			cartLineDAO.remove(cartLine);

			return "result=deleted";
		}

	}

	public String addCartLine(int productId) {

		String response = null;

		Cart cart = this.getCart();

		CartLine cartline = cartLineDAO.getByCartAndProduct(cart.getId(), productId);

		if (cartline == null) {

			// add a new cartline

			cartline = new CartLine();

			// fetch the product

			Product product = productDAO.get(productId);

			cartline.setCartId(cart.getId());
			cartline.setProduct(product);
			cartline.setBuyingPrice(product.getUnitPrice());
			cartline.setProductCount(1);

			cartline.setTotal(product.getUnitPrice());
			cartline.setAvailable(true);

			cartLineDAO.add(cartline);

			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartline.getTotal());

			cartLineDAO.updateCart(cart);

			response = "result=added";

		}

		return response;
	}

		public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineDAO.list(cart.getId());
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Product product = null;
	 for(CartLine cartLine : cartLines) {					
			product = cartLine.getProduct();
			changed = false;
			// check if the product is active or not
			// if it is not active make the availability of cartLine as false
			if((!product.getIsActive() && product.getQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}	
			
			// check if the cartLine is not available
			// check whether the product is active and has at least one quantity available
			if((product.getIsActive() && product.getQuantity() > 0) && !(cartLine.isAvailable())) {
					cartLine.setAvailable(true);
					changed = true;
			}
			
			// check if the buying price of product has been changed
			if(cartLine.getBuyingPrice() != product.getUnitPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getUnitPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;				
			}
			
			// check if that much quantity of product is available or not
			if(cartLine.getProductCount() > product.getQuantity()) {
				cartLine.setProductCount(product.getQuantity());										
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;
				
			}
				
			// changes has happened
			if(changed) {				
				//update the cartLine
				cartLineDAO.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		cartLineDAO.updateCart(cart);

		return response;
	}
}
