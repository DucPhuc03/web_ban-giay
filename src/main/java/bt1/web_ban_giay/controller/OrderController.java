package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.dto.request.ReqOrderDTO;
import bt1.web_ban_giay.dto.response.ResOrderDTO;
import bt1.web_ban_giay.entity.Order;
import bt1.web_ban_giay.service.OrderService;
import com.turkraft.springfilter.boot.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/order/create")
    public ResponseEntity<Order> createOrder(@RequestBody ReqOrderDTO orderDTO){
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/order/get")
    public ResponseEntity<List<ResOrderDTO>> getOrder( @Filter Specification<Order> spec){
        return ResponseEntity.ok(orderService.getOrder(spec));
    }

    @PutMapping("/order/update/{id}")
    public ResponseEntity<ResOrderDTO> updateOrder(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.updateOrder(id));
    }
}
