package services;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import daos.AccountDao;
import domain.Account;

@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

	private final AccountDao accountDao;
	
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void createAccount(int number) {
		this.accountDao.insert(new Account(number));
	}
	
	@Override
	public void deleteAccount(int number) {
		final Account account = this.accountDao.get(number);
		if (account.getBalance() != 0)
			throw new RuntimeException("balance must be 0");
		this.accountDao.delete(account);
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Account getAccount(int number) {
		return this.accountDao.get(number);
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Account findAccount(int number) {
		return this.accountDao.find(number);
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Account> findAllAccounts() {
		return this.accountDao.findAll();
	}
	
	@Override
	public void deposit(int number, int amount) {
		if (amount <= 0)
			throw new RuntimeException("bad amount: " + amount);
		final Account account = this.accountDao.get(number);
		account.setBalance(account.getBalance() + amount);
		this.accountDao.update(account);
	}
	
	@Override
	public void withdraw(int number, int amount) {
		if (amount <= 0)
			throw new RuntimeException("bad amount: " + amount);
		final Account account = this.accountDao.get(number);
		if (amount > account.getBalance())
			throw new RuntimeException("cannot withdraw: " + amount);
		account.setBalance(account.getBalance() - amount);
		this.accountDao.update(account);
	}
	
	@Override
	public void transfer(int fromNumber, int toNumber, int amount) {
		this.deposit(toNumber, amount);
		this.withdraw(fromNumber, amount);
	}
}
