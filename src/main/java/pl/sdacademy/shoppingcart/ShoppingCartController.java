package pl.sdacademy.shoppingcart;

import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.product.Product;
import pl.sdacademy.product.ProductRepositoryJPA;
import pl.sdacademy.user.User;
import pl.sdacademy.user.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String getAllItems(Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        user = userRepository.findById(user.getId())
                .orElseThrow();
        Hibernate.initialize(user.getShoppingCart().getCartItems());
        model.addAttribute("cartItems", user.getShoppingCart().getCartItems());
        return "shopping-cart/shopping-cart";
    }


    @PostMapping("/add")
    public String addItem(@ModelAttribute("productId") Product product, @RequestParam Integer quantity) {
        productRepositoryJPA.findById(product.getId());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        user = userRepository.getById(user.getId());
        List<CartItem> items = user.getShoppingCart().getCartItems();
        Optional<CartItem> optionalCartItem = items.stream()
                .filter(ci -> ci.getProduct().equals(product))
                .findFirst();
        if (optionalCartItem.isPresent()) {
            optionalCartItem.get().setQuantity(optionalCartItem.get().getQuantity() + quantity);
        } else {
            user.getShoppingCart().getCartItems().add(new CartItem(product, quantity));
        }
        userRepository.save(user);


        return "redirect:/shopping-cart";
    }

}
