package com.libray2.libproject.controller;

import com.libray2.libproject.Entity.Book;
import com.libray2.libproject.dto.BookDto;
import com.libray2.libproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public BookDto saveBook(@RequestBody Book book){
        return  bookService.saveBook(book);
    }
    @GetMapping
    public List<BookDto> getBook(){
        return bookService.getBook();
    }

    @PostMapping("search")
    public List<BookDto> searchBook(@RequestBody BookDto bookDto){
        return bookService.searchBook(bookDto);
    }



}
