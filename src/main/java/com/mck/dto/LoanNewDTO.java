package com.mck.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mck.domain.Borrower;

public class LoanNewDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String description;
	private Date issueDate;
	private Date dueDate;
	private double value;
	
	
	private Integer borrowerId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public Integer getBorrowerId() {
		return borrowerId;
	}


	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}
	
	
	
	
	
	

}
