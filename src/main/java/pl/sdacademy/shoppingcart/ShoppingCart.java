package pl.sdacademy.shoppingcart;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
@Embeddable
public class ShoppingCart {
    @ElementCollection
    private List<CartItem> cartItems;

    public ShoppingCart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ShoppingCart() {
    }


    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
