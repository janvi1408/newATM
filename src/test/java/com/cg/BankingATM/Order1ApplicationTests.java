package com.cg.BankingATM;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.exception.LessThanMinimum;
import com.cg.banking.model.Account;
import com.cg.banking.repo.AccountRepo;
import com.cg.banking.services.AccountService;
import com.cg.banking.services.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
class Order1ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
	private AccountRepo accountRepo;
	@InjectMocks
	private  AccountService service =new AccountServiceImpl();
@Test
void testWithdraw()throws LessThanMinimum,InvalidAccountId{
	int accountId=1;
	Account account=new Account(1,"saving",60100);
	when(accountRepo.findById(accountId)).thenReturn(Optional.of(account));
	assertThrows(LessThanMinimum.class,()->service.withdraw(1, 60200));
	}

@Test
void testDeposit() throws InvalidAccountId {
	int accountId=2;
			Account account=new Account(2,"",500);
	when(accountRepo.findById(accountId)).thenReturn(Optional.of(account));
	assertEquals(600.0,service.deposit(2, 100));
}



}
