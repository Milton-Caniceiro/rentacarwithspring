package academyMindswapRentacar.controller;

import academyMindswapRentacar.dto.UserCreateDto;
import academyMindswapRentacar.dto.UserDto;
import academyMindswapRentacar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")
public class UserController {
    private UserService userService;
    private UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<List<UserDto>> myFirstEndPoint(){
        List<UserDto> users = userService.getAllUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(System.out::println);
            //throw new IllegalArgumentException("Invalid user");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto){
        UserDto savedUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
