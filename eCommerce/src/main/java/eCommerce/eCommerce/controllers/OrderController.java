package eCommerce.eCommerce.controllers;

import eCommerce.eCommerce.dtos.OrderItemDto;
import eCommerce.eCommerce.models.OrderItem;
import eCommerce.eCommerce.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderItem> saveOrder(@RequestBody OrderItemDto request) {

        log.info("ACTION CONTROLLER_LAYER: {}", request);
        OrderItem response = orderService.saveOrder(request);
        log.info("ACTION CONTROLLER_LAYER: {}", response);
        return ResponseEntity.ok(response);

    }
}
