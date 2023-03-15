package academyMindswapRentacar.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @NotBlank(message = "Must have last n")
    private String brand;

    @NotBlank(message = "Must have a model")
    private String model;
    @NotNull(message = "Must have a price")
    private Integer price;
    @NotBlank(message = "Must have a plate")
    private String license_plate;
}
