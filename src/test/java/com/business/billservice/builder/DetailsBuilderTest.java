package com.business.billservice.builder;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DetailsBuilderTest {

    private final DetailDTO detailDTO1 = new DetailDTO("Termo", 1 , 2100.00, 2100.00);
    private final DetailDTO detailDTO2 = new DetailDTO("Mate", 2 , 510.00, 459.00);
    private final DetailDTO detailDTO3 = new DetailDTO("Bombilla", 1 , 820.00, 656.00);

    private final List<DetailDTO> detailDTOS = Arrays.asList(detailDTO1, detailDTO2, detailDTO3);

    private final Detail detail1 = new Detail("Termo", 1 , 2100.00, 2100.00, 2100.00, 2100.00 );
    private final Detail detail2 = new Detail("Mate", 2 , 510.00, 459.00, 1020.00, 918.00);
    private final Detail detail3 = new Detail("Bombilla", 1 , 820.00, 656.00, 820.00, 656.00);

    private final List<Detail> details = Arrays.asList(detail1, detail2, detail3);

    @InjectMocks
    DetailsBuilder sut;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtainListDetail() {

        List<Detail> details = sut.apply(detailDTOS);

        assertThat(details.get(1).getDescription(), is(detailDTOS.get(1).getDescription()));
    }

    @Test
    public void obtainListDetail1() {

        //No sabía cual era mejor de hacer

        Function<List<DetailDTO>, List<Detail>> builder = param -> details;

        DetailsBuilder sut = new DetailsBuilder();
        List<Detail> details = sut.apply(detailDTOS);

        assertThat(details.get(1).getDescription(), is(detailDTOS.get(1).getDescription()));
    }

}