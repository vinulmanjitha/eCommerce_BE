package eCommerce.eCommerce.services;


import eCommerce.eCommerce.dtos.CustomerDetailsDto;
import eCommerce.eCommerce.models.CustomerDetails;
import eCommerce.eCommerce.repositories.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

   @Autowired
   private CustomerDetailsRepository repository;

    @Override
    public CustomerDetails save(CustomerDetailsDto dto) {
        CustomerDetails customer = new CustomerDetails();
        customer.setFirstName(dto.firstName());
        customer.setLastName(dto.lastName());
        customer.setCity(dto.city());
        customer.setCountry(dto.country());
        customer.setPhone(dto.phone());
        customer.setPostalCode(dto.postalCode());
        customer.setState(dto.state());
        customer.setAddress(dto.address());
        customer.setEmail(dto.email());
        CustomerDetails saved = repository.save(customer);
        return toDto(saved);
    }

    public List<CustomerDetails> getAll() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDetails getById(Long id) {
        CustomerDetails customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return toDto(customer);
    }

    private CustomerDetails toDto(CustomerDetails c) {
        return new CustomerDetails(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone(),
                c.getAddress(),
                c.getCity(),
                c.getState(),
                c.getPostalCode(),
                c.getCountry()
        );
    }
}
