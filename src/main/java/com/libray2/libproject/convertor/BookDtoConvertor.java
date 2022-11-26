package com.libray2.libproject.convertor;

import com.libray2.libproject.Entity.Book;
import com.libray2.libproject.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConvertor {
     public BookDto toBookDto(Book book){
         BookDto bookDto=new BookDto();
         bookDto.setName(book.getName());
         bookDto.setAuthorName(book.getAuthor().getName());
         bookDto.setTag(book.getTag());
         bookDto.setLanguage(book.getLanguage());
         return bookDto;
     }
}
