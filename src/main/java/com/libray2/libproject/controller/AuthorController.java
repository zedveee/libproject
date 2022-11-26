package com.libray2.libproject.controller;

import com.libray2.libproject.Entity.Author;
import com.libray2.libproject.dto.AuthorDto;
import com.libray2.libproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;


    @PostMapping
    public AuthorDto saveAuthor(@RequestBody Author author ){
        return authorService.saveAuthor(author);
    }
    @GetMapping("{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) throws Exception {
        return authorService.getAuthorById(id);
    }

    @GetMapping("delete/{id}")
    public String deleteAuthorById(@PathVariable Long id) throws Exception {
        return authorService.deleteById(id);
    }

    @GetMapping
    public List<AuthorDto> getAllAuthor(){
        return authorService.getAllAuthor();
    }
}
