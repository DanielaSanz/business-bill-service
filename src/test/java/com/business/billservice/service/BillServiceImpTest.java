package com.business.billservice.service;

import com.business.billservice.mapper.BillDTOMapper;
import com.business.billservice.model.dto.BillDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class BillServiceImpTest {

    private final Integer VALID_ID = 1;
    private final BillDTO billDTO = new BillDTO(1,"1","22/09/2020","Daniela","Sanchez",1.105);

    @InjectMocks
    BillServiceImp sut;

    @Mock
    BillDTOMapper billDTOMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("When IdBill Validate Return BillDTO")
    public void obtainBillDTO() {

        when(billDTOMapper.obtainBill(VALID_ID)).thenReturn(billDTO);

        BillDTO bill = sut.obtainBill(VALID_ID);

        assertThat(bill.toString(), is(billDTO.toString()));
        assertThat(bill.getIdBill(), is(billDTO.getIdBill()));

    }
}