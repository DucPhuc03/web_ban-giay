package bt1.web_ban_giay.dto.response;
import bt1.web_ban_giay.entity.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private String image_url;
    private String description;
    private int size;
}
