package com.business.billservice.provider;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import com.business.billservice.service.DetailService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
class DetailsProviderTest {

    private final Integer VALID_ID = 1;
    private final DetailDTO VALID_DTO_DETAIL = new DetailDTO("Mate", 2 ,510.00,459.00);
    private final List<DetailDTO> VALID_DTO_DETAILS = Arrays.asList(VALID_DTO_DETAIL);
    private final Detail VALID_DETAIL = new Detail("Mate", 2 , 510.00,
            459.00, 1020.00, 918.00);
    private final List<Detail> VALID_DETAILS = Arrays.asList(VALID_DETAIL);

    @Test
    public void obtainListDetail() {

        DetailService detailService = idBill -> VALID_DTO_DETAILS;
        Function<List<DetailDTO>, List<Detail>> detailsAdapter = param -> VALID_DETAILS;
        DetailsProvider sut = new DetailsProvider(detailService, detailsAdapter);

        final List<Detail> detailList = sut.apply(VALID_ID);

        assertThat(detailList.toString(), is(VALID_DETAILS.toString()));
        assertThat(detailList.get(0).getSaleRebate(), is(VALID_DETAIL.getSaleRebate()));
        assertThat(detailList.get(0).getGrossTotal(), is(VALID_DETAIL.getGrossTotal()));
        assertThat(detailList.get(0).getNetTotal(), is(VALID_DETAIL.getNetTotal()));
    }
}