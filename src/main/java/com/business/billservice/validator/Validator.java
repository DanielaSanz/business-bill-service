package com.business.billservice.validator;

public interface Validator<T> {
	void validate(T request);
}
