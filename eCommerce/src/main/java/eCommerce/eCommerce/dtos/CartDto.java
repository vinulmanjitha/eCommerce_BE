package eCommerce.eCommerce.dtos;

import java.util.List;

public record CartDto(
        Long id,
        Long customerId,
        List<Long> laptopIds,
        List<Integer> quantities,
        double totalPrice
) {
}
