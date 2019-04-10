package com.example.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Enum.State;
import com.example.model.to.StateTO;

@RestController
@RequestMapping("/state")
public class StateResource {

	/**
	 * Return a list with all the us states
	 * @return List<StateTO>
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@Cacheable(value = "states")
	@GetMapping
	public List<StateTO> getStates() {

		List<StateTO> statesTO = new ArrayList<>();

		Arrays.asList(State.values()).forEach(s -> {
			StateTO state = new StateTO();
			state.setStateKey(s.name());
			state.setStateValue(s.getState());
			statesTO.add(state);
		});

		return statesTO;
	}

}
