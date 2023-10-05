package com.cg.banking.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.banking.model.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
