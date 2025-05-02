package eCommerce.eCommerce.services;

import eCommerce.eCommerce.dtos.CustomerDetailsDto;
import eCommerce.eCommerce.models.Cart;
import eCommerce.eCommerce.models.CustomerDetails;

import java.util.List;

public interface CartService {
    Cart createCart(Long customerId);
    Cart addItemToCart(Long cartId, Long laptopId, int quantity);
    Cart removeItemFromCart(Long cartId, Long cartItemId);
    Cart updateItemQuantity(Long cartId, Long cartItemId, int newQuantity);
    Cart getCartById(Long cartId);
    void clearCart(Long cartId);
}
