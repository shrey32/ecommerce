package com.shrey.merchantservice.service;

import java.util.List;

import com.shrey.merchantservice.enums.OfferStatus;
import com.shrey.merchantservice.model.Offer;

/**
 * 
 * @author Shrey
 *
 */
public interface OfferService {

	Offer save(Offer offer);
	
	Offer update(Offer offer);

	Offer findById(Long id);
	
	List<Offer> findAll(); 
	
	List<Offer> findAllByMerchantId(Long merchantId);
	
	List<Offer> findAllByStatus(OfferStatus status);
	
}
