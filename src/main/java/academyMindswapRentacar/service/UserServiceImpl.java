package academyMindswapRentacar.service;

import academyMindswapRentacar.converter.UserConverter;
import academyMindswapRentacar.dto.UserCreateDto;
import academyMindswapRentacar.dto.UserDto;
import academyMindswapRentacar.model.User;
import academyMindswapRentacar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserConverter userConverter;
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter){

        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
       if(!userCreateDto.getPassword().equals(userCreateDto.getRetypePassword())){
           throw new IllegalArgumentException("Passwords do not match");
       }
        User user = userConverter.fromUserCreateDtoToEntity(userCreateDto);
        user = userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.getReferenceById(userId);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = users.parallelStream()
                .map(userConverter::fromUserEntityToUserDto)
                .toList();
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.getReferenceById(id);
        if(existingUser == null){
            throw new IllegalArgumentException("User not found");
        }
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updateUser = userRepository.save(existingUser);
        return userConverter.fromUserEntityToUserDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.getReferenceById(userId);
        if (user == null){
            throw new IllegalArgumentException("User not found");
        }
        userRepository.delete(user);
    }

}
