package com.libraryproject.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Librarymanager")
public class LibraryManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	
	@Column(name="bookid")
	private Long bookid;
	
	@Column(name="memberid")
	private Long memberid;
	 
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "bookid",insertable = false,updatable = false)
	private Book book;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "memberid",insertable = false,updatable = false)
	private Member member;

	private Date borroweddate;
	private Date returndate;
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public Long getBookid() {
		return bookid;
	}
	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Date getBorroweddate() {
		return borroweddate;
	}
	public void setBorroweddate(Date borroweddate) {
		this.borroweddate = borroweddate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
}