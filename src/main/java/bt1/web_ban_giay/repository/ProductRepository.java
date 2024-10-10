package bt1.web_ban_giay.repository;

import bt1.web_ban_giay.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {
    Boolean existsByName(String name);
}
