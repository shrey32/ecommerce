package com.shrey.merchantservice.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.shrey.merchantservice.model.Merchant;

/**
 * 
 * @author Shrey
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MerchantControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void findMerchantByIdTest() {
		ResponseEntity<Merchant> merchantResponse = this.restTemplate
				.getForEntity("http://localhost:" + port + "/merchant/1", Merchant.class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(merchantResponse).isNotNull();
		assertThat(merchantResponse.getBody().getName()).isNotNull();
	}

	@Test
	public void findAllMerchantTest() {
		ResponseEntity<Merchant[]> merchantResponse = this.restTemplate
				.getForEntity("http://localhost:" + port + "/merchant", Merchant[].class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(merchantResponse).isNotNull();
		assertThat(merchantResponse.getBody().length).isGreaterThan(1);
	}

	@Test
	public void createNewMerchantTest() {
		ResponseEntity<Merchant> merchantResponse = this.restTemplate
				.postForEntity("http://localhost:" + port + "/merchant", getDummyMerchant(), Merchant.class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(merchantResponse).isNotNull();
		assertThat(merchantResponse.getBody().getId()).isNotNull().isGreaterThan(0);
	}

	private Merchant getDummyMerchant() {
		Merchant merchant = new Merchant();
		merchant.setName("Test User");
		merchant.setDescription("Test Merchant Description");
		return merchant;
	}

}
