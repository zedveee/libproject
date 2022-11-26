package com.libray2.libproject.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="user_seq")
    @SequenceGenerator(name="user_seq",sequenceName = "user_seq",allocationSize=1)
    private Long id;
    private String name;
    private String phone;
    private String address;
    private Boolean isActive;

}
