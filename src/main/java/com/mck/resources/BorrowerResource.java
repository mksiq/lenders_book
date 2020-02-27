package com.mck.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mck.domain.Borrower;
import com.mck.services.BorrowerService;

@RestController
@RequestMapping(value="/borrowers")
public class BorrowerResource {
	@Autowired
	private BorrowerService borrowerService;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Borrower> find(@PathVariable Integer id){
		Borrower obj = borrowerService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
