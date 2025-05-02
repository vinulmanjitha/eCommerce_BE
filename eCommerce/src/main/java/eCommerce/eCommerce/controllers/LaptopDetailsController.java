package eCommerce.eCommerce.controllers;


import eCommerce.eCommerce.dtos.LaptopDetailsDto;
import eCommerce.eCommerce.models.LaptopDetails;
import eCommerce.eCommerce.services.LaptopDetailsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/laptops")
@RestController
public class LaptopDetailsController {

    @Autowired
    private LaptopDetailsService laptopDetailsService;

    @PostMapping
    public ResponseEntity<LaptopDetails> save(@Valid @RequestBody LaptopDetailsDto request) {

        log.info("ACTION START CONTROLLER_LAYER save {}", request);
        LaptopDetails response = laptopDetailsService.save(request);
        log.info("ACTION END CONTROLLER_LAYER save {}", response);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<LaptopDetails>> getAll() {

        log.info("ACTION START CONTROLLER_LAYER getAll ");
        List<LaptopDetails> response = laptopDetailsService.getAll();
        log.info("ACTION START CONTROLLER_LAYER getAll ");
        return ResponseEntity.ok(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<LaptopDetails> getById(@PathVariable Long id) {

        log.info("ACTION START CONTROLLER_LAYER getById :{}",id);
        LaptopDetails response = laptopDetailsService.getById(id);
        log.info("ACTION START CONTROLLER_LAYER getById :{}",response);
        return ResponseEntity.ok(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        log.info("ACTION CONTROLLER_LAYER delete: {}",id);
        Void response=laptopDetailsService.delete(id);
        log.info("ACTION CONTROLLER_LAYER delete: {}",id);
        return ResponseEntity.ok(response);

    }
}
