package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.dto.response.ProductDTO;
import bt1.web_ban_giay.dto.response.ResPageDTO;
import bt1.web_ban_giay.entity.Product;
import bt1.web_ban_giay.service.ProductService;
import com.turkraft.springfilter.boot.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }
    @GetMapping("/product/get")
    public ResponseEntity<ResPageDTO> getAllProduct(@Filter Specification<Product> spec, Pageable pageable){
        return ResponseEntity.ok(productService.getALlProduct(spec,pageable));
    }
    @GetMapping("/product/get/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
