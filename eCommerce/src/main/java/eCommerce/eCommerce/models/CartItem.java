package eCommerce.eCommerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


@Table(name = "CART_ITEM")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_ITEM_SEQ")
    @SequenceGenerator(name = "CART_ITEM_SEQ", sequenceName = "CART_ITEM_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="LAPTOP_ID", nullable = false)
    private LaptopDetails laptopDetails;

    @Column(name = "CART_ITEM_PRICE", nullable = false)
    private Integer cartItemPrice;

    @ManyToOne
    @JoinColumn(name = "CART_ID", nullable = false)
    @JsonBackReference
    private Cart cart;


}
