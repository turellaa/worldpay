package com.wkp.offer;



import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wkp.offer.controller.OfferController;
import com.wkp.offer.pojo.Offer;
import com.wkp.offer.pojo.OfferMessage;
import com.wkp.offer.pojo.Product;
import com.wkp.offer.service.Services;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class OfferControllerTest extends AbstractRestApiTest {

	@Configuration
	@EnableWebMvc
	public static class TestConfiguration {

		
		@Bean
		public Services services() {
			return mock(Services.class);
		}
		
		@Bean
		public OfferController offerController() {
			return new OfferController();
		}
		
		@Bean
		public ObjectMapper objectMapper() {
			return new ObjectMapper();
		}

	}
	
	/**
	 * 
	 */
	@Autowired
    ObjectMapper objectMapper;

	/**
	 * 
	 */
	@Autowired
	private Services service;
	
	
	/* (non-Javadoc)
	 * @see com.wkp.offer.AbstractRestApiTest#setUp()
	 */
	@Before
	public void setUp() {
		super.setUp();
	}

	/**
	 * 
	 */
	@Test
	public void products() {
		// -- ESECUZIONE TEST
		// ---------------------------------------------------------------------------------------------------
		try {
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
			List<Offer> p2 = new ArrayList<Offer>();
			p2.add(o);
			
			when(this.service.getAll()).thenReturn(p2);
			
			ResultActions ret = this.getResults(get("/worldpay/product/all"));
			ret.andExpect(status().isOk())
	        .andExpect(jsonPath("$").isNotEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -- ESECUZIONE TEST
		// ---------------------------------------------------------------------------------------------------

	}

	/**
	 * 
	 */
	public void productsActive() {
		
		// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------
				try {
					
					
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
					
					when(this.service.addOne(o)).thenReturn(o);
					
					ResultActions ret = this.getResults(put("/worldpay/product/add",o));
					ret.andExpect(status().isOk())
			        .andExpect(jsonPath("$").isNotEmpty());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------


	}

	/**
	 * 
	 */
	@Test
	public void newProduct() {
		
		// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------
				try {
					
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
					
					when(this.service.getOneById(1L)).thenReturn(o);
					
					ResultActions ret = this.getResults(get("/worldpay/product/{id}",1));
					ret.andExpect(status().isOk())
			        .andExpect(jsonPath("$").isNotEmpty());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------


	}

	/**
	 * 
	 */
	@Test
	public void updteProduct() {
		
		// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------
				try {
					
					
					
					
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
					
					OfferMessage m = new OfferMessage();
					m.setMessage("update finish");
					
					when(this.service.updOneById(o,1L) ).thenReturn(m);
					
					ResultActions ret = this.getResults(post("/worldpay/product/{id}/update",1L)
														.contentType(APPLICATION_JSON)
										                .content(objectMapper.writeValueAsBytes(o))
														);
					ret.andExpect(status().isOk());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------


	}

	/**
	 * 
	 */
	@Test
	public void delProduct() {

		// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------
				try {
					
		
					
					OfferMessage m = new OfferMessage();
					
					when(this.service.delOneById(1L)).thenReturn(m);
					
					ResultActions ret = this.getResults(delete("/worldpay/product/{id}/delete",1L));
					ret.andExpect(status().isOk())
			        .andExpect(jsonPath("$").isNotEmpty());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// -- ESECUZIONE TEST
				// ---------------------------------------------------------------------------------------------------

	}

	
}
