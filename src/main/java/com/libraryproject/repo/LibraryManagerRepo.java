package com.libraryproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libraryproject.entities.LibraryManager;

public interface LibraryManagerRepo extends JpaRepository<LibraryManager, Long>{
	  
	      @Query("Select lm from LibraryManager lm where lm.sno=:sno")
	       List<LibraryManager>  findbysno(@Param("sno") Long sno);
}
