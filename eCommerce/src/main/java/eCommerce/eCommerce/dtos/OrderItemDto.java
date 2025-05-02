package eCommerce.eCommerce.dtos;

import java.util.List;

public record OrderItemDto(
        Long customerId,
        List<PurchaseItemsDto> items
) {
}
