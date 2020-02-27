package com.mck;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mck.domain.Borrower;
import com.mck.domain.Loan;
import com.mck.repositories.BorrowerRepository;
import com.mck.repositories.LoanRepository;

@SpringBootApplication
public class LendersbookApplication implements CommandLineRunner{

	@Autowired
	private BorrowerRepository borrowerRepository;
	@Autowired
	private LoanRepository loanRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LendersbookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Borrower bo1 = new Borrower(null, "Jon Doe", "(213) 2020-2020", "doejon@gmail.com");
		Loan l1 = new Loan(null, "Rent loan", "Solicited by app", null, null, bo1, 200.00);
		Loan l2 = new Loan(null, "Food loan", "Solicited by app", null, null, bo1, 19.90);
		Loan l3 = new Loan(null, "Car loan", "Solicited by app", null, null, bo1, 350.00);
		
		Borrower bo2 = new Borrower(null, "Mary Jane", "(213) 2020-2021", "janemary@gmail.com");
		Loan l4 = new Loan(null, "Cat food", "poor cat", null, null, bo2, 4.99);
		bo1.getLoans().addAll(Arrays.asList(l1,l2,l3));
		bo2.getLoans().addAll(Arrays.asList(l4));
		
		borrowerRepository.saveAll(Arrays.asList(bo1, bo2));
		
		loanRepository.saveAll(Arrays.asList(l1, l2,l3,l4));
		
	}

}
