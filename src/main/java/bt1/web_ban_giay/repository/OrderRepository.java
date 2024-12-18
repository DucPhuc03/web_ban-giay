package bt1.web_ban_giay.repository;

import bt1.web_ban_giay.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order> {

    List<Order> findAllByUserId(Long id);

}
