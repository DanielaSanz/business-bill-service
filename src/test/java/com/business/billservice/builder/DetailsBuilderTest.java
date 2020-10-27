package com.business.billservice.builder;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DetailsBuilderTest {

    private final List<DetailDTO> VALID_DTO_DETAILS = Arrays.asList(new DetailDTO("Mate", 2 ,
                                                        510.00, 459.00));
    private final Detail VALID_DETAIL = new Detail("Mate", 2 ,
            510.00, 459.00, 1020.00, 918.00);

    @Test
    public void obtainListDetail1() {

        Function<DetailDTO, Detail> detailDtoBuilder = param -> VALID_DETAIL;
        DetailsBuilder detailsBuilder = new DetailsBuilder(detailDtoBuilder);

        List<Detail> detailsList = detailsBuilder.apply(VALID_DTO_DETAILS);

        assertThat(detailsList.get(0).getGrossTotal(), is(VALID_DETAIL.getGrossTotal()));
        assertThat(detailsList.get(0).getNetTotal(), is(VALID_DETAIL.getNetTotal()));
    }
}