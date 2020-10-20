package com.business.billservice.utils;

import org.springframework.stereotype.Component;

@Component
public class ValidateId {

    public void validateId(Integer idBill) {
        if (idBill == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if(idBill <= 0) {
            throw new IllegalArgumentException("El id no puede ser menor o igual a 0");
        }
    }
}
