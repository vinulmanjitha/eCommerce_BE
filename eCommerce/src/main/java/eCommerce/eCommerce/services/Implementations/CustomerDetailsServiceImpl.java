package eCommerce.eCommerce.services.Implementations;


import eCommerce.eCommerce.dtos.CustomerDetailsDto;
import eCommerce.eCommerce.models.CustomerDetails;
import eCommerce.eCommerce.repositories.CustomerDetailsRepository;
import eCommerce.eCommerce.services.CustomerDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository repository;

    @Override
    public CustomerDetails save(CustomerDetailsDto dto) {

        log.info("ACTION START SERVICE_LAYER save ");
        CustomerDetails customer = CustomerDetails.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .city(dto.city())
                .country(dto.country())
                .phone(dto.phone())
                .postalCode(dto.postalCode())
                .state(dto.state())
                .address(dto.address())
                .email(dto.email()).build();
        CustomerDetails saved = repository.save(customer);
        log.info("ACTION END SERVICE_LAYER save ");

        return toDto(saved);
    }

    public List<CustomerDetails> getAll() {

        log.info("ACTION START SERVICE_LAYER getAll ");
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDetails getById(Long id) {

        log.info("ACTION START SERVICE_LAYER getById ");
        CustomerDetails customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return toDto(customer);
    }

    @Override
    public Void delete(Long id){
        CustomerDetails response=getById(id);
        repository.delete(response);
        return null;
    }

    private CustomerDetails toDto(CustomerDetails c) {

        log.info("ACTION START SERVICE_LAYER toDto ");
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
