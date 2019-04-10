package com.example.model.to;

import java.io.Serializable;

public class StateTO implements Serializable {

	private static final long serialVersionUID = -8082204108406288212L;

	private String stateKey;
	private String stateValue;

	public String getStateKey() {
		return stateKey;
	}

	public void setStateKey(String stateKey) {
		this.stateKey = stateKey;
	}

	public String getStateValue() {
		return stateValue;
	}

	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}

}
