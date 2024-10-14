package bt1.web_ban_giay.service;

import bt1.web_ban_giay.entity.Cart;
import bt1.web_ban_giay.repository.CartRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepsitory cartRepsitory;
    public List<Cart> getCart(){
        return cartRepsitory.findAll();
    }
}
