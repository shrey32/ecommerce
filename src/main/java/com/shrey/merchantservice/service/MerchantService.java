package com.shrey.merchantservice.service;

import java.util.List;

import com.shrey.merchantservice.model.Merchant;

/**
 * 
 * @author Shrey
 *
 */
public interface MerchantService {

	Merchant save(Merchant merchant);

	Merchant findById(Long id);

	List<Merchant> findAll();
}
