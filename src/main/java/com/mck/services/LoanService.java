package com.mck.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mck.domain.Borrower;

import com.mck.domain.Loan;

import com.mck.repositories.BorrowerRepository;
import com.mck.repositories.LoanRepository;

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
	
	
//	public List<Loan> search(Integer id ){
//			Optional<Borrower> borrower = borrowRepo.findById(id);
//		
//		
//		return repo.search( String.valueOf(borrower.get().getId()));
//	}
}
