package bt1.web_ban_giay.service;

import bt1.web_ban_giay.dto.response.MetaDTO;
import bt1.web_ban_giay.dto.response.ProductDTO;
import bt1.web_ban_giay.dto.response.ResPageDTO;
import bt1.web_ban_giay.entity.Product;
import bt1.web_ban_giay.exception.InvalidException;
import bt1.web_ban_giay.mapper.ProductMapper;
import bt1.web_ban_giay.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductRepository productRepository;
    public Product createProduct(Product product){
        Boolean checkPro=productRepository.existsByName(product.getName());
        if(checkPro){
            throw new InvalidException("san pham da ton tai");
        }
        return productRepository.save(product);
    }
    public ResPageDTO getALlProduct(Specification<Product> spec, Pageable pageable){
        ResPageDTO res=new ResPageDTO();
        Page<Product> productPage=productRepository.findAll(spec,pageable);
        MetaDTO mt=new MetaDTO();
        mt.setPage(pageable.getPageNumber()+1);
        mt.setPageSize(pageable.getPageSize());
        mt.setPages(productPage.getTotalPages());
        mt.setTotal(productPage.getTotalElements());
        res.setMeta(mt);
        res.setResult(productMapper.tDtoList(productPage.getContent()));
        return res;
    }
    public ProductDTO getProductById(Long id){
        Optional<Product> optional=productRepository.findById(id);
        Product res=optional.get();
        ProductDTO a= productMapper.tDto(res);
        return a;
    }
}
