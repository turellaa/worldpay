package com.wkp.offer.pojo;

public class OfferMessage {
	
	
	/**
	 * 
	 */
	private String message;
	
	/**
	 * 
	 */
	private Long offer_id;
	
	/**
	 * 
	 */
	private Offer offer;

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public Long getOffer_id() {
		return offer_id;
	}

	/**
	 * @param offer_id
	 */
	public void setOffer_id(Long offer_id) {
		this.offer_id = offer_id;
	}

	/**
	 * @return
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * @param offer
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
