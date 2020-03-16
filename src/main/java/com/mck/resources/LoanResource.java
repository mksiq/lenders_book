package com.mck.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mck.domain.Borrower;

import com.mck.domain.Loan;
import com.mck.dto.BorrowerDTO;
import com.mck.dto.LoanDTO;
import com.mck.dto.LoanNewDTO;
import com.mck.resources.util.URLUtil;
import com.mck.services.BorrowerService;
import com.mck.services.LoanService;

@RestController
@RequestMapping(value="/loans")
public class LoanResource {
	@Autowired
	private LoanService service;
	@Autowired
	private BorrowerService borrowService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LoanDTO>> findAll() {
		List<Loan> list = service.findAll();	
		List<LoanDTO> listDTOTES = new ArrayList<LoanDTO>();
		for (int i = 0; i < list.size() ; i++) {
			listDTOTES.add (new LoanDTO(list.get(i)));
		}
		// List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTOTES);
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<LoanDTO>> findPage(
//			@RequestParam(value="borrower", defaultValue = "") String borrower,
//			@RequestParam(value="linesPerPage", defaultValue = "24")Integer linesPerPage) {
//		List<Integer> ids = URLUtil.decodeIntList(borrower);
//		List<Loan> list = service.search(Integer.valueOf(borrower));	
//		
//		List<LoanDTO> listDTO = new ArrayList<LoanDTO>();
//		for (int i = 0 ; i < list.size(); i++) {
//			listDTO.add(new LoanDTO(list.get(i)));
//		}
//		//List<LoanDTO> listDTO = list.map(obj -> new LoanDTO(obj));
//		return ResponseEntity.ok().body(listDTO);
//	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Loan> find(@PathVariable Integer id){
		Loan obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	//This returns list of loans by borrower id
	@RequestMapping(value="/borrower={id}", method=RequestMethod.GET)
	public ResponseEntity<List<LoanDTO>> findAll(@PathVariable Integer id){
		Borrower obj = borrowService.find(id);
		
		List<Loan> list = obj.getLoans();	
		List<LoanDTO> listDTOTES = new ArrayList<LoanDTO>();
		for (int i = 0; i < list.size() ; i++) {
			listDTOTES.add (new LoanDTO(list.get(i)));
		}
		// List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTOTES);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LoanNewDTO objDto){
		Loan obj = service.fromDTO(objDto);
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LoanDTO objDto, @PathVariable Integer id){
		Loan obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
