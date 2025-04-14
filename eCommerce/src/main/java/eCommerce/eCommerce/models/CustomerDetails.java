package eCommerce.eCommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_DETAILS_SEQ")
    @SequenceGenerator(name = "CUSTOMER_DETAILS_SEQ", sequenceName = "CUSTOMER_DETAILS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private long id;

    @NotBlank(message = "First Name shouldn't be empty")
    @Column(name = "FIRST_NAME")
    private String firstName;


    @NotBlank(message = "Last Name shouldn't be empty")
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Size(min = 10, message = "Phone number should have at least 10 numbers")
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "COUNTRY")
    private String country;

}
