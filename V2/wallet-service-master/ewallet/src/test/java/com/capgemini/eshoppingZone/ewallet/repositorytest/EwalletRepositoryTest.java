package com.capgemini.eshoppingZone.ewallet.repositorytest;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.eshoppingZone.ewallet.pojo.Ewallet;
import com.capgemini.eshoppingZone.ewallet.repository.EwalletRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EwalletRepositoryTest {

	@Autowired
	private EwalletRepository repo;

	@Test
	public void findByWalletId() {
		this.repo.save(new Ewallet(1, 100.0));
		Optional<Ewallet> wallet = this.repo.findById(1);
		Assertions.assertThat(wallet.get().getCurrentBalance()).isEqualTo(100.0);
	}

}
