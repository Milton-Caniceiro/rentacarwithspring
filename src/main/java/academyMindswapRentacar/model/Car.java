package academyMindswapRentacar.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private  String model;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false, unique = true)
    private String license_plate;
}
