package bt1.web_ban_giay.service;

import bt1.web_ban_giay.dto.response.CartDTO;
import bt1.web_ban_giay.dto.response.ProductDTO;
import bt1.web_ban_giay.entity.Cart;
import bt1.web_ban_giay.mapper.CartMapper;
import bt1.web_ban_giay.repository.CartRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepsitory cartRepsitory;
    public List<CartDTO> getCart(Long id){
        return toDTO(cartRepsitory.findByUserId(id));
    }
    public int getNumberCart(Long id){
        return cartRepsitory.getCart(id);
    }
    public Cart addToCart(Cart cart){
        return cartRepsitory.save(cart);
    }
    public List<CartDTO> toDTO(List<Cart> cartList){
        List<CartDTO> res=cartList.stream().map(item->new CartDTO(
                item.getId(),
                item.getSize(),
                item.getQuantity(),
                new ProductDTO(item.getProduct().getId(),item.getProduct().getName(),item.getProduct().getPrice(),item.getProduct().getImage_url(),item.getProduct().getDescription())
        )).toList();
        return res;
    }

}
