//package pl.sdacademy.shoppingcart;
//
//import org.springframework.stereotype.Service;
//import pl.sdacademy.product.Product;
//import pl.sdacademy.product.ProductRepositoryJPA;
//import pl.sdacademy.user.User;
//
//import java.util.List;
//
//@Service
//public class ShoppingCartService {
//    private CartItemRepository cartItemRepository;
//    private ProductRepositoryJPA productRepositoryJPA;
//
//    public ShoppingCartService(CartItemRepository cartItemRepository, ProductRepositoryJPA productRepositoryJPA) {
//        this.cartItemRepository = cartItemRepository;
//        this.productRepositoryJPA = productRepositoryJPA;
//    }
//
//    public List<CartItem> getAllItems(User user){
//        return cartItemRepository.findByUser(user);
//    }
//
//
//}
