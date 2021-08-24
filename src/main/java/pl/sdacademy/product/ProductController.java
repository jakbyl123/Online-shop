package pl.sdacademy.product;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAll(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Product> products = productService.getAll(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);

        return "productsTemplate";
    }
}
