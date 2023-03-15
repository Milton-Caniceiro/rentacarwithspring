package academyMindswapRentacar.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {
    @NotNull(message = "Must have a id")
    private Long id;
    @NotNull(message = "Must have a rental date")
    private Date rental_pickup;
    @NotNull(message = "Must have a delivery date")
    private Date rental_delivery;
    @NotNull(message = "Must have a user ID")
    private Long userID;
    @NotNull(message = "Must have a car ID")
    private Long carID;

}
