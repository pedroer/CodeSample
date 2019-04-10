package com.example.rest;

import com.example.exceptions.CharityNotFoundException;
import com.example.model.CharityList;
import com.example.model.to.ResponseCharityTO;
import com.example.model.to.SearchTO;
import com.example.services.CharityService;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charity")
public class CharityResource {

	private static final Logger log = LoggerFactory.getLogger(CharityResource.class);
	@Autowired
	private CharityService charityService;
	
	/**
	 * Search for the charities using the api and using the parameters received
	 * @param searchTO
	 * @return List<Charity>
	 * @throws CharityNotFoundException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@Cacheable(value = "charities")
	@PostMapping()
	public List<CharityList> searchCharity(@RequestBody SearchTO searchTO) throws CharityNotFoundException {

		log.info("listing charities for search: {}", searchTO);

		ResponseEntity<String> data = charityService.findCharityBySearchTerms(searchTO);
		Gson gson = new Gson();
		ResponseCharityTO responseC = gson.fromJson(data.getBody(), ResponseCharityTO.class);
		List<CharityList> charities = responseC.getData();

		return charities;
	}

}
