package eCommerce.eCommerce.services.Implementations;

import eCommerce.eCommerce.dtos.LaptopDetailsDto;
import eCommerce.eCommerce.models.LaptopDetails;
import eCommerce.eCommerce.repositories.LaptopDetailsRepository;
import eCommerce.eCommerce.services.LaptopDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LaptopDetailsServiceImpl implements LaptopDetailsService {
    @Autowired
    private LaptopDetailsRepository repository;

    @Override
    public LaptopDetails save(LaptopDetailsDto request) {

        log.info("ACTION START SERVICE_LAYER save :{} ", request);
        LaptopDetails laptopDetails = LaptopDetails.builder()
                .brand(request.brand())
                .model(request.model())
                .processor(request.processor())
                .ramSize(request.ramSize())
                .storageSize(request.storageSize())
                .storageType(request.storageType())
                .price(request.price())
                .available(request.available())
                .quantity(request.quantity())
                .ramSize(request.ramSize())
                .build();
        LaptopDetails saved = repository.save(laptopDetails);
        log.info("ACTION END SERVICE_LAYER save ");

        return saved;
    }

    @Override
    public List<LaptopDetails> getAll() {
        log.info("ACTION START SERVICE_LAYER getAll ");
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LaptopDetails getById(Long id) {
        log.info("ACTION START SERVICE_LAYER getById {} ", id);
        LaptopDetails laptop = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop not found"));
        return toDto(laptop);
    }

    @Override
    public Void delete(Long id) {
        LaptopDetails laptopDetails = getById(id);
        repository.delete(laptopDetails);
        return null;
    }


    private LaptopDetails toDto(LaptopDetails c) {

        log.info("ACTION START SERVICE_LAYER toDto ");
        return new LaptopDetails(
                c.getId(),
                c.getBrand(),
                c.getModel(),
                c.getProcessor(),
                c.getRamSize(),
                c.getStorageSize(),
                c.getStorageType(),
                c.getPrice(),
                c.isAvailable(),
                c.getQuantity()
        );
    }

}
