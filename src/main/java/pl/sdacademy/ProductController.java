package pl.sdacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductRepositoryJPA productRepositoryJPA;

    public ProductController(ProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }

    @GetMapping()
    public String getAll(ModelMap modelMap) {
        List<Product> products = productRepositoryJPA.findAll();
        modelMap.addAttribute("products", products);
        return "productsTamplate";
    }
}
