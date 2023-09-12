package com.libraryproject.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Member")
public class Member {
	@Id
    private Long memberid;
	@Column(name="name")
    private String name;
	@Column(name="email")
    private String email;
	@Column(name="phonenumber")
    private String phonenumber;
	@OneToMany(mappedBy = "member")
	@JsonIgnore
	private List<LibraryManager> librarymanagerm;
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<LibraryManager> getLibrarymanagerm() {
		return librarymanagerm;
	}
	public void setLibrarymanagerm(List<LibraryManager> librarymanagerm) {
		this.librarymanagerm = librarymanagerm;
	}
}
