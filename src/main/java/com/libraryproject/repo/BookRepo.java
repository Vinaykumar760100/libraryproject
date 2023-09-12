package com.libraryproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libraryproject.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
	
     @Query("select b from Book b where b.status=:status")
	List<Book>  findbystatus(@Param("status") String status);
     
       @Query(value="select * from Book",nativeQuery = true)
       List<Book> findnames();
       
}
