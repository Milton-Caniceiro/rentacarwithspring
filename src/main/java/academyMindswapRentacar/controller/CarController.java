package academyMindswapRentacar.controller;

import academyMindswapRentacar.dto.CarCreateDto;
import academyMindswapRentacar.dto.CarDto;
import academyMindswapRentacar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarService carService;
    private CarController(CarService carService){
        this.carService = carService;
    }
    @GetMapping("")
    public ResponseEntity<List<CarDto>> myFirstEndPoint(){
        List<CarDto> cars = carService.getAllCars();
        return  new ResponseEntity<>(cars, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable Long id) {
        CarDto car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarCreateDto car){
        CarDto savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateUser(@PathVariable Long id, @Valid @RequestBody CarDto carDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(System.out::println);
            //throw new IllegalArgumentException("Invalid user");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CarDto savedCar = carService.updateCar(id, carDto);
        return new ResponseEntity<>(savedCar, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
