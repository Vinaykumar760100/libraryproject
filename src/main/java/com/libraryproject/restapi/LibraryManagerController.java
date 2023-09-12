package com.libraryproject.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.libraryproject.entities.LibraryManager;
import com.libraryproject.repo.LibraryManagerRepo;
 @RestController
public class LibraryManagerController {

	@Autowired
	LibraryManagerRepo librarymanagerrepo;
	//1
		@GetMapping("/alllib")
		public List<LibraryManager> getlist()
		{
			return librarymanagerrepo.findAll();
		}
    //2
	 @PostMapping("/addbook/{bookid}/{memberid}")
	 public LibraryManager addbookbylibrarymanager(@RequestBody LibraryManager librarymanager)
	 {
		 return librarymanagerrepo.save(librarymanager);
	 }
	 @GetMapping("/getdetails/{sno}")
	 public List<LibraryManager> getlibrarydetails(@RequestParam("sno") Long sno)
	 {
		 return librarymanagerrepo.findbysno(sno);
	 }
	 @PutMapping("/updatedetils/{sno}")
	 public LibraryManager updatedate(@PathVariable("sno") Long sno,@RequestBody LibraryManager libraryManager)
	 {
		    var a=librarymanagerrepo.findById(sno);
		       if(a.isPresent())
		       {
		    	  var b= a.get();
		    	  b.setBorroweddate(libraryManager.getBorroweddate());
		    	  b.setReturndate(libraryManager.getReturndate());
		    	  librarymanagerrepo.save(b);
		    	  return b;
		       }
		       else
		    	    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"sno not found");
		    
	 }
}

