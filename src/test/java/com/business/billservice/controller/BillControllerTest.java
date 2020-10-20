package com.business.billservice.controller;


import com.business.billservice.builder.BillBuilder;
import com.business.billservice.builder.DetailsBuilder;
import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.BillDTO;
import com.business.billservice.model.dto.DetailDTO;
import com.business.billservice.service.DetailServiceImp;
import com.business.billservice.supplier.BillSupplier;
import com.business.billservice.supplier.DetailsSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class BillControllerTest {

    private final Integer VALID_ID = 1;
    private final BillDTO billDTO = new BillDTO(1,"1","22/09/2020", "Daniela", "Sanchez", 1.105);

    private final Detail detail1 = new Detail("Termo", 1 , 2100.00, 2100.00, 2100.00, 2100.00 );
    private final Detail detail2 = new Detail("Mate", 2 , 510.00, 459.00, 1020.00, 918.00);
    private final Detail detail3 = new Detail("Bombilla", 1 , 820.00, 656.00, 820.00, 656.00);

    private final List<Detail> details = Arrays.asList(detail1, detail2, detail3);

    private final BillResponse billResponse = new BillResponse(1,"1","22/09/2020", "Daniela", "Sanchez",
            details, 1.105, 3674.00, 3940.00, 4059.77);

    @InjectMocks
    BillController sut;

    @Mock
    BillSupplier billSupplier;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void obtainBill_NoCaughtException_ReturnsOK() {
/*
        when(billSupplier.apply(VALID_ID)).thenReturn(billResponse);

        ResponseEntity<BillResponse> responseEntity = sut.obtainBill(VALID_ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));*/
    }

    @Test
    void obtainBill_ThrowException_ReturnsInternalServerError() {
        doThrow(new RuntimeException("something bad happened")).when(billSupplier).apply(VALID_ID);

        ResponseEntity<BillResponse> responseEntity = sut.obtainBill(VALID_ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}