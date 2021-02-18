package com.shrey.merchantservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shrey.merchantservice.enums.OfferStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Shrey
 *
 */
@Entity
@Table(name = "offers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "merchant_id")
	private long merchantId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OfferStatus status;

	@Column(name = "description")
	private String description;

	@Column(name = "validityInMinutes")
	private long validityInMinutes;

	@Column(precision = 16, scale = 2)
	private BigDecimal price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDateTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
	private Date createDateTime;

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public OfferStatus getStatus() {
		return status;
	}

	public void setStatus(OfferStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getValidityInMinutes() {
		return validityInMinutes;
	}

	public void setValidityInMinutes(long validityInMinutes) {
		this.validityInMinutes = validityInMinutes;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "currency", length = 3)
	private String currency;

	@Override
	public String toString() {
		return "Offer [id=" + id + ", merchantId=" + merchantId + ", status=" + status + ", description=" + description
				+ ", validityInMinutes=" + validityInMinutes + ", price=" + price + ", createDateTime=" + createDateTime
				+ ", currency=" + currency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
