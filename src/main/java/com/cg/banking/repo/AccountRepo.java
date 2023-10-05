package com.cg.banking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.banking.model.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account,Integer>{

}
