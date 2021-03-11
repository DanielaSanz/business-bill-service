package com.business.billservice.adapter;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.BillDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BillAdapterTest {

    private final BillDTO VALID_BILL_DTO = BillDTO.builder().iva(1.105).build();

    private final List<Detail> VALID_DETAILS = Arrays.asList(
            new Detail("Termo", 1 , 2100.00, 2100.00, 2100.00, 2100.00),
            new Detail("Mate", 2 , 510.00, 459.00, 1020.00, 918.00),
            new Detail("Bombilla", 1 , 820.00, 656.00, 820.00, 656.00));

    private final Double EXPECTED_REBATE_TOTAL = 3674.00;
    private final Double EXPECTED_GROSS_TOTAL = 3940.00;
    private final Double EXPECTED_NET_TOTAL = 4059.77;

    @Test
    void obtainBillResponse() {

        Function<Integer, List<Detail>> billProvider = param -> VALID_DETAILS;
        BillAdapter billAdapter = new BillAdapter(billProvider);

        BillResponse billResponse = billAdapter.apply(VALID_BILL_DTO);

        assertThat(billResponse.getRebateTotal(), is(EXPECTED_REBATE_TOTAL));
        assertThat(billResponse.getGrossTotal(), is(EXPECTED_GROSS_TOTAL));
        assertThat(billResponse.getNetTotal(), is(EXPECTED_NET_TOTAL));
    }
}