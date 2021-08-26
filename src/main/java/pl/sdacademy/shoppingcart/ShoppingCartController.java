package pl.sdacademy.shoppingcart;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.product.Product;
import pl.sdacademy.product.ProductRepositoryJPA;
import pl.sdacademy.user.User;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private ProductRepositoryJPA productRepositoryJPA;

    public ShoppingCartController(ProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }

    @GetMapping
    public String getAllItems() {
        return "shopping-cart/shopping-cart";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("productId")Product product) {
        System.out.println(productRepositoryJPA.findById(product.getId()));

        return "redirect:/shopping-cart";
    }

}
