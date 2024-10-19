package bt1.web_ban_giay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private  int size;
    private int quantity;
    private ProductDTO product;
}
