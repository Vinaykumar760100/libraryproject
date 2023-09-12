package com.libraryproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libraryproject.entities.Member;

public interface MemeberRepo extends JpaRepository<Member, Long> {
	  @Query("select m from Member m where m.name=:name")
       List<Member> findbyname(@Param("name") String name);
	  
	     List<Member> findByEmail(String email);
	     List<Member>    findByNameContaining(String keyword);
}
