package com.business.billservice.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorIdNumberTest {

    @Test
    void validate() {
        ValidatorIdNumber validatorIdNumber = new ValidatorIdNumber();
        assertThrows(IllegalArgumentException.class, ()-> validatorIdNumber.validate(null));
        assertThrows(IllegalArgumentException.class, ()-> validatorIdNumber.validate(0));
        assertThrows(IllegalArgumentException.class, ()-> validatorIdNumber.validate(-1));
    }
}