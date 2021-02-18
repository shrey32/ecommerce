package com.shrey.merchantservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.merchantservice.model.Offer;
import com.shrey.merchantservice.service.OfferService;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/offer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OfferController {

	@Autowired
	private OfferService offerService;

	@GetMapping
	public List<Offer> findAll() {
		return this.offerService.findAll();
	}

	@GetMapping("/{offerId}")
	public ResponseEntity<Offer> getOffer(@PathVariable long offerId) {
		Offer offer = this.offerService.findById(offerId);
		if (offer != null)
			return new ResponseEntity<Offer>(offer, HttpStatus.OK);
		return new ResponseEntity<Offer>(HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	ResponseEntity<Offer> create(@Validated @RequestBody Offer offer) {
		return new ResponseEntity<Offer>(this.offerService.save(offer), HttpStatus.OK);
	}

	@PutMapping()
	ResponseEntity<Offer> update(@Validated @RequestBody Offer input) {
		return new ResponseEntity<>(this.offerService.update(input), HttpStatus.OK);
	}

	@GetMapping("/merchant/{merchantId}")
	public List<Offer> getMerchantOffers(@PathVariable long merchantId) {
		return this.offerService.findAllByMerchantId(merchantId);
	}

}
