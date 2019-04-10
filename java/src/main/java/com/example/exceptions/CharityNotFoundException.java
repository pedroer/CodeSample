package com.example.exceptions;

public class CharityNotFoundException extends Exception {

	private static final long serialVersionUID = 7455831154519564924L;

	public CharityNotFoundException(String message) {
        super(message);
    }
}
