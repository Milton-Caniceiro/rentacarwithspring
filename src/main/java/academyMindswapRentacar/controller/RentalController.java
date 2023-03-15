package academyMindswapRentacar.controller;

import academyMindswapRentacar.dto.RentalDto;
import academyMindswapRentacar.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private RentalService rentalService;
    private RentalController(RentalService rentalService){

        this.rentalService = rentalService;
    }
    @GetMapping("")
    public ResponseEntity<List<RentalDto>> myFirstEndPoint(){
        List<RentalDto> rentals = rentalService.getAllRentals();
        return  new ResponseEntity<>(rentals, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getById(@PathVariable Long id){
        RentalDto rental = rentalService.getRentalById(id);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RentalDto> createRental( @Valid @RequestBody RentalDto rental, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(System.out::println);
            //throw new IllegalArgumentException("Invalid user");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        RentalDto savedRental = rentalService.createRental(rental);
        return new ResponseEntity<>(savedRental, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RentalDto> updateRental(@PathVariable Long id, @Valid @RequestBody RentalDto rentalDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(System.out::println);
            //throw new IllegalArgumentException("Invalid user");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RentalDto savedRental = rentalService.updateRental(id, rentalDto);
        return new ResponseEntity<>(savedRental, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(Long id){
        rentalService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
