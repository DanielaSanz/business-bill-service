package com.business.billservice.controller;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.Detail;
import com.business.billservice.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BillControllerTest {

    private final Integer VALID_ID = 1;
    private final String BAD_REQUEST_MESSAGE = "El número de factura no puede ser nulo ni menor o igual a 0";
    private final Detail VALID_DETAIL = Detail.builder().build();
    private final List<Detail> VALID_DETAILS = Arrays.asList(VALID_DETAIL);

    private final BillResponse VALID_BILL_RESPONSE = BillResponse.builder()
            .idBill(1)
            .billNumber("1")
            .billDate("22/09/2020")
            .name("Daniela")
            .details(VALID_DETAILS)
            .iva(1.105)
            .rebateTotal(3674.00)
            .grossTotal(3940.00)
            .netTotal(4059.77)
            .build();

    static class IdArgumentSource implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(null, -1, 0).map(Arguments::of);
        }
    }

    @ParameterizedTest
    @ArgumentsSource(IdArgumentSource.class)
    void obtainBill_IdBillIsNullOrLessZero_ReturnsBadRequest(Integer idBill) {

        Validator<Integer> validatorIdNumber = request -> {throw new IllegalArgumentException(BAD_REQUEST_MESSAGE);};
        BillController billController = new BillController(validatorIdNumber,null);

        ResponseEntity<BillResponse> responseEntity = billController.obtainBill(idBill);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        assertThat(responseEntity.getBody().getErrorMessage(), is(BAD_REQUEST_MESSAGE));
    }

    @Test
    void obtainBill_ThrowsException_ReturnsInternalServerError() {
        Validator<Integer> validatorIdNumber = request -> {};
        Function<Integer, BillResponse> billSupplier = response -> {throw new RuntimeException();};
        BillController billController = new BillController(validatorIdNumber, billSupplier);

        final ResponseEntity<BillResponse> responseEntity = billController.obtainBill(VALID_ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    void obtainBill_NoCaughtException_ReturnsOK() {
        Validator<Integer> validatorIdNumber = request -> {};
        Function<Integer, BillResponse> billSupplier = response -> VALID_BILL_RESPONSE;
        BillController billController = new BillController(validatorIdNumber, billSupplier);

        final ResponseEntity<BillResponse> responseEntity = billController.obtainBill(VALID_ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), is (VALID_BILL_RESPONSE));
    }
}
