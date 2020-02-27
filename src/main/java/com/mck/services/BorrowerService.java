package com.mck.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mck.domain.Borrower;
import com.mck.repositories.BorrowerRepository;

@Service
public class BorrowerService {
	@Autowired
	private BorrowerRepository repo;
	
	public Borrower find(Integer id) {
		Optional<Borrower> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
