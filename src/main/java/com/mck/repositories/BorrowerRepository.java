package com.mck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mck.domain.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>{

}
