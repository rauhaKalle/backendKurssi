package projekti.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projekti.bookstore.domain.Category;
import projekti.bookstore.domain.CategoryRepository;
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository cRepository;
	

	@RequestMapping(value ="/addcategory")
	public String addCategory(Model model){
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	@RequestMapping(value="/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		cRepository.save(category);
		return "redirect:categorylist";
	}
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categoryList(Model model) {
		
		model.addAttribute("categories", cRepository.findAll());
		return "categorylist";
	}

}
