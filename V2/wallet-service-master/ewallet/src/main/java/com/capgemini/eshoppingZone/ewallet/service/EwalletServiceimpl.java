package com.capgemini.eshoppingZone.ewallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.eshoppingZone.ewallet.pojo.Ewallet;
import com.capgemini.eshoppingZone.ewallet.pojo.Statement;
import com.capgemini.eshoppingZone.ewallet.repository.EwalletRepository;
import com.capgemini.eshoppingZone.ewallet.repository.StatementsRepository;

@Service
public class EwalletServiceimpl implements EwalletService {

	private static int statementId = 1;
	
	@Autowired
	EwalletRepository repo;

	@Autowired
	StatementsRepository statementrepo;

	public List<Ewallet> getWallets() {
		return repo.findAll();
	}

	public Ewallet addWallet(Ewallet wallet) {
		return repo.save(wallet);
	}

	public void update(Ewallet wallet, double amount, String transactionType) {
		// wallet.setCurrentBalance(wallet.getCurrentBalance() + amount);
		repo.save(wallet);
		Statement statement = new Statement();
		statement.setAmount(amount);
		statement.setStatementId(statementId++);
		statement.setDateTime(LocalDateTime.now());
		statement.setOrderId(10);
		statement.setTransactionRemarks("done");
		statement.setTransactionType(transactionType);
		statement.setEwallet(wallet);
		statementrepo.save(statement);
	}

	public Ewallet getById(int walletId) {
		Optional<Ewallet> wallet = repo.findById(walletId);
		if (wallet.isPresent()) {
			return wallet.get();
		} else
			return null;
	}

	public List<Statement> getStatementsById(int walletId) {
		Ewallet wallets = repo.findById(walletId).get();
		return wallets.getStatements();

	}

	public List<Statement> getStatements() {
		return statementrepo.findAll();
	}

	public void deleteByid(int id) {
		repo.deleteById(id);
	}

}
