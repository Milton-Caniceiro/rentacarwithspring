package academyMindswapRentacar.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarCreateDto {


    @NotBlank(message = "Must have brand")
    private String brand;
    @NotBlank(message = "Must have model")
    private String model;
    @NotNull(message = "Mus have a price")
    private Integer price;
    @NotBlank(message = "Must have a plate")
    private String license_plate;

}
