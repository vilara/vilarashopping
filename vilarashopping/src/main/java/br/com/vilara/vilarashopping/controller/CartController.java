package br.com.vilara.vilarashopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vilara.vilarashopping.dao.CartLineDAO;
import br.com.vilara.vilarashopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");

		if (result != null) {
			switch (result) {
			case "update":
				mv.addObject("message", "Cartline has been update successfully!");
				break;
			case "added":
				mv.addObject("message", "Cartline has been added successfully!");
				break;
			case "modified":
				mv.addObject("message", "One or more items inside cart has been modified!");
				break;
			case "deleted":
				mv.addObject("message", "Cartline has been deleted successfully!");
				break;
			case "error":
				mv.addObject("message", "Something went wrong!");
				break;
			}
		}

		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLInes());

		return mv;
	}

	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {

		String response = cartService.updateCartLine(cartLineId, count);
		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {

		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {

		String response = cartService.addCartLine(productId);
		return "redirect:/cart/show?" + response;
	}

	/*
	 * after validating it redirect to checkout if result received is success
	 * proceed to checkout else display the message to the user about the changes in
	 * cart page
	 */
	@RequestMapping("/validate")
	public String validateCart() {
		String response = cartService.validateCartLine();
		if (!response.equals("result=success")) {
			return "redirect:/cart/show?" + response;
		} else {
		}
		return "redirect:/cart/checkout";
	}
}
