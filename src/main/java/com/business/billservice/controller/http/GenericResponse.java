package com.business.billservice.controller.http;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenericResponse {

    private String errorMessage;

    public GenericResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
