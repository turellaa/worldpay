package com.wkp.offer.task;

import java.util.GregorianCalendar;

import com.wkp.offer.pojo.Offer;
import com.wkp.offer.repo.OfferRepo;

public class RunnableTask implements Runnable{
	
	/**
	 * 
	 */
	private long my_offerId;
	
	/**
	 * @param in_offerId
	 */
	public void setOfferId(long in_offerId){
		
		this.my_offerId = in_offerId;
	}
	
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
    	Offer expired = OfferRepo.offerts.get(my_offerId);
    	expired.setActive(false);
    	expired.setExpirationTime(GregorianCalendar.getInstance().getTime());
    	OfferRepo.offerts.put(my_offerId,expired);
    }

}
