package com.libray2.libproject.service;


import com.libray2.libproject.Entity.Book;
import com.libray2.libproject.Entity.Issue;
import com.libray2.libproject.Entity.User;
import com.libray2.libproject.Exception.LibraryException;
import com.libray2.libproject.dto.IssueDto;
import com.libray2.libproject.dto.ReturnDto;
import com.libray2.libproject.external.ErrorCodes;
import com.libray2.libproject.external.IssueType;
import com.libray2.libproject.repository.BookRepository;
import com.libray2.libproject.repository.IssueRepository;
import com.libray2.libproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    public String createIssue(IssueDto issuedto) throws LibraryException,Exception {
            Long userId=issuedto.getUserId();
            List<Long> bookId=issuedto.getBookId();
            Optional<User> user=userRepository.findById(userId);
            if (!user.isPresent()){
                throw LibraryException.libraryExceptionImpl(ErrorCodes.USER_NOT_FOUND);
            }
            List<Book>  books=bookRepository.findAllById(bookId);
            List<Book>  availBook=books.stream().filter(b->b.getNoOfCopies()>0).collect(Collectors.toList());
            if (availBook.size()!=bookId.size())
            {
                throw LibraryException.libraryExceptionImpl(ErrorCodes.BOOK_NOT_FOUND);
            }
            List<Long>  availBookId=availBook.stream().map(b->b.getId()).collect(Collectors.toList());
            Date today=new Date();
            long lTime = today.getTime()+8*24*60*60*1000;
            Date today8 = new Date(lTime);
            issueRepository.save(Issue.builder().user(user.get()).issueDate(today).expectedReturnDate(today8).issueType(IssueType.ISSUE).book_id(availBookId).build());
            bookRepository.reduceStock(availBookId);
            return "success";
    }

    public String returnIssue(ReturnDto returnDto) throws Exception,LibraryException{
            Optional<Issue> issue=issueRepository.findById(returnDto.getIssue());
            if (!issue.isPresent()){
                throw LibraryException.libraryExceptionImpl(ErrorCodes.ISSUE_NOT_FOUND);

            }
            if (issue.get().getIssueType()!=IssueType.ISSUE){
                throw LibraryException.libraryExceptionImpl(ErrorCodes.INVALID_PAGE_REQUEST);
            }
//            if(issue.get().getUser()!=returnDto.getUser()){
//                throw new Exception();
//            }
            Issue issue1=issue.get();
            issue1.setIssueType(IssueType.RETURNED);
            issue1.setReturnDate(new Date());
            issueRepository.save(issue1);
            List<Long> bookId=issue1.getBook_id();
            bookRepository.addStock(bookId);
            return "success";
    }
}
