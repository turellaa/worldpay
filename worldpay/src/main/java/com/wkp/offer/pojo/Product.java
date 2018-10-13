package com.wkp.offer.pojo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;


public  class Product  implements Serializable {
	
	
	
	/**
	 * 
	 */
	private String productName;
	
	/**
	 * 
	 */
	private String productPrice;
	
	/**
	 * 
	 */
	private String comments;

	/**
	 * @return
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return
	 */
	public String getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 */
	public void setProductPrice(String productPrice) {		
		this.productPrice = productPrice;
	}

	/**
	 * @return
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
