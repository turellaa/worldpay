package com.wkp.offer;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wkp.offer.pojo.Offer;
import com.wkp.offer.repo.OfferRepo;
import com.wkp.offer.service.Services;
import com.wkp.offer.service.impl.OfferServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class OfferServicesTest {
	
	
	
	@Configuration
	public static class TestConfiguration {
		@Bean
		public Services comuneService(){
			return new OfferServices();
		}
	
	}
	
	
	/**
	 * 
	 */
	@Autowired
	private Services service;

	/**
	 * 
	 */
	@Test
	public void getAll() {
		
		Collection<Offer> c = OfferRepo.offerts.values();
		List<Offer> l = new ArrayList<Offer>(c);
		List<Offer> m = service.getAll();
		
		
		assertEquals(l, m);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void getOneById() {
		Offer  c = OfferRepo.offerts.get(1L);
		Offer m = service.getOneById(1L);
		assertEquals(c, m);
		
	}
	}