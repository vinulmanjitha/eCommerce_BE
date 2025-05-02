package eCommerce.eCommerce.controllers;

import eCommerce.eCommerce.models.Cart;
import eCommerce.eCommerce.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Cart> create(@PathVariable Long customerId) {

        log.info("ACTION START CONTROLLER_LAYER create: {} ", customerId);
        Cart response = cartService.createCart(customerId);
        log.info("ACTION END CONTROLLER_LAYER create: {} ", customerId);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{cartId}/add")
    public ResponseEntity<Cart> addItemToCart(
            @PathVariable Long cartId,
            @RequestParam Long laptopId,
            @RequestParam int quantity) {

        log.info("ACTION START CONTROLLER_LAYER addItemToCart - cartId: {}, laptopId: {}, quantity: {}", cartId, laptopId, quantity);
        Cart updatedCart = cartService.addItemToCart(cartId, laptopId, quantity);
        log.info("ACTION END CONTROLLER_LAYER addItemToCart");

        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}/remove/{cartItemId}")
    public ResponseEntity<Cart> removeItemFromCart(
            @PathVariable Long cartId,
            @PathVariable Long cartItemId) {

        log.info("ACTION START CONTROLLER_LAYER removeItemFromCart - cartId: {}, cartItemId: {}", cartId, cartItemId);
        Cart updatedCart = cartService.removeItemFromCart(cartId, cartItemId);
        log.info("ACTION END CONTROLLER_LAYER removeItemFromCart");

        return ResponseEntity.ok(updatedCart);
    }
    @PutMapping("/{cartId}/update")
    public ResponseEntity<Cart> updateItemQuantity(
            @PathVariable Long cartId,
            @RequestParam Long cartItemId,
            @RequestParam int newQuantity) {

        log.info("ACTION START CONTROLLER_LAYER updateItemQuantity - cartId: {}, cartItemId: {}, newQuantity: {}", cartId, cartItemId, newQuantity);
        Cart updatedCart = cartService.updateItemQuantity(cartId, cartItemId, newQuantity);
        log.info("ACTION END CONTROLLER_LAYER updateItemQuantity");

        return ResponseEntity.ok(updatedCart);
    }
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {

        log.info("ACTION START CONTROLLER_LAYER getCartById - cartId: {}", cartId);
        Cart cart = cartService.getCartById(cartId);
        log.info("ACTION END CONTROLLER_LAYER getCartById");

        return ResponseEntity.ok(cart);
    }
    @DeleteMapping("/{cartId}/clear")
    public ResponseEntity<String> clearCart(@PathVariable Long cartId) {
        log.info("ACTION START CONTROLLER_LAYER clearCart - cartId: {}", cartId);

        cartService.clearCart(cartId);

        log.info("ACTION END CONTROLLER_LAYER clearCart - cartId: {}", cartId);
        return ResponseEntity.ok("Cart cleared successfully");
    }




}
