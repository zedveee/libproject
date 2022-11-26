package com.libray2.libproject.Entity;


import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="author_seq")
    @SequenceGenerator(name="author_seq",sequenceName = "author_seq",allocationSize=1)
    private Long id;
    private  String name;
    private String address;
    private Boolean isActive;
}
