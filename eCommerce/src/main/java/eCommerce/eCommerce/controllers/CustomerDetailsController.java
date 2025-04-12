package eCommerce.eCommerce.controllers;

import eCommerce.eCommerce.dtos.CustomerDetailsDto;
import eCommerce.eCommerce.models.CustomerDetails;
import eCommerce.eCommerce.services.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerDetailsController {
    @Autowired
    private CustomerDetailsService CustomerDetailsService;

    @PostMapping
    public ResponseEntity<CustomerDetails> create(@RequestBody CustomerDetailsDto details) {
        return ResponseEntity.ok(CustomerDetailsService.save(details));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getAll() {
        return ResponseEntity.ok(CustomerDetailsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetails> getById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomerDetailsService.getById(id));
    }
}
