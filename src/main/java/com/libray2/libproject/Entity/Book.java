package com.libray2.libproject.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="book_seq")
    @SequenceGenerator(name="book_seq",sequenceName = "book_seq",allocationSize=1)
    private Long id;
    private String name;
    private String tag;
    private String language;
    private Integer noOfCopies;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;
}
