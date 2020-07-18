package ar.com.gnchiesa.service;

import ar.com.gnchiesa.exceptions.AccountNotFoundException;
import ar.com.gnchiesa.exceptions.OperationException;
import ar.com.gnchiesa.model.Account;
import ar.com.gnchiesa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService {

	@Autowired
	private AccountRepository exampleRepository;

	public Account create(Account account) {
		return this.exampleRepository.save(account);
	}

	public Account getAccountById(Integer accountId) throws AccountNotFoundException {
		Optional<Account> account = this.exampleRepository.findById(accountId);
		if(!account.isPresent()) {
			throw new AccountNotFoundException();
		}
		return account.get();
	}

	public Account debit(Account account, Double amount) throws OperationException {
		if(account.getBalance().doubleValue() - amount.doubleValue() < 0) {
			throw new OperationException("NEgative Balance");
		} else {
			account.setBalance(account.getBalance().doubleValue() - amount.doubleValue());
			return this.exampleRepository.save(account);
		}
	}

	public Account credit(Account account, Double amount) throws OperationException {
		account.setBalance(account.getBalance().doubleValue() + amount.doubleValue());
		return this.exampleRepository.save(account);
	}

}
