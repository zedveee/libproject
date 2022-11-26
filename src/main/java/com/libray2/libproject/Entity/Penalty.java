package com.libray2.libproject.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Penalty {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="penalty_seq")
    @SequenceGenerator(name="penalty_seq",sequenceName = "penalty_seq",allocationSize=1)
    private Long Id;
    @ManyToOne
    private User user;
    private Long amount;
    private Boolean amountPaid;
    private Date date;
}
