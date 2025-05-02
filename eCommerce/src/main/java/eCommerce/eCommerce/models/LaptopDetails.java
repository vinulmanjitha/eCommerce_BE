package eCommerce.eCommerce.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "LAPTOP_DETAILS")

public class LaptopDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LAPTOP_DETAILS_SEQ")
    @SequenceGenerator(name = "LAPTOP_DETAILS_SEQ", sequenceName = "LAPTOP_DETAILS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "PROCESSOR", nullable = false)
    private String processor;

    @Column(name = "RAM_SIZE", nullable = false)
    private int ramSize;

    @Column(name = "STORAGE_SIZE", nullable = false)
    private int storageSize;

    @Column(name = "STORAGE_TYPE", nullable = false)
    private String storageType;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "AVAILABLE")
    private boolean available;

    @Column(name = "QUANTITY")
    private int quantity;
}
