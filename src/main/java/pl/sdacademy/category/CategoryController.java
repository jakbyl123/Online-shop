package pl.sdacademy.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String categories(ModelMap modelMap){
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute ("category") Category category){
        return "category/form";
    }

    @PostMapping("/add")
    public String addCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/category";
    }
}
