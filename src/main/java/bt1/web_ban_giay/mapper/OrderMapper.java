package bt1.web_ban_giay.mapper;

import bt1.web_ban_giay.dto.request.OrderDetailDTO;
import bt1.web_ban_giay.dto.request.ReqOrderDTO;
import bt1.web_ban_giay.entity.Order;
import bt1.web_ban_giay.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
//    @Mapping(source = "userId",target = "user.id")
//    Order toOrder(ReqOrderDTO orderDTO);
//    @Mapping(source = "productId",target = "product.id")
//    OrderDetail toOrderDetail(OrderDetailDTO orderDetailDTO);
}
