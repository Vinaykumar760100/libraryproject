package com.libraryproject.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	   @Id
	    private Long bookid;
	   @Column(name="bookname")
	    private String bookname;
	   @Column(name="status")
	    private String status;
	@OneToMany(mappedBy = "book")
	@JsonIgnore
	private List<LibraryManager> librarymanager;
	public Long getBookid() {
		return bookid;
	}
	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<LibraryManager> getLibrarymanager() {
		return librarymanager;
	}
	public void setLibrarymanager(List<LibraryManager> librarymanager) {
		this.librarymanager = librarymanager;
	}
	
}
