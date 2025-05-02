package eCommerce.eCommerce.services;

import eCommerce.eCommerce.dtos.LaptopDetailsDto;
import eCommerce.eCommerce.models.LaptopDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaptopDetailsService {


    LaptopDetails save(LaptopDetailsDto request);
    List<LaptopDetails> getAll();
    LaptopDetails getById(Long id);
    Void delete(Long id);
}
