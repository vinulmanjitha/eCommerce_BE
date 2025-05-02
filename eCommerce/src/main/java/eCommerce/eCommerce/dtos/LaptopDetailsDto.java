package eCommerce.eCommerce.dtos;

public record LaptopDetailsDto(
        Long id,
        String brand,
        String model,
        String processor,
        int ramSize,
        int storageSize,
        String storageType,
        double price,
        boolean available,
        int quantity
) {
}
