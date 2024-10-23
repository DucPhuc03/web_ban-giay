package bt1.web_ban_giay.service;

import bt1.web_ban_giay.dto.request.OrderDetailDTO;
import bt1.web_ban_giay.dto.request.ReqOrderDTO;
import bt1.web_ban_giay.dto.response.ResOrderDTO;
import bt1.web_ban_giay.entity.Order;
import bt1.web_ban_giay.entity.OrderDetail;
import bt1.web_ban_giay.entity.Product;
import bt1.web_ban_giay.mapper.OrderMapper;
import bt1.web_ban_giay.mapper.ProductMapper;
import bt1.web_ban_giay.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductMapper productMapper;

    public Order createOrder(ReqOrderDTO orderDTO){
        Order order=new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotal(orderDTO.getTotal());
        order.setStatus(orderDTO.getStatus());
        order.setUser(orderDTO.getUser());
        List<OrderDetail> orderDetails = orderDTO.getOrderDetails().stream()
                .map(orderDetailDTO -> {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setQuantity(orderDetailDTO.getQuantity());
                    orderDetail.setSize(orderDetailDTO.getSize()); // Thiết lập kích thước nếu cần
                    // Thiết lập sản phẩm
                    orderDetail.setProduct(orderDetailDTO.getProduct());
                    // Thiết lập mối quan hệ ngược lại
                    orderDetail.setOrder(order); // Thiết lập order cho orderDetail
                    return orderDetail; // Trả về OrderDetail sau khi thiết lập
                })
                .collect(Collectors.toList()); // Thu thập các OrderDetail vào danh sách
        order.setOrderDetails(orderDetails);
        return orderRepository.save(order);
    }

    public List<ResOrderDTO> getOrder(Long id){
        List<Order> orderList=orderRepository.findAllByUserId(id);
        List<ResOrderDTO> res=orderList.stream().map(item->new ResOrderDTO(
                item.getId(),
                item.getOrderDate(),
                item.getTotal(),
                item.getStatus(),
                convertToOrderDetail(item.getOrderDetails())
        )).toList();
    return res;
    }

    public ResOrderDTO updateOrder(Long id){
        Optional<Order> order=orderRepository.findById(id);

        order.get().setStatus("da thanh toan");
        Order currentOrder= orderRepository.save(order.get());
        ResOrderDTO res= new ResOrderDTO(
                currentOrder.getId(),
                currentOrder.getOrderDate(),
                currentOrder.getTotal(),
                currentOrder.getStatus(),
                convertToOrderDetail(currentOrder.getOrderDetails())
        );
        return res;
    }
    public List<OrderDetailDTO> convertToOrderDetail(List<OrderDetail> orderDetails){

        List<OrderDetailDTO> res= orderDetails.stream().map(item->new OrderDetailDTO(
                item.getQuantity(),
                item.getSize(),
                productMapper.tDto(item.getProduct())
        )).toList();
        return res;
    }
}
