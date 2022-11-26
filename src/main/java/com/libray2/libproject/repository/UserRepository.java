package com.libray2.libproject.repository;

import com.libray2.libproject.Entity.Book;
import com.libray2.libproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from users where name like %?1% and address like %?2% and phone like %?3% ",nativeQuery = true)
    List<User> searchUser(String name,String Address,String phone);
}
