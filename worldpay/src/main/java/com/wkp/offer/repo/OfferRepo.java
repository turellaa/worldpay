package com.wkp.offer.repo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import com.wkp.offer.pojo.Offer;
import com.wkp.offer.pojo.Product;

public class OfferRepo {

		
		static {
			offerts = new HashMap<Long,Offer>();
			Offer o = new Offer();
			o.setActive(true);
			
			o.setComments(new String[]{"first com","second com","third com"});
			o.setCreationTime(GregorianCalendar.getInstance().getTime());
			o.setOfferId(1L);
			List<Product> p = new ArrayList<Product>();
			Product pp = new Product();
			pp.setComments("prod Comment");
			pp.setProductName("name");
			pp.setProductPrice("€ 10000");
			o.setProducts(p);
			OfferRepo.offerts.put(o.getOfferId(), o);
		}
		public static HashMap<Long,Offer> offerts; 	

	}


