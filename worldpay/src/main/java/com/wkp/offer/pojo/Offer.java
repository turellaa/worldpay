package com.wkp.offer.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ATURELLA
 *
 */
public  class Offer implements Serializable  {
	
	
	
	/**
	 * 
	 */
	private Long offerId;
	
	/**
	 * 
	 */
	private String[] comments;
	
	/**
	 * 
	 */
	private boolean active;
	
	/**
	 * 
	 */
	private int delay_time;
	
	/**
	 * 
	 */
	private Date creationTime;
	
	/**
	 * 
	 */
	private Date expirationTime;
	
	/**
	 * 
	 */
	private List<Product> products;


	/**
	 * @return
	 */
	public String[] getComments() {
		return comments;
	}


	/**
	 * @param comments
	 */
	public void setComments(String[] comments) {
		this.comments = comments;
	}


	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return
	 */
	public List<Product> getProducts() {
		return products;
	}


	/**
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}


	/**
	 * @return
	 */
	public Long getOfferId() {
		return offerId;
	}


	/**
	 * @param offerId
	 */
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}


	/**
	 * @return
	 */
	public int getDelay_time() {
		return delay_time;
	}


	/**
	 * @param delay_time
	 */
	public void setDelay_time(int delay_time) {
		this.delay_time = delay_time;
	}


	/**
	 * @return
	 */
	public Date getCreationTime() {
		return creationTime;
	}


	/**
	 * @param creationTime
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}


	/**
	 * @return
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}


	/**
	 * @param expirationTime
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	
}
