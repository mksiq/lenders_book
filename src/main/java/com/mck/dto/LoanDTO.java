package com.mck.dto;

import java.util.Date;

import com.mck.domain.Loan;

public class LoanDTO {
	private Integer id;
	private String title;
	private String description;
	private Date issueDate;
	private Date dueDate;
	private double value;
	
	
	
	
	public LoanDTO(Loan loan) {
		this.id = loan.getId();
		this.description = loan.getDescription();
		this.dueDate = loan.getDueDate();
		this.issueDate = loan.getIssueDate();
		this.title = loan.getTitle();
		this.value = loan.getValue();
	}
	
	
	public LoanDTO() {
		super();
	}
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
	
	
	
}
