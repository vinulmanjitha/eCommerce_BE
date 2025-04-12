package eCommerce.eCommerce.dtos;

public record CustomerDetailsDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String city,
        String state,
        String postalCode,
        String country
) {
}
