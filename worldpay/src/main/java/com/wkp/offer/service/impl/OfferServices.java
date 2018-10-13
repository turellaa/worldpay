package com.wkp.offer.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wkp.offer.pojo.Offer;
import com.wkp.offer.pojo.OfferMessage;
import com.wkp.offer.repo.OfferRepo;
import com.wkp.offer.service.Services;
import com.wkp.offer.task.RunnableTask;

@Service
public class OfferServices implements Services{
	
	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#setExpiration(java.lang.Long, int)
	 */
	public void setExpiration( Long offerId ,int out_delay){
	        ScheduledExecutorService scheduler
	                            = Executors.newSingleThreadScheduledExecutor();
	        Runnable task = new RunnableTask() ;
	        ((RunnableTask)task).setOfferId(offerId);
	        scheduler.schedule(task, out_delay, TimeUnit.SECONDS);
	        scheduler.shutdown();
	    }

	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#getAll()
	 */
	@Override
	public List<Offer> getAll() {
		Collection<Offer> c = OfferRepo.offerts.values();
		return new ArrayList<Offer>(c);
	}
	
	
	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#getAllActive()
	 */
	@Override
	public List<Offer> getAllActive() {
		List<Offer> c = OfferRepo.offerts.values().stream().filter(p-> p.isActive()).collect(Collectors.<Offer>toList());
		return c;
	}
	

	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#getOneById(java.lang.Long)
	 */
	@Override
	public Offer getOneById(Long id) {
		Offer o= OfferRepo.offerts.get(id);
		if (o.isActive()){
			return o;
		} 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#addOne(com.wkp.offer.pojo.Offer)
	 */
	@Override
	public Offer addOne(Offer offer) {
		int count = OfferRepo.offerts.size();
		long new_id = count + 1;
		offer.setOfferId(new Long(new_id));
		offer.setCreationTime(GregorianCalendar.getInstance().getTime());
		OfferRepo.offerts.put(new_id, offer);
		setExpiration(new_id,offer.getDelay_time());
		return offer;
	}

	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#delOneById(java.lang.Long)
	 */
	@Override
	public OfferMessage delOneById(Long offer_id) {
		OfferMessage m = new OfferMessage();
		if (OfferRepo.offerts.get(offer_id).isActive()){
			Offer rem = OfferRepo.offerts.remove(offer_id);
			m.setOffer(rem);
			m.setMessage("Offert deleted");
		}else{
			m.setMessage("Offert is not active!!! delete not allow");
			
		}
		return m;
	}

	/* (non-Javadoc)
	 * @see com.wkp.offer.service.Services#updOneById(com.wkp.offer.pojo.Offer, java.lang.Long)
	 */
	@Override
	public OfferMessage updOneById(Offer offer,Long id) {
		
		OfferMessage m = new OfferMessage();
		if (OfferRepo.offerts.get(offer.getOfferId()).isActive() && offer.getOfferId() == id){
			Offer rem = OfferRepo.offerts.put(offer.getOfferId(),offer);
			m.setMessage("Offert updated");
			m.setOffer(rem);
		}else{
			m.setMessage("Offert is not active!!! update not allow OR id not for product submitted");
			
		}
		return m;
	}
	}