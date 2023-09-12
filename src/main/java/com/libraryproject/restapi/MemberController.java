package com.libraryproject.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.libraryproject.entities.Member;
import com.libraryproject.repo.LibraryManagerRepo;
import com.libraryproject.repo.MemeberRepo;

@RestController
public class MemberController {
	@Autowired
	MemeberRepo memberrepo;
	@Autowired
	LibraryManagerRepo librarymanagerrepo;

	// 1
	@GetMapping("/members")
	public List<Member> getmembers() {
		return memberrepo.findAll();
	}

	@GetMapping("/finddetailsbyname/{name}")
	public List<Member> getall(@PathVariable("name") String name) {
		return memberrepo.findbyname(name);
	}

	@PutMapping("/update/{id}")
	public Member updatename(@PathVariable("id") Long id, @RequestBody Member updatemember) {
		var a = memberrepo.findById(id);
		if (a.isPresent()) {
			var b = a.get();
			b.setName(updatemember.getName());
			b.setEmail(updatemember.getEmail());
			memberrepo.save(b);
			return b;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
		}
	}

	@GetMapping("/memberinfonyname/{email}")
	public List<Member> getmembinfo(@PathVariable("email") String email) {
		return memberrepo.findByEmail(email);
	}
    @GetMapping("/all/{keyword}")
    public List<Member> getdetaiswithprefix(@PathVariable("keyword") String keyword)
    {
    	return memberrepo.findByNameContaining(keyword);
    }
}
