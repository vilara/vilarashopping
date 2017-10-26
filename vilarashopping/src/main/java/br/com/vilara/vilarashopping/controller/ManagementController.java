package br.com.vilara.vilarashopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.vilara.vilarashopping.dao.CategoryDAO;
import br.com.vilara.vilarashopping.dto.Category;
import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.dto.User_detail;

@Controller
@RequestMapping(value="manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		
		User_detail user = new User_detail();
		user.setId(2);
		
		Category cat = new Category();
		cat.setId(1);
		
		//set few of the fields
		nProduct.setSupplierId(user);
		nProduct.setCategoryId(cat);
		nProduct.setActive(true);
		nProduct.setViews(0);
		nProduct.setPurchases(0);
		mv.addObject("product", nProduct);		
		
		return mv;
	}
	
	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
		
	}

}
