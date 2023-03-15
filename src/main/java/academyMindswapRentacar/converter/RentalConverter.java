package academyMindswapRentacar.converter;

import academyMindswapRentacar.dto.RentalDto;
import academyMindswapRentacar.model.Rental;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Component;

@Component
public class RentalConverter {
    @Transient
    public RentalDto fromRentalEntityToRentalDto(Rental rental){
        return RentalDto.builder()
                .rental_pickup(rental.getRental_pickup())
                .rental_delivery(rental.getRental_delivery())
                .userID(rental.getUserID().getId())
                .carID(rental.getCarID().getId())
                .build();
    }

    public Rental fromRentalDtoToRentalEntity(RentalDto rentalDto){
        return Rental.builder()
                .id(rentalDto.getId())
                .rental_pickup(rentalDto.getRental_pickup())
                .rental_delivery(rentalDto.getRental_delivery())
                .build();

    }
}

