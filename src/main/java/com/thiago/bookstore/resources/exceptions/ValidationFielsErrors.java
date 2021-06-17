package com.thiago.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationFielsErrors extends StandardError {

	private List<FieldsMessages> errors = new ArrayList<>();
	
	public ValidationFielsErrors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationFielsErrors(Long timestamp, Integer status, String erro) {
		super(timestamp, status, erro);
		// TODO Auto-generated constructor stub
	}

	public List<FieldsMessages> getErrors() {
		return errors;
	}

	public void setErrors(String fieldName, String message) {
		errors.add(new FieldsMessages(fieldName, message));
	}
}
