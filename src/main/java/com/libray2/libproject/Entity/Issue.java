package com.libray2.libproject.Entity;

import com.libray2.libproject.external.IssueType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="issue_seq")
    @SequenceGenerator(name="issue_seq",sequenceName = "issue_seq",allocationSize=1)
    private Long id;
    @ElementCollection
    private List<Long> book_id;
    @ManyToOne
    private User user;
    private Date issueDate;
    private Date expectedReturnDate;
    private Date returnDate;
    @Enumerated(EnumType.STRING)
    private IssueType issueType;
}
