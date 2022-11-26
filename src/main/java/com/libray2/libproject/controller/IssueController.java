package com.libray2.libproject.controller;


import com.libray2.libproject.Exception.LibraryException;
import com.libray2.libproject.dto.IssueDto;
import com.libray2.libproject.dto.ReturnDto;
import com.libray2.libproject.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @PostMapping
    public String createIssue(@RequestBody IssueDto issueDto) throws  Exception, LibraryException {
        return issueService.createIssue(issueDto);
    }
    @PostMapping("return")
    public String returnIssue(@RequestBody ReturnDto returnDto) throws  Exception{
        return issueService.returnIssue(returnDto);
    }
}
