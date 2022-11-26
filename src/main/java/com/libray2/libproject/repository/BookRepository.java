package com.libray2.libproject.repository;

import com.libray2.libproject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("update Book b set b.noOfCopies =b.noOfCopies-1 where b.id in ?1")
    @Transactional
    @Modifying
    public void reduceStock(List<Long> bookId);
    @Query("update Book b set b.noOfCopies =b.noOfCopies+1 where b.id in ?1")
    @Transactional
    @Modifying
    public void addStock(List<Long> bookId);
    @Query(value = "select * from book where name like %?1% and tag like %?2% and language like %?3%  or id in (select id from author  where name like %?4%)",nativeQuery = true)
    public List<Book> searchBook(String name,String tag,String Language,String AuthorName);
}
