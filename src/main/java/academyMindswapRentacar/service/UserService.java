package academyMindswapRentacar.service;

import academyMindswapRentacar.dto.UserCreateDto;
import academyMindswapRentacar.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser( UserCreateDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long userId);
}
