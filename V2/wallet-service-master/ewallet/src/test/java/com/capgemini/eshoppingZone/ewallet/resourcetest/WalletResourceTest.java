package com.capgemini.eshoppingZone.ewallet.resourcetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.eshoppingZone.ewallet.pojo.Ewallet;

//@WebMvcTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WalletResourceTest {

	/*
	 * @Autowired private MockMvc mockmvc;
	 */

	@Autowired
	TestRestTemplate template;

	/*
	 * @MockBean private EwalletRepository repo;
	 */
	/*
	 * @Test public void getEwallet() throws Exception {
	 * 
	 * Mockito.when(this.repo.findAll()) .thenReturn(Collections.singletonList(new
	 * Ewallet(1, 1000.0, null)));
	 * 
	 * this.mockmvc.perform(MockMvcRequestBuilders.get("/wallets"))
	 * .andExpect(MockMvcResultMatchers.status().isOk()); }
	 */

	@Test
	public void toCheckGetWalletSuccess() {
		ResponseEntity<String> entity = template.getForEntity("/wallets", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void toCheckGetWalletFail() {
		ResponseEntity<String> entity = template.getForEntity("/wallet", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void toCheckGetByWalletIdSuccess() {
		ResponseEntity<String> entity = template.getForEntity("/wallets/1", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void toCheckGetByWalletIdFailure() {
		ResponseEntity<String> entity = template.getForEntity("/wallets/10", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	public void toCheckAddWalletSuccess() {
		Ewallet wallet = new Ewallet(1, 100.0);
		ResponseEntity<String> entity = template.postForEntity("/wallets", wallet, String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void toCheckAddWalletFailure() {
		Ewallet wallet = new Ewallet(1, 100.0);
		ResponseEntity<String> entity = template.postForEntity("/wallet", wallet, String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void toCheckAddMoneySuccess() {
		template.put("/wallets/1?currentBalance="+100, null);
		ResponseEntity<Ewallet> entity = template.getForEntity("/wallets/1", Ewallet.class);
		assertEquals(entity.getBody().getCurrentBalance(),500,0);
	}
	
	@Test
	public void toCheckAddMoneyFailure() {
		template.put("/wallets/1?currentBalance="+0, null);
		ResponseEntity<Ewallet> entity = template.getForEntity("/wallets/1", Ewallet.class);
		assertNotEquals(entity.getBody().getCurrentBalance(),300,0);
	}

	@Test
	public void toCheckPayMoneySuccess() {
		template.put("/wallets/1/pay?currentBalance=" + 100.0, null);
		ResponseEntity<Ewallet> entity = template.getForEntity("/wallets/1", Ewallet.class);
		assertEquals(entity.getBody().getCurrentBalance(),300.0,0 );
	}

	@Test
	public void toCheckGetStatementsSuccess() {
		ResponseEntity<String> entity = template.getForEntity("/wallets/statements", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void toCheckGetStatementsFailure() {
		ResponseEntity<String> entity = template.getForEntity("/wallets/statement", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void toCheckGetStatementsByIdSuccess() {
		ResponseEntity<String> entity = template.getForEntity("/wallets/statements/1", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void toCheckDeleteWalletById() {
		template.delete("/wallets/50");
		ResponseEntity<String> entity = template.getForEntity("/wallets/50", String.class);
		assertEquals(entity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
