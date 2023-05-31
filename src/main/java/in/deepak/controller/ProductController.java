package in.deepak.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.deepak.binding.Product;
import in.deepak.entity.ProductEntity;
import in.deepak.repo.ProductRepository;
import in.deepak.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/")
	public String loadindexpage(Model model) {
		
		model.addAttribute("product",new Product() );
		
		
		return "index";
	}
	
	@PostMapping("/save")
	public String savedata(@Validated @ModelAttribute("product") Product p,BindingResult results, Model model) {
		
		if(results.hasErrors()){
			return "index";
		}
		
		
		service.Savefromdata(p);
		
		model.addAttribute("msg", "DataSaved");
		
		return "index";
	}
	
	
	@GetMapping("/products")
	public String dataview(Model model) {
		
	model.addAttribute("products", repo.findAll());	
		  
		  
		 
		
		
		return "data";
	}
	
	@GetMapping("/delete")
	public String Deleteinfo(@RequestParam("pid")Integer pid ,Model model ) {
		
		repo.deleteById(pid);
		
	model.addAttribute("msg", "product deleted");
	model.addAttribute("products",repo.findAll());
		
		return "data";
		
		
		
	}
	
	@GetMapping("/edit")
	public String editproduct(@RequestParam("pid")Integer pid ,Model model ) {
		
		Optional<ProductEntity> findById = repo.findById(pid);
		
		if(findById.isPresent()) {
			
			ProductEntity prt= findById.get();
			model.addAttribute("product", prt);
		}
		
		return "index";
	}
}
