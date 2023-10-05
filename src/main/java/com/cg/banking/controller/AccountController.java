package com.cg.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.exception.InvalidUserId;
import com.cg.banking.model.Account;
import com.cg.banking.model.User;
import com.cg.banking.services.AccountService;

import jakarta.validation.Valid;


@RestController
public class AccountController {
	@Autowired
	private AccountService service;
	
@PostMapping(value="/createAccount"  , consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account> create(@Valid @RequestBody Account account){
	return new ResponseEntity<Account>(service.create(account),HttpStatus.CREATED);
}

@DeleteMapping(value="/deleteAccount/{accountId}"  )
public ResponseEntity<String> delete(@Valid @PathVariable int accountId)throws InvalidAccountId,com.cg.banking.exception.LessThanMinimum {
	return new ResponseEntity<String>(service.delete(accountId),HttpStatus.OK);
}

@PutMapping(value="/deposit/{accountId}/{amount}" )
public ResponseEntity<Double> deposit(@Valid @PathVariable int accountId,@PathVariable double amount)throws InvalidAccountId{
	return new ResponseEntity<Double>(service.deposit(accountId,amount),HttpStatus.ACCEPTED);
}

@PutMapping(value="/withdraw/{accountId}/{amount}" )
public ResponseEntity<Double>withdraw(@Valid@PathVariable int accountId,@PathVariable double amount)throws InvalidAccountId,com.cg.banking.exception.LessThanMinimum {
	return new ResponseEntity<Double>(service.withdraw(accountId,amount),HttpStatus.OK);
}

@PostMapping(value="/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<User>createUser(@Valid @RequestBody User user){
	return new ResponseEntity<User>(service.createUser(user),HttpStatus.CREATED);
}

@GetMapping(value="/get/{userId}" )
public ResponseEntity<User>getDetails(@PathVariable int userId)throws InvalidUserId  {
	return new ResponseEntity<User>(service.getUser(userId),HttpStatus.OK);
}

@GetMapping(value="/updatePin/{userId}/{oldPin}/{pin}")
public ResponseEntity<Integer>updatePin(@PathVariable int userId,@Valid @PathVariable int oldPin,@PathVariable int pin)throws InvalidUserId {
	return new ResponseEntity<Integer>(service.setPin(userId,oldPin,pin),HttpStatus.OK);
}


}
