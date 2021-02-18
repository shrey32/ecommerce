package com.shrey.merchantservice.scheduling;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shrey.merchantservice.enums.OfferStatus;
import com.shrey.merchantservice.model.Offer;
import com.shrey.merchantservice.service.OfferService;

/**
 * 
 * @author Shrey
 *
 */

@Component
public class OfferValidityScheduledTask {

	private final static Logger log = LoggerFactory.getLogger(OfferValidityScheduledTask.class);

	private OfferService offerService;

	@Autowired
	public OfferValidityScheduledTask(OfferService offerService) {
		this.offerService = offerService;
	}

	@Scheduled(fixedRate = 30000)
	public void performValidation() {
		List<Offer> validOffers = this.offerService.findAllByStatus(OfferStatus.VALID);
		validOffers.stream().filter(this::isOfferValidityExpired).forEach(this::markOfferAsInValid);
	}

	public void markOfferAsInValid(Offer offer) {
		log.info("Marking Offer ["+offer.getId()+"] as invalid");
		offer.setStatus(OfferStatus.INVALID);
		this.offerService.update(offer);
	}

	public boolean isOfferValidityExpired(Offer offer) {
		Date createDateTime = offer.getCreateDateTime();
		Date offerValidityDate = DateUtils.addMinutes(createDateTime, (int) offer.getValidityInMinutes());
		Date currentDate = new Date();
		boolean isExpired = currentDate.after(offerValidityDate);
		log.info("Offer Id [" + offer.getId() + "], validity date " + offerValidityDate
				+ " current Date, offer expired ==> " + isExpired);
		return isExpired;
	}

}
