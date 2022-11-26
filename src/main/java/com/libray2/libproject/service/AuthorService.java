package com.libray2.libproject.service;

import com.libray2.libproject.Entity.Author;
import com.libray2.libproject.Exception.LibraryException;
import com.libray2.libproject.convertor.AuthorConvertor;
import com.libray2.libproject.dto.AuthorDto;
import com.libray2.libproject.external.ErrorCodes;
import com.libray2.libproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorConvertor authorConvertor;

    public AuthorDto saveAuthor(Author author){
        Author author1=authorRepository.save(author);
        AuthorDto authorDto=authorConvertor.toAuthorDto(author1);
        return authorDto;
    }

    public List<AuthorDto> getAllAuthor(){
        List<Author> authorList=authorRepository.findAll();
        List<AuthorDto> authorDtoList=authorList.stream().map(b->authorConvertor.toAuthorDto(b)).collect(Collectors.toList());
        return authorDtoList;
    }
    public AuthorDto getAuthorById(Long id) throws Exception, LibraryException {
        Optional<Author> author1=authorRepository.findById(id);
        if(!author1.isPresent()) {
            throw LibraryException.libraryExceptionImpl(ErrorCodes.AUTHOR_NOT_FOUND);
        }
            return authorConvertor.toAuthorDto(author1.get());
    }

    public String deleteById (Long id) throws Exception,LibraryException{
        Optional<Author> author1=authorRepository.findById(id);
        if(!author1.isPresent()) {
            throw LibraryException.libraryExceptionImpl(ErrorCodes.AUTHOR_NOT_FOUND);
        }
        authorRepository.deleteById(id);
        return "success";
    }

}
