package com.mck.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.mck.domain.Borrower;

import com.mck.domain.Loan;
import com.mck.dto.BorrowerDTO;

import com.mck.dto.LoanDTO;
import com.mck.dto.LoanNewDTO;
import com.mck.repositories.BorrowerRepository;
import com.mck.repositories.LoanRepository;
import com.mck.services.exceptions.DataIntegrityException;

@Service
public class LoanService {
	@Autowired
	private LoanRepository repo;
	private BorrowerRepository borrowRepo;
	
	public Loan find(Integer id) {
		Optional<Loan> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Loan> findAll() {
		
		return repo.findAll();
	}
	
	public Loan fromDTO(LoanDTO obj) {
		
		return new Loan(obj.getId(), obj.getTitle(), obj.getDescription(), obj.getIssueDate(), obj.getDueDate(), null, obj.getValue());
	}
	
	public Loan fromDTO(LoanNewDTO obj) {
		Loan loan = new Loan(obj.getId(), obj.getTitle(), obj.getDescription(), obj.getIssueDate(), obj.getDueDate(), null, obj.getValue());
		Borrower borrower = new Borrower(obj.getBorrowerId(), null, null, null);
		loan.setBorrower(borrower);
		
		
		return loan;
	}

	
	
	public Loan insert(Loan obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
				
	}

	public Loan update(Loan obj) {
		Loan newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	private void updateData(Loan newObj, Loan obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setBorrower(obj.getBorrower());
		newObj.setDescription(obj.getDescription());
		newObj.setDueDate(obj.getDueDate());
		newObj.setIssueDate(obj.getIssueDate());
		newObj.setValue(obj.getValue());		
	}

	public void delete(Integer id) {
		
			find(id);
			
				repo.deleteById(id);
		
		
		
	}
	
//	public List<Loan> search(Integer id ){
//			Optional<Borrower> borrower = borrowRepo.findById(id);
//		
//		
//		return repo.search( String.valueOf(borrower.get().getId()));
//	}
}
