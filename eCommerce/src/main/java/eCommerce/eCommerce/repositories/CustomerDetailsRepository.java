package eCommerce.eCommerce.repositories;

import eCommerce.eCommerce.models.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Long> {

}
