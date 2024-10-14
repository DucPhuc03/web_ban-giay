package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.entity.Category;
import bt1.web_ban_giay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CategotyController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category/get")
    public ResponseEntity<List<Category>> getCategory(){
        return ResponseEntity.ok(categoryService.getCategory());
    }
}
