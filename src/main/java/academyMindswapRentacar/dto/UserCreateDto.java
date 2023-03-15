package academyMindswapRentacar.dto;

import academyMindswapRentacar.model.Role;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotBlank(message = "Must have first name")
    private String firstName;
    @NotBlank(message = "Must have last name")
    private String lastName;
    @NotBlank(message = "Must have email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid")
    private String email;
    @NotBlank(message = "Must have password")
    @Min(value = 8, message = "Password must be at least 8 characters long")
    private String password;
    @NotBlank(message = "Must have password")
    @Min(value = 8, message = "Password must be at least 8 characters long")
    private String retypePassword;
    @NotBlank(message = "Must have role")
    private Role role;
}

