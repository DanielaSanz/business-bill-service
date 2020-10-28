package com.business.billservice.adapter;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DetailAdapterTest {

    private final DetailDTO VALID_DETAIL_DTO = new DetailDTO("Mate", 2 , 510.00, 459.00);

    private final Double EXPECTED_GROSS_TOTAL = 1020.00;
    private final Double EXPECTED_NET_TOTAL = 918.00;

    @Test
    void obtainDetail(){
        DetailAdapter sut = new DetailAdapter();

        Detail detail = sut.apply(VALID_DETAIL_DTO);

        assertThat(detail.getGrossTotal(), is(EXPECTED_GROSS_TOTAL));
        assertThat(detail.getNetTotal(), is(EXPECTED_NET_TOTAL));
    }
}