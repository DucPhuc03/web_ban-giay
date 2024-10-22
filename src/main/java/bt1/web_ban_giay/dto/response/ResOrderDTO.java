package bt1.web_ban_giay.dto.response;

import bt1.web_ban_giay.dto.request.OrderDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ResOrderDTO {
    private Long id;
    private LocalDate orderDate;
    private double total;
    private String status;
    private List<OrderDetailDTO> orderDetails;
}
