package com.productspringapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productspringapp.dao.ProductDao;
import com.productspringapp.models.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@ModelAttribute  //this method we can use as a common functionality
	public void commonDataFromModel(Model m)
	{
		m.addAttribute("author","Dhruv Tylor");
		m.addAttribute("programmer","fullstack");
	}
	
	@RequestMapping("/")
	public String home(Model m)
	{
		m.addAttribute("title", "Amazon | Product Landing page");
		List<Product> productList =  productDao.getProducts();
		m.addAttribute("productList", productList);
		
		return "index";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model m)
	{
		m.addAttribute("title", "Amazon | Add Product Panel");
		return "add_product_form";
	}
	
	@RequestMapping(value = "/productHandle", method = RequestMethod.POST)
	public RedirectView productHandle(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
	}
		
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request)
	{
		productDao.deleteSingleProduct(productId);
		RedirectView returnview = new RedirectView();
		returnview.setUrl(request.getContextPath() + "/");
		return returnview;
	}

	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pid, Model m)
	{	
		System.out.println(pid);
		m.addAttribute("title", "Amazon | Product Update");
		Product product= productDao.getProduct(pid);
		System.out.println(product);
		m.addAttribute("productData", product);
		return "product_update_form";
	}
	
}
