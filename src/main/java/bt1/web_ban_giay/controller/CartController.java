package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.dto.response.CartDTO;
import bt1.web_ban_giay.entity.Cart;
import bt1.web_ban_giay.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart/get/{id}")
    public ResponseEntity<List<CartDTO>> getCart(@PathVariable("id") Long id){
        return ResponseEntity.ok(cartService.getCart(id));
    }
    @GetMapping("/cart/get/number/{id}")
    public ResponseEntity<Integer> getNumber(@PathVariable("id") Long id){
        return ResponseEntity.ok(cartService.getNumberCart(id));
    }
    @PostMapping("/cart/create")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.addToCart(cart));
    }
    @DeleteMapping("/cart/delete/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") Long id){
        cartService.deleteCart(id);
        return ResponseEntity.ok(null);
    }

}
