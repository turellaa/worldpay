package com.wkp.offer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wkp.offer.pojo.Offer;
import com.wkp.offer.pojo.OfferMessage;
import com.wkp.offer.service.Services;

@RestController
@RequestMapping("/worldpay/product")
public class OfferController {

	@Autowired
	private Services service;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Offer>> products() {
		List<Offer> o = service.getAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(o, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/allActive", method = RequestMethod.GET)
	public ResponseEntity<List<Offer>> productsActive() {
		List<Offer> o = service.getAllActive();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(o, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Offer> product(@PathVariable("id") long id) {

		Offer o = service.getOneById(id);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Offer>(o, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity<Offer> newProduct(@RequestBody Offer offer) {
		Offer o = service.addOne(offer);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Offer>(o, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public ResponseEntity<OfferMessage> updteProduct(@PathVariable("id") long id, @RequestBody Offer offer) {
		OfferMessage o = service.updOneById(offer, id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<OfferMessage>(o, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public ResponseEntity<OfferMessage> delProduct(@PathVariable("id") long id) {
		OfferMessage o = service.delOneById(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<OfferMessage>(o, headers, HttpStatus.OK);
	}

}
