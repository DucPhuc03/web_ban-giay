package bt1.web_ban_giay.repository;

import bt1.web_ban_giay.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepsitory extends JpaRepository<Cart,Long> {
    List<Cart> findByUserId(Long id);

    @Query("SELECT COUNT(c) FROM Cart c WHERE c.user.id= :id")
    int getCart(Long id);
}
