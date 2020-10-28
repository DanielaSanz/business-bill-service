package com.business.billservice.provider;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.dto.BillDTO;
import com.business.billservice.service.BillService;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BillProviderTest {

    private final Integer VALID_ID = 1;
    private final BillDTO VALID_BILL_DTO = BillDTO.builder().build();
    private final BillResponse VALID_RESPONSE = BillResponse.builder().build();

    @Test
    void obtainBillResponse(){

        BillService billService = idBill -> VALID_BILL_DTO;
        Function<BillDTO, BillResponse> billAdapter = param -> VALID_RESPONSE;
        BillProvider sut = new BillProvider(billService, billAdapter);

        BillResponse response = sut.apply(VALID_ID);

        assertThat(response.toString(), is(VALID_RESPONSE.toString()));
    }
}