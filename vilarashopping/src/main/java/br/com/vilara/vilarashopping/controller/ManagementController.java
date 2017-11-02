package br.com.vilara.vilarashopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vilara.vilarashopping.dao.CategoryDAO;
import br.com.vilara.vilarashopping.dao.ProductDAO;
import br.com.vilara.vilarashopping.dto.Category;
import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.util.FileUploadUtility;
import br.com.vilara.vilarashopping.validator.ProductValidatorClass;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		
	//	User_detail user = new User_detail();
	//	user.setId(2);
		
	//	Category cat = new Category();
	//	cat.setId(1);
		
		//set few of the fields
	//	nProduct.setSupplierId(user);
	//	nProduct.setCategoryId(cat);
		nProduct.setActive(true);
		nProduct.setViews(0);
		nProduct.setPurchases(0);
		mv.addObject("product", nProduct);		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		return mv;
	}
	// handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handlingManageProducts(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, 
			HttpServletRequest request) {
		
		new ProductValidatorClass().validate(mProduct, results);
		// check if there are any errors
		
		if (results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Failed for the upload the product");
			
			return "page";
		}
		
		logger.info(mProduct.toString());
				// create a new product record
		mProduct.setActive(true);
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
		
	}
	

}
