package pl.sdacademy.shoppingcart;

import org.springframework.stereotype.Service;
import pl.sdacademy.user.User;

import java.util.List;

@Service
public class ShoppingCartService {
    private CartItemRepository cartItemRepository;

    public ShoppingCartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAllItems(User user){
        return cartItemRepository.findAllByUser(user);
    }
}
