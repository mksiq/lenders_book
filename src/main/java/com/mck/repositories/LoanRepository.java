package com.mck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mck.domain.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
