package pl.sdacademy.product;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.category.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private ProductRepositoryJPA productRepositoryJPA;
    private CategoryRepository categoryRepositoryl;

    public ProductController(ProductService productService, ProductRepositoryJPA productRepositoryJPA, CategoryRepository categoryRepositoryl) {
        this.productService = productService;
        this.productRepositoryJPA = productRepositoryJPA;
        this.categoryRepositoryl = categoryRepositoryl;
    }

    @GetMapping
    public String getAll(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Product> products = productService.getAll(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);

        return "product/productsTamplate";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/add")
    public String addForm(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("categories", categoryRepositoryl.findAll());
        return "product/form";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public String addProduct(Product product) {
        productRepositoryJPA.save(product);
        return "redirect:/product";
    }
}