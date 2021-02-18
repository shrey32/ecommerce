package com.shrey.merchantservice.service;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.shrey.merchantservice.enums.OfferStatus;
import com.shrey.merchantservice.model.Offer;
import com.shrey.merchantservice.repository.OfferRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class OfferServiceImpl implements OfferService {

	private final static Logger logger = LoggerFactory.getLogger(OfferServiceImpl.class);

	private OfferRepository offerRepository;

	@Autowired
	public OfferServiceImpl(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}

	@Override
	public Offer save(Offer offer) {
		logger.info("Adding new Offer ==> " + offer);
		offer.setCreateDateTime(new Date());
		return this.offerRepository.save(offer);
	}

	@Override
	public Offer update(Offer offer) {
		logger.info("updating Offer ==> " + offer);
		return this.offerRepository.save(offer);
	}

	@Override
	public Offer findById(Long id) {
		logger.info("finding Offer ==> " + id);
		return this.offerRepository.findById(id).get();
	}

	@Override
	public List<Offer> findAll() {
		return Lists.newArrayList(this.offerRepository.findAll());
	}

	@Override
	public List<Offer> findAllByMerchantId(Long merchantId) {
		logger.info("finding Offers by merchant id ==> " + merchantId);
		return this.offerRepository.findAllByMerchantId(merchantId);
	}

	@Override
	public List<Offer> findAllByStatus(OfferStatus status) {
		logger.info("finding Offers by OfferStatus ==> " + status);
		return this.offerRepository.findAllByStatus(status);
	}

}
