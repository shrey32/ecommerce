package com.shrey.merchantservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrey.merchantservice.enums.OfferStatus;
import com.shrey.merchantservice.model.Offer;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

	List<Offer> findAllByMerchantId(Long merchantId);

	List<Offer> findAllByStatus(OfferStatus status);

}
