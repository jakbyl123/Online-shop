package pl.sdacademy.shoppingcart;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.product.Product;
import pl.sdacademy.product.ProductRepositoryJPA;
import pl.sdacademy.user.User;
import pl.sdacademy.user.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private ProductRepositoryJPA productRepositoryJPA;
    private UserRepository userRepository;

    public ShoppingCartController(ProductRepositoryJPA productRepositoryJPA, UserRepository userRepository) {
        this.productRepositoryJPA = productRepositoryJPA;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getAllItems() {
        return "shopping-cart/shopping-cart";
    }


    @PostMapping("/add")
    public String addItem(@ModelAttribute("productId")Product product) {
        productRepositoryJPA.findById(product.getId());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        user = userRepository.getById(user.getId());
        user.getShoppingCart().getCartItems().add(new CartItem(product, 1));
        userRepository.save(user);



        return "redirect:/shopping-cart";
    }

}
