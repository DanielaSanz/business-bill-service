package com.business.billservice.validator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidatorIdNumber implements Validator<Integer>{

    private final String EXCEPTION_MESSAGE = "El número de factura no puede ser nulo ni menor o igual a 0";
    @Override
    public void validate(Integer idBill) {
        Optional.ofNullable(idBill)
                .filter(i -> i > 0)
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE));
    }
}
