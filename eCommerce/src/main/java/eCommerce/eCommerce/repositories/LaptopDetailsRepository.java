package eCommerce.eCommerce.repositories;

import eCommerce.eCommerce.models.LaptopDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopDetailsRepository extends JpaRepository<LaptopDetails,Long> {

    Optional<LaptopDetails> findByModel(String model);

}
