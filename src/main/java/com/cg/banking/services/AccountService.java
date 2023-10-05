package com.cg.banking.services;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.exception.InvalidUserId;
import com.cg.banking.exception.LessThanMinimum;
import com.cg.banking.model.Account;
import com.cg.banking.model.User;

public interface AccountService {
public Account create(Account accountId);
public String delete(int accountId)throws InvalidAccountId,LessThanMinimum ;
public double deposit(int accountId,double amount)throws InvalidAccountId ;
public double withdraw(int accountId,double amount)throws InvalidAccountId,LessThanMinimum ;
public User createUser(User user);
//public boolean login(int userId,int pin);
public User getUser(int userId)throws InvalidUserId;
public int setPin(int userId,int oldPin,int pin)throws InvalidUserId;
public String updateMobile(int userId,String mobile)throws InvalidUserId;
}
