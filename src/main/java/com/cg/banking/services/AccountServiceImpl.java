package com.cg.banking.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.exception.InvalidUserId;
import com.cg.banking.exception.LessThanMinimum;
import com.cg.banking.model.Account;
import com.cg.banking.model.User;
import com.cg.banking.repo.AccountRepo;
import com.cg.banking.repo.UserRepo;

@Component
public class AccountServiceImpl implements AccountService {
@Autowired
private AccountRepo repo;
@Autowired
private UserRepo userRepo;
	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		repo.save(account);
		return account;
	}

	@Override
	public String delete(int accountId)throws InvalidAccountId,LessThanMinimum {
		// TODO Auto-generated method stub
		Account acc=repo.findById(accountId).orElseThrow(()->new InvalidAccountId("this accountId is not valid"));
		repo.delete(acc);
		repo.save(acc);
		return "SUCCESSFULLY DELETED";
	}

	@Override
	public double deposit(int accountId, double amount)throws InvalidAccountId {
		// TODO Auto-generated method stub
		Account account=repo.findById(accountId).orElseThrow(()->new InvalidAccountId("this accountId is not valid"));
		double newAmount=account.getBalance()+amount;
		repo.findById(accountId).get().setBalance(newAmount);
		repo.save(account);
		return newAmount;
	}

	@Override
	public double withdraw(int accountId, double amount)throws InvalidAccountId,LessThanMinimum {
		// TODO Auto-generated method stub
		Account accounts=repo.findById(accountId).orElseThrow(()->new InvalidAccountId("this accountId is not valid"));
				double newAmount=accounts.getBalance()-amount;
		if(newAmount<0) {
			throw new LessThanMinimum ("BALANCE LESS THAN AMOUNT");
		}
		repo.findById(accountId).get().setBalance(newAmount);
		repo.save(accounts);
		return newAmount;
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
		
		
	}

//	@Override
//	public boolean login(int userId, int pin) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public int setPin(int userId, int oldPin,int pin)throws InvalidUserId {
		// TODO Auto-generated method stub
		int oldPinn=userRepo.findById(userId).get().getPin();
		if(oldPinn==oldPin) {
		User user=userRepo.findById(userId).orElseThrow(()-> new InvalidUserId("Invalid userId"));
				user.setPin(pin);
				userRepo.save(user);
		
		return pin;
		}
		return -1;
	}

	@Override
	public String updateMobile(int userId, String mobile)throws InvalidUserId {
		// TODO Auto-generated method stub
		User user=userRepo.findById(userId).orElseThrow(()-> new InvalidUserId("Invalid userId"));
		user.setMobileNumber(mobile);
		userRepo.save(user);
		return mobile;
	}

	@Override
	public User getUser(int userId)throws InvalidUserId {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).orElseThrow(()-> new InvalidUserId("Invalid userId"));
	}

}
