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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.merchantservice.model.Merchant;
import com.shrey.merchantservice.service.MerchantService;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/merchant")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	@PostMapping()
	public ResponseEntity<Merchant> save(@Validated @RequestBody Merchant merchant) {
		return new ResponseEntity<Merchant>(this.merchantService.save(merchant), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Merchant> findById(@PathVariable Long id) {
		Merchant merchant = this.merchantService.findById(id);
		if (merchant != null)
			return new ResponseEntity<Merchant>(merchant, HttpStatus.OK);
		return new ResponseEntity<Merchant>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public List<Merchant> findAll() {
		return this.merchantService.findAll();
	}

}
