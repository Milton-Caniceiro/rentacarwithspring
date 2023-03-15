package academyMindswapRentacar.service;

import academyMindswapRentacar.converter.CarConverter;
import academyMindswapRentacar.dto.CarCreateDto;
import academyMindswapRentacar.dto.CarDto;
import academyMindswapRentacar.model.Car;
import academyMindswapRentacar.repository.CarRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;
    private CarConverter carConverter;
    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter){

        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    @Override
    public CarDto createCar(CarCreateDto carCreateDto) {
        Car car = carConverter.fromCarCreateDtoToEntity(carCreateDto);
        car = carRepository.save(car);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = carRepository.getReferenceById(id);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDto = cars.parallelStream()
                .map(carConverter::fromCarEntityToCarDto)
                .toList();
        return carDto;
    }
    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Car existingCar = carRepository.getReferenceById(id);
        if(existingCar == null){
            throw new IllegalArgumentException("User not found");
        }
        existingCar.setBrand(carDto.getBrand());
        existingCar.setModel(carDto.getModel());
        existingCar.setPrice(carDto.getPrice());
        existingCar.setLicense_plate(carDto.getLicense_plate());
        Car updateCar = carRepository.save(existingCar);
        return carConverter.fromCarEntityToCarDto(updateCar);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.getReferenceById(id);
        if (car == null){
            throw new IllegalArgumentException("User not found");
        }
        carRepository.delete(car);
    }
    }

