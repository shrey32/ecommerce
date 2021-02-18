package com.shrey.merchantservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.shrey.merchantservice.model.Merchant;
import com.shrey.merchantservice.repository.MerchantRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class MerchantServiceImpl implements MerchantService {

	private final static Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);

	private MerchantRepository merchantRepository;

	@Autowired
	public MerchantServiceImpl(MerchantRepository merchantRepository) {
		this.merchantRepository = merchantRepository;
	}

	@Override
	public Merchant save(Merchant merchant) {
		logger.info("Saving Merchant ==> " + merchant);
		return this.merchantRepository.save(merchant);
	}

	@Override
	public Merchant findById(Long id) {
		logger.info("finding merchant by id => " + id);
		Optional<Merchant> optionalMerchant = this.merchantRepository.findById(id);
		if (optionalMerchant.isPresent())
			return this.merchantRepository.findById(id).get();
		return null;
	}

	@Override
	public List<Merchant> findAll() {
		return Lists.newArrayList(this.merchantRepository.findAll());
	}

}
