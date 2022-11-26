package com.libray2.libproject.convertor;

import com.libray2.libproject.Entity.Author;
import com.libray2.libproject.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorConvertor {
    public AuthorDto toAuthorDto(Author author){
        AuthorDto authordto=new AuthorDto();
        authordto.setName(author.getName());
        authordto.setAddress(author.getAddress());
        return authordto;
    }
}
