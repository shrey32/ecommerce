package com.shrey.merchantservice.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

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

import com.shrey.merchantservice.enums.OfferStatus;
import com.shrey.merchantservice.model.Offer;

/**
 * 
 * @author Shrey
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OfferControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void findOfferByIdTest() {
		ResponseEntity<Offer> offerResponse = this.restTemplate.getForEntity("http://localhost:" + port + "/offer/1",
				Offer.class);
		assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(offerResponse).isNotNull();
		assertThat(offerResponse.getBody().getMerchantId()).isNotNull().isGreaterThan(0);
	}

	@Test
	public void offerByIdNotFoundTest() {
		ResponseEntity<Offer> offerResponse = this.restTemplate.getForEntity("http://localhost:" + port + "/offer/100",
				Offer.class);
		assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void findAllOfferTest() {
		ResponseEntity<Offer[]> offerResponse = this.restTemplate.getForEntity("http://localhost:" + port + "/offer",
				Offer[].class);
		assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(offerResponse).isNotNull();
		assertThat(offerResponse.getBody().length).isGreaterThan(1);
	}

	@Test
	public void createNewOfferTest() {
		ResponseEntity<Offer> offerResponse = this.restTemplate.postForEntity("http://localhost:" + port + "/offer",
				getDummyOffer(), Offer.class);
		assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(offerResponse).isNotNull();
		assertThat(offerResponse.getBody().getId()).isNotNull().isGreaterThan(0);
	}

	@Test
	public void findAllOfferByMerchantIdTest() {
		ResponseEntity<Offer[]> offerResponse = this.restTemplate
				.getForEntity("http://localhost:" + port + "/offer/merchant/1", Offer[].class);
		assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(offerResponse).isNotNull();
		assertThat(offerResponse.getBody().length).isGreaterThan(0);
	}

	@Test
	public void updateOfferStatusByIdTest() {
		Offer offerResponse = this.restTemplate
				.patchForObject("http://localhost:" + port + "/offer/1/status?status=CANCELLED", null, Offer.class);
		assertThat(offerResponse.getStatus()).isEqualTo(OfferStatus.CANCELLED);
	}

	private Offer getDummyOffer() {
		Offer offer = new Offer();
		offer.setMerchantId(1);
		offer.setDescription("Test Offer Description");
		offer.setStatus(OfferStatus.VALID);
		offer.setValidityInMinutes(2);
		offer.setCurrency("GBP");
		offer.setPrice(new BigDecimal("350.35"));
		return offer;
	}
}
