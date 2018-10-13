package com.wkp.offer.service;

import java.util.List;

import com.wkp.offer.pojo.Offer;
import com.wkp.offer.pojo.OfferMessage;


public interface Services {
	
	
	/**
	 * @return
	 */
	public List<Offer> getAll();
	
	/**
	 * @return
	 */
	public List<Offer> getAllActive();	
	
	/**
	 * @param id
	 * @return
	 */
	public Offer getOneById(Long id);
	
	/**
	 * @param offer
	 * @return
	 */
	public Offer addOne(Offer offer);
	
	/**
	 * @param offer_id
	 * @return
	 */
	public OfferMessage delOneById(Long offer_id);
	
	
	/**
	 * @param offer
	 * @param id
	 * @return
	 */
	public OfferMessage updOneById(Offer offer,Long id);
	
	/**
	 * @param offer_id
	 * @param delay
	 */
	public void setExpiration(Long offer_id,int delay);
}
