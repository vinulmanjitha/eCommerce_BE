package eCommerce.eCommerce.services.Implementations;

import eCommerce.eCommerce.models.Cart;
import eCommerce.eCommerce.models.CartItem;
import eCommerce.eCommerce.models.CustomerDetails;
import eCommerce.eCommerce.models.LaptopDetails;
import eCommerce.eCommerce.repositories.CartItemRepository;
import eCommerce.eCommerce.repositories.CartRepository;
import eCommerce.eCommerce.repositories.CustomerDetailsRepository;
import eCommerce.eCommerce.repositories.LaptopDetailsRepository;
import eCommerce.eCommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private LaptopDetailsRepository laptopDetailsRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public Cart createCart(Long customerId) {
        CustomerDetails customer = customerDetailsRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer does not exist"));
        Cart cart = Cart.builder()
                .totalPrice(0)
                .build();
        cartRepository.save(cart);
        return null;
    }

    @Override
    public Cart addItemToCart(Long cartId, Long laptopId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart does not exist"));

        LaptopDetails laptopDetails = laptopDetailsRepository.findById(laptopId)
                .orElseThrow(() -> new RuntimeException("Laptop not found"));

        if (laptopDetails.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        laptopDetails.setQuantity(laptopDetails.getQuantity() - quantity);
        laptopDetailsRepository.save(laptopDetails);

        CartItem cartItem = CartItem.builder()
                .quantity(quantity)
                .laptopDetails(laptopDetails)
                .cartItemPrice((int) (laptopDetails.getPrice() * quantity))
                .cart(cart)
                .build();

        cart.getCartItems().add(cartItem);
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getCartItemPrice());

        return cartRepository.save(cart);
    }


    @Override
    public Cart removeItemFromCart(Long cartId, Long cartItemId) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart does not exist"));
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart item does not exist"));
        cart.setTotalPrice(cart.getTotalPrice() - cartItem.getCartItemPrice());
        cart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateItemQuantity(Long cartId, Long cartItemId, int newQuantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart does not exist"));
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart Item does not exist"));
        Integer prevCartItemPrice = cartItem.getCartItemPrice();
        cartItem.setQuantity(newQuantity);
        cartItem.setCartItemPrice(cartItem.getCartItemPrice() * newQuantity);
        Integer newCartItemPrice = cartItem.getCartItemPrice();
        if (prevCartItemPrice > newCartItemPrice) {
            cart.setTotalPrice(cart.getTotalPrice() - (prevCartItemPrice - newCartItemPrice));
        } else if (newCartItemPrice > prevCartItemPrice) {
            cart.setTotalPrice(cart.getTotalPrice() + (newCartItemPrice - prevCartItemPrice));
        }
        cartItemRepository.save(cartItem);
        cartRepository.save(cart);

        return cart;
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart does not exist"));
    }

    @Override
    public void clearCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart does not exist"));

        for (CartItem item : cart.getCartItems()) {
            cartItemRepository.delete(item);
        }

        cart.getCartItems().clear();
        cart.setTotalPrice(0);

        cartRepository.save(cart);
    }
}

