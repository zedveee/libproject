package com.libray2.libproject.service;


import com.libray2.libproject.Entity.Author;
import com.libray2.libproject.Entity.User;
import com.libray2.libproject.Exception.LibraryException;
import com.libray2.libproject.convertor.UserDtoConvertor;
import com.libray2.libproject.dto.UserDto;
import com.libray2.libproject.external.ErrorCodes;
import com.libray2.libproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDtoConvertor userDtoConvertor;

    public User getUserById(Long id) throws Exception,LibraryException{
        Optional<User> user=userRepository.findById(id);
        if (!user.isPresent()){
            throw LibraryException.libraryExceptionImpl(ErrorCodes.USER_NOT_FOUND);
        }
        return  user.get();
    }

    public UserDto saveUser(User user){
        System.out.println(user);
        User user1=userRepository.save(user);
        UserDto userDto=userDtoConvertor.toUserConvertor(user1);
        return userDto;
    }

    public List<UserDto> searchUser(User user){
        List<User> userList =userRepository.searchUser(user.getName(),user.getAddress(),user.getPhone());
        List<UserDto> dtoList=userList.stream().map(u->userDtoConvertor.toUserConvertor(u)).collect(Collectors.toList());
        return dtoList;
    }

    public String deleteById (Long id) throws Exception, LibraryException {
        Optional<User> user1=userRepository.findById(id);
        if(!user1.isPresent()) {
            throw LibraryException.libraryExceptionImpl(ErrorCodes.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
        return " delete success";
    }
}
