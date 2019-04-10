package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.exceptions.CharityNotFoundException;
import com.example.model.CharityList;
import com.example.model.to.ResponseCharityTO;
import com.example.model.to.SearchTO;
import com.example.rest.CategoryResource;
import com.example.rest.CharityResource;
import com.example.rest.StateResource;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharityApplicationTests {
	
	@Value("${charity.url}")
	private String url;
	@Value("${charity.userKey}")
	private String userKey;
	
	@Test
	public void contextLoads() {
	}
	
	 @Test
	 public void categoriesSizeTest() {	       
	    CategoryResource resource = new CategoryResource();
	    assertEquals(26, resource.getCategories().size());
	 }
	 
	 @Test
	 public void statesSizeTest() {	       
	    StateResource resource = new StateResource();
	    assertEquals(50, resource.getStates().size());
	 }
	 
	 @Test
	 public void externalApiTestConnectionAndResult() throws CharityNotFoundException {	       
	    SearchTO searchTO = new SearchTO();
	    searchTO.setState("AL");
	    searchTO.setCity("TUSCALOOSA");
	    searchTO.setSearchTerm("BLACK WARRIOR STUDIO AND GALLERY");
	    searchTO.setCategory(null);
	 	RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String parameters = getParametersFromObject(searchTO);
		HttpEntity<?> entity = new HttpEntity<>(headers);						
		ResponseEntity<String> responseEntity = restTemplate.exchange(url+userKey+parameters, HttpMethod.GET, entity, String.class);			
		Gson gson = new Gson();
		ResponseCharityTO responseC = gson.fromJson(responseEntity.getBody(), ResponseCharityTO.class);
		List<CharityList> charities = responseC.getData();
		assertEquals(1, charities.size());		 
	 }
	 
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
