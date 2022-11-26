package com.libray2.libproject.convertor;

import com.libray2.libproject.Entity.User;
import com.libray2.libproject.dto.UserDto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDtoConvertor {
    public UserDto toUserConvertor(User user){
        UserDto userDto =new UserDto();
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
}
