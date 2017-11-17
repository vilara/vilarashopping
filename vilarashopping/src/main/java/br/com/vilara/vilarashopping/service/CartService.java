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
	private CartLineDAO cartLIneDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private HttpSession session;

	private Cart getCart() {

		return ((UserModel) session.getAttribute("userModel")).getCart();

	}

	// returns the entire cart lines
	public List<CartLine> getCartLInes() {
		Cart cart = this.getCart();
		return cartLIneDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {

		CartLine cartLine = cartLIneDAO.get(cartLineId);

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

			cartLIneDAO.update(cartLine);

			Cart cart = this.getCart();

			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());

			cartLIneDAO.updateCart(cart);

			return "result=update";
		}

	}

	public String deleteCartLine(int cartLineId) {

		// fetch the cartliline

		CartLine cartLine = cartLIneDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		} else {

			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLIneDAO.updateCart(cart);

			// remove the cart line
			cartLIneDAO.remove(cartLine);

			return "result=deleted";
		}

	}

	public String addCartLine(int productId) {

		String response = null;

		Cart cart = this.getCart();

		CartLine cartline = cartLIneDAO.getByCartAndProduct(cart.getId(), productId);

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

			cartLIneDAO.add(cartline);

			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartline.getTotal());

			cartLIneDAO.updateCart(cart);

			response = "result=added";

		}

		return response;
	}
}
