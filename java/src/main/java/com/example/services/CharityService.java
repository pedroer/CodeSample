package com.example.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.exceptions.CharityNotFoundException;
import com.example.model.to.SearchTO;

@Service
public class CharityService {
	
//	private final String url = "http://data.orghunter.com/v1/charitysearch";
//	private final String userKey="?user_key=74a8c97218467ccad8668a06d96c7509";
	@Value("${charity.url}")
	private String url;
	@Value("${charity.userKey}")
	private String userKey;
	
	
	
	/**
	 * @param searchTO
	 * @return ResponseEntity<String>
	 * @throws CharityNotFoundException
	 */
	public ResponseEntity<String> findCharityBySearchTerms(SearchTO searchTO) throws CharityNotFoundException{
				
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String parameters = getParametersFromObject(searchTO);
		HttpEntity<?> entity = new HttpEntity<>(headers);
						
		ResponseEntity<String> responseEntity = restTemplate.exchange(url+userKey+parameters, HttpMethod.GET, entity, String.class);
		
		if(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND))
			throw new CharityNotFoundException("Charity Not Found");
		
		return  responseEntity;
	}

	/**
	 * @param searchTO
	 * @return String
	 */
	private String getParametersFromObject(SearchTO searchTO) {
		String parameters = "";
		
		if(searchTO.getCategory() != null)
			parameters += "&category=" + searchTO.getCategory();
		if(searchTO.getCity() != null)
			parameters += "&city=" + searchTO.getCity();	
		if(searchTO.getState() != null)
			parameters += "&state=" + searchTO.getState();
		if(searchTO.getSearchTerm() != null)
			parameters += "&searchTerm=" + searchTO.getSearchTerm();
		
		return parameters;
	}
	
	
	
	
}
