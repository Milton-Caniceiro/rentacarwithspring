package academyMindswapRentacar.service;

import academyMindswapRentacar.dto.CarCreateDto;
import academyMindswapRentacar.dto.CarDto;


import java.util.List;

public interface CarService {
    CarDto createCar(CarCreateDto carDto);

    CarDto getCarById(Long carId);

    List<CarDto> getAllCars();

    CarDto updateCar(Long id, CarDto carDto);

    void deleteCar(Long id);
}
