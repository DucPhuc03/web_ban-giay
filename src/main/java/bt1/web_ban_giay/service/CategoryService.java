package bt1.web_ban_giay.service;

import bt1.web_ban_giay.entity.Category;
import bt1.web_ban_giay.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
}
