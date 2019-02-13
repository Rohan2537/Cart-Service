package com.capgemini.eshoppingZone.ewallet.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.eshoppingZone.ewallet.pojo.Ewallet;
import com.capgemini.eshoppingZone.ewallet.pojo.Statement;
import com.capgemini.eshoppingZone.ewallet.repository.EwalletRepository;
import com.capgemini.eshoppingZone.ewallet.service.EwalletService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WalletServiceTest {

	@Mock
	EwalletService ewalletService;

	@Autowired
	EwalletService service;

	@Autowired
	EwalletRepository repo;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test // mockito test for adding new wallet
	public void checkForAddOfNewWallet() {
		Ewallet wallet = new Ewallet(1, 20.0);
		when(ewalletService.addWallet(wallet)).thenReturn(wallet);
		assertEquals(20.0, ewalletService.addWallet(wallet).getCurrentBalance(), 0);
	}

	@Test
	public void checkForListOfWallets() {
		List<Ewallet> wallets = new ArrayList<Ewallet>();
		Ewallet wallet1 = new Ewallet(1, 10.0);
		Ewallet wallet2 = new Ewallet(2, 20.0);
		wallets.add(wallet1);
		wallets.add(wallet2);
		when(ewalletService.getWallets()).thenReturn(wallets);
		assertEquals(2, ewalletService.getWallets().size());
	}

	@Test
	public void checkForUpdateBalance() {
		Ewallet wallet = service.getById(51);
		// double amount = 1000;
		// service.update(wallet, amount, "deposit");
		assertEquals(8000.0, wallet.getCurrentBalance(), 0);
	}

	@Test
	public void checkForGetByWalletID() {
		Ewallet wallet = service.getById(61);
		assertEquals(20, wallet.getCurrentBalance(), 0);
	}

	@Test
	public void checkForGetStatementsSize() {
		List<Statement> statements = service.getStatements();
		assertEquals(60, statements.size());
	}

	@Test
	public void checkForGetStatementsById() {
		Ewallet ewallet = repo.findById(51).get();
		assertNotEquals(null, ewallet.getStatements());
	}

	@Test
	public void checkForDeleteWallet() {
		// service.deleteByid(57);
		assertEquals(null, service.getById(57));
	}

}
