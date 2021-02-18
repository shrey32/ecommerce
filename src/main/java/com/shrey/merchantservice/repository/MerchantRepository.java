package com.shrey.merchantservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrey.merchantservice.model.Merchant;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long> {

}
