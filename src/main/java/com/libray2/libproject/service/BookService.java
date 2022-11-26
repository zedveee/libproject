package com.libray2.libproject.service;


import com.libray2.libproject.Entity.Author;
import com.libray2.libproject.Entity.Book;
import com.libray2.libproject.convertor.BookDtoConvertor;
import com.libray2.libproject.dto.AuthorDto;
import com.libray2.libproject.dto.BookDto;
import com.libray2.libproject.repository.AuthorRepository;
import com.libray2.libproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookDtoConvertor bookDtoConvertor;

   public BookDto saveBook(Book book){
       Long authorId=book.getAuthor().getId();
       if (authorId!=null) {
           Optional<Author> author = authorRepository.findById(authorId);
           if (author.isPresent()) {
               book.setAuthor(author.get());
           }
       }
      Book book1=bookRepository.save(book);
       return bookDtoConvertor.toBookDto(book1);
   }

   public List<BookDto> getBook(){
       List<Book> books=bookRepository.findAll();
       return books.stream().map(b->bookDtoConvertor.toBookDto(b)).collect(Collectors.toList());
   }

   public List<BookDto> searchBook(BookDto bookDto){
        System.out.println(bookDto);
         List <Book> books=bookRepository.searchBook(bookDto.getName(),bookDto.getTag(),bookDto.getLanguage(),bookDto.getAuthorName());
         List<BookDto> bookDto1=books.stream().map(b->bookDtoConvertor.toBookDto(b)).collect(Collectors.toList());
         return bookDto1;
   }
}
