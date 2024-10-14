package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.entity.Cart;
import bt1.web_ban_giay.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart/get")
    public ResponseEntity<List<Cart>> getCart(){
        return ResponseEntity.ok(cartService.getCart());
    }
}
