package academyMindswapRentacar.service;

import academyMindswapRentacar.controller.RentalController;
import academyMindswapRentacar.converter.RentalConverter;
import academyMindswapRentacar.dto.RentalDto;
import academyMindswapRentacar.model.Car;
import academyMindswapRentacar.model.Rental;
import academyMindswapRentacar.model.User;
import academyMindswapRentacar.repository.CarRepository;
import academyMindswapRentacar.repository.RentalRepository;
import academyMindswapRentacar.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RentalServiceImpl implements RentalService{

    private RentalRepository rentalRepository;
    private RentalConverter rentalConverter;
    private RentalController rentalController;
    private UserRepository userRepository;
    private CarRepository carRepository;
    public RentalServiceImpl(RentalRepository rentalRepository, RentalConverter rentalConverter, UserRepository userRepository, CarRepository carRepository){

        this.rentalRepository = rentalRepository;
        this.rentalConverter = rentalConverter;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public RentalDto createRental(RentalDto rentalDto) {
        Car carToRent = carRepository.getReferenceById(rentalDto.getCarID());
        User userWhoRents = userRepository.getReferenceById(rentalDto.getUserID());
        Rental rental = rentalConverter.fromRentalDtoToRentalEntity(rentalDto);

        rental.setCarID(carToRent);
        rental.setUserID(userWhoRents);

        rentalRepository.save(rental);

        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public RentalDto getRentalById(Long rentalId) {
        Rental rental = rentalRepository.getReferenceById(rentalId);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public List<RentalDto> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        List<RentalDto> rentalDto = rentals.parallelStream()
                .map(rentalConverter::fromRentalEntityToRentalDto)
                .toList();
        return rentalDto;
    }

    @Override
    public RentalDto updateRental(Long id, RentalDto rentalDto) {
        Rental existingRental = rentalRepository.getReferenceById(id);
        if(existingRental == null){
            throw new IllegalArgumentException("User not found");
        }
        existingRental.setRental_pickup(rentalDto.getRental_pickup());
        existingRental.setRental_delivery(rentalDto.getRental_delivery());
        //existingRental.setUserID(rentalDto.getUserID());
        //existingRental.setCarID(rentalDto.getCarID());
        Rental updateRental = rentalRepository.save(existingRental);
        return rentalConverter.fromRentalEntityToRentalDto(updateRental);
    }

    @Override
    public void deleteRental(Long id) {
        Rental rental = rentalRepository.getReferenceById(id);
        if (rental == null){
            throw new IllegalArgumentException("Rental not found");
        }
        rentalRepository.delete(rental);
    }
}
