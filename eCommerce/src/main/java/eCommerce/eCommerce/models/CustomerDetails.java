package eCommerce.eCommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_DETAILS_SEQ")
    @SequenceGenerator(name = "CUSTOMER_DETAILS_SEQ", sequenceName = "CUSTOMER_DETAILS_SEQ", allocationSize = 1)
    @Column(name="ID")
    private long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="POSTAL_CODE")
    private String postalCode;

    @Column(name="COUNTRY")
    private String country;

}
