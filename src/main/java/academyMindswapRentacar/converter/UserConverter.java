package academyMindswapRentacar.converter;

import academyMindswapRentacar.dto.UserCreateDto;
import academyMindswapRentacar.dto.UserDto;
import academyMindswapRentacar.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    ObjectMapper objectMapper;
    public UserDto fromUserEntityToUserDto(User user){
       return UserDto.builder()
               .firstName(user.getFirstName())
               .lastName(user.getLastName())
               .email(user.getEmail())
               .role(user.getRole())
               .build();
    }
    public User fromUserDtoToUserEntity(UserDto userDto){

        return objectMapper.convertValue(userDto, User.class);
    }

    public User fromUserCreateDtoToEntity (UserCreateDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();
    }

}
