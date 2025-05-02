package eCommerce.eCommerce.controllers;

import eCommerce.eCommerce.dtos.CustomerDetailsDto;
import eCommerce.eCommerce.models.CustomerDetails;
import eCommerce.eCommerce.services.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsService CustomerDetailsService;

    @PostMapping
    public ResponseEntity<CustomerDetails> create(@RequestBody @Valid CustomerDetailsDto details) {

        log.info("ACTION START CONTROLLER_LAYER create: {} ", details);
        CustomerDetails response = CustomerDetailsService.save(details);
        log.info("ACTION END CONTROLLER_LAYER create: {} ", details);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getAll() {

        log.info("ACTION START CONTROLLER_LAYER getAll ");
        List<CustomerDetails> response = CustomerDetailsService.getAll();
        log.info("ACTION END CONTROLLER_LAYER getAll {}", response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetails> getById(@PathVariable Long id) {

        log.info("START CONTROLLER_LAYER getById  getById ");
        CustomerDetails response = CustomerDetailsService.getById(id);
        log.info("ACTION END CONTROLLER_LAYER getById {}", response);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        log.info("ACTION CONTROLLER_LAYER delete: {}",id);
        Void response=CustomerDetailsService.delete(id);
        log.info("ACTION CONTROLLER_LAYER delete: {}",id);
        return ResponseEntity.ok(response);

    }
}
