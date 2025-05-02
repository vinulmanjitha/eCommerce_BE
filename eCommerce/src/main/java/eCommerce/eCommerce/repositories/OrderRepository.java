package eCommerce.eCommerce.repositories;

import eCommerce.eCommerce.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderItem,Long> {
}
