package com.mck.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mck.domain.Borrower;

import com.mck.dto.BorrowerDTO;
import com.mck.repositories.BorrowerRepository;
import com.mck.services.exceptions.DataIntegrityException;

@Service
public class BorrowerService {
	@Autowired
	private BorrowerRepository repo;
	
	public Borrower find(Integer id) {
		Optional<Borrower> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Borrower> findAll() {
		
		return repo.findAll();
	}
	
	public Borrower insert(Borrower obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
				
	}
	
	public Borrower fromDTO(BorrowerDTO obj) {
		return new Borrower(obj.getId(), obj.getFullName(), obj.getPhoneNumber(), obj.getEmail());
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not allowed to delete a Borrower with transactions binded");
		}
	}
	

	public Borrower update(Borrower obj) {
		//check if there is this id
		//find(obj.getId());
		Borrower newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Borrower newObj, Borrower obj) {
		newObj.setFullName(obj.getFullName());
		newObj.setEmail(obj.getEmail());
		newObj.setPhoneNumber(obj.getPhoneNumber());
		
	}
}
