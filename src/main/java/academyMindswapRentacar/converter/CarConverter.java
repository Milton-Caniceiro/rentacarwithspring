package academyMindswapRentacar.converter;

import academyMindswapRentacar.dto.CarCreateDto;
import academyMindswapRentacar.dto.CarDto;
import academyMindswapRentacar.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    @Autowired
    ObjectMapper objectMapper;
    public CarDto fromCarEntityToCarDto(Car car){
        return CarDto.builder()
                .model(car.getModel())
                .brand(car.getBrand())
                .price(car.getPrice())
                .license_plate(car.getLicense_plate())
                .build();
    }
    public Car fromCarDtoToCarEntity(CarDto carDto){
        return objectMapper.convertValue(carDto, Car.class);
    }

    public Car fromCarCreateDtoToEntity (CarCreateDto carDto){
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .price(carDto.getPrice())
                .license_plate(carDto.getLicense_plate())
                .build();
    }
}
