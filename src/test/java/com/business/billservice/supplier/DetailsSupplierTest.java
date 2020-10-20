package com.business.billservice.supplier;

import com.business.billservice.builder.DetailsBuilder;
import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import com.business.billservice.service.DetailServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

class DetailsSupplierTest {

    private final Integer VALID_ID = 1;

    private final DetailDTO detailDTO1 = new DetailDTO("Termo", 1 , 2100.00, 2100.00);
    private final DetailDTO detailDTO2 = new DetailDTO("Mate", 2 , 510.00, 459.00);
    private final DetailDTO detailDTO3 = new DetailDTO("Bombilla", 1 , 820.00, 656.00);

    private final List<DetailDTO> detailDTOS = Arrays.asList(detailDTO1, detailDTO2, detailDTO3);

    private final Detail detail1 = new Detail("Termo", 1 , 2100.00, 2100.00, 2100.00, 2100.00 );
    private final Detail detail2 = new Detail("Mate", 2 , 510.00, 459.00, 1020.00, 918.00);
    private final Detail detail3 = new Detail("Bombilla", 1 , 820.00, 656.00, 820.00, 656.00);

    private final List<Detail> details = Arrays.asList(detail1, detail2, detail3);

    @InjectMocks
    DetailsSupplier sut;

    @Mock
    DetailServiceImp detailService;

    @Mock
    DetailsBuilder detailsBuilder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtainListDetail() {

        when(detailService.obtainDetails(VALID_ID)).thenReturn(detailDTOS);
        when(detailsBuilder.apply(detailDTOS)).thenReturn(details);

        List<Detail> detailList = sut.apply(VALID_ID);

        assertThat(detailList.get(1).getDescription(), is(details.get(1).getDescription()));
    }
}