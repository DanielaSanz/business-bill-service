package com.business.billservice.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class ValidateIdTest {

    @InjectMocks
    ValidateId sut;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Throws Illegal Argument Exception When IdBill Is Null Or Less Zero")
    public void ValidateIdIsNullOrLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sut.validateId(null));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validateId(-1));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validateId(0));
    }

}