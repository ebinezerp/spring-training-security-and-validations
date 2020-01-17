package spring.training.aopdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import spring.training.aopdemo.dao.ProductDAO;
import spring.training.aopdemo.model.Product;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDao;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/addproduct")
	public String addProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "addproduct";
	}

	@PostMapping("/addproduct")
	public String addProduct(@Valid @ModelAttribute("product") Product product, Errors errors, Model model) {

		if (errors.hasErrors()) {
			return "addproduct";
		}

		if (productDao.addProduct(product)) {
			return "redirect:/addproduct";
		} else {
			model.addAttribute("nameError", "Name is already existed");
			return "addproduct";
		}
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/commonpage")
	public String commonPage() {
		return "common";
	}
}
