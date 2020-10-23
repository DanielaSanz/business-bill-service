package com.business.billservice.builder;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DetailsBuilderTest {

    private final List<DetailDTO> VALID_DTO_DETAILS = Arrays.asList(new DetailDTO("Mate", 2 ,
                                                        510.00, 459.00));
    private final Double EXPECTED_GROSS_TOTAL = 1020.00;
    private final Double EXPECTED_NET_TOTAL = 918.00;

    @Test
    public void obtainListDetail1() {

        DetailsBuilder detailsBuilder = new DetailsBuilder();

        List<Detail> detailsList = detailsBuilder.apply(VALID_DTO_DETAILS);

        assertThat(detailsList.get(0).getGrossTotal(), is(EXPECTED_GROSS_TOTAL));
        assertThat(detailsList.get(0).getNetTotal(), is(EXPECTED_NET_TOTAL));
    }
}