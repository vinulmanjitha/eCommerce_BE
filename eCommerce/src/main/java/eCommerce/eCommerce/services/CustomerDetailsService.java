package eCommerce.eCommerce.services;

import eCommerce.eCommerce.dtos.CustomerDetailsDto;
import eCommerce.eCommerce.models.CustomerDetails;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerDetailsService {


    @Transactional
    CustomerDetails save(CustomerDetailsDto dto);

    List<CustomerDetails> getAll();

    CustomerDetails getById(Long id);

    Void delete(Long id);
}
