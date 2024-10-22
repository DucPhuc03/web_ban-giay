package bt1.web_ban_giay.dto.request;

import bt1.web_ban_giay.entity.OrderDetail;
import bt1.web_ban_giay.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReqOrderDTO {
    private LocalDate orderDate;
    private double total;
    private String status;
    private List<OrderDetail> orderDetails;
    private User user;
}
