package academyMindswapRentacar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue
    private Long id;
   /* @Column
    private int client_id;
    @Column
    private int car_id;*/
    @Column
    private Date rental_pickup;
    @Column
    private Date rental_delivery;
    @OneToOne (targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User userID;
    @OneToOne (targetEntity = Car.class)
    @JoinColumn(name ="car_id")
    private Car carID;



}
