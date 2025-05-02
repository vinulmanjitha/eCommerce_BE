package eCommerce.eCommerce.services;

import eCommerce.eCommerce.dtos.OrderItemDto;
import eCommerce.eCommerce.models.OrderItem;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {


    OrderItem saveOrder(OrderItemDto request);
}
