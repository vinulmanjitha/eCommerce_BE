package eCommerce.eCommerce.services.Implementations;

import eCommerce.eCommerce.dtos.OrderItemDto;
import eCommerce.eCommerce.dtos.PurchaseItemsDto;
import eCommerce.eCommerce.models.LaptopDetails;
import eCommerce.eCommerce.models.OrderItem;
import eCommerce.eCommerce.repositories.LaptopDetailsRepository;
import eCommerce.eCommerce.repositories.OrderRepository;
import eCommerce.eCommerce.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final LaptopDetailsRepository laptopDetailsRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(LaptopDetailsRepository laptopDetailsRepository, OrderRepository orderRepository) {
        this.laptopDetailsRepository = laptopDetailsRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderItem saveOrder(OrderItemDto request) {
        log.info("ACTION START SERVICE_LAYER saveOrder: {}", request);
        for (PurchaseItemsDto item : request.items()) {
            if (item.laptopId() == null || item.laptopId() <= 0) {
                throw new IllegalArgumentException("Laptop ID must be provided and greater than 0");
            }
            LaptopDetails laptop = laptopDetailsRepository.findById(item.laptopId())
                    .orElseThrow(() -> new RuntimeException("Laptop does not exist with ID: " + item.laptopId()));
            if (item.quantity() == null || item.quantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }
            int laptopsLeft = laptop.getQuantity() - item.quantity();
            if (laptopsLeft < 0) {
                throw new RuntimeException("Requested quantity (" + item.quantity() + ") exceeds available stock (" + laptop.getQuantity() + ")");
            }
            if (laptopsLeft == 0) {
                laptopDetailsRepository.delete(laptop);
                log.info("Laptop ID {} removed from stock (now out of stock)", laptop.getId());
            } else {
                laptop.setQuantity(laptopsLeft);
                laptopDetailsRepository.save(laptop);
                log.info("Laptop ID {} stock updated. Remaining: {}", laptop.getId(), laptopsLeft);
            }
            OrderItem orderItem = OrderItem.builder()
                    .customerId(request.customerId())
                    .quantity(item.quantity())
                    .laptopId(item.laptopId())
                    .build();

            OrderItem savedOrder = orderRepository.save(orderItem);
            log.info("ACTION END SERVICE_LAYER saveOrder: {}", savedOrder);

        }
        return null;
    }

}
