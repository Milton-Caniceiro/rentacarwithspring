package academyMindswapRentacar.dto;

import academyMindswapRentacar.model.Car;
import academyMindswapRentacar.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalCreateDto {

    @NotNull(message = "Must have a rental date")
    private Date rental_pickup;
    @NotNull(message = "Must have a delivery date")
    private Date rental_delivery;
    @NotNull(message = "Must have a user ID")
    private User userID;
    @NotNull(message = "Must have a car ID")
    private Car cardID;

}
