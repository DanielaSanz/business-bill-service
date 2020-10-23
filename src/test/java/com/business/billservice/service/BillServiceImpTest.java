package com.business.billservice.service;

import com.business.billservice.mapper.BillDTOMapper;
import com.business.billservice.model.dto.BillDTO;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BillServiceImpTest {

    private final Integer VALID_ID = 1;
    private final BillDTO VALID_BILL_DTO = new BillDTO(1,"1","22/09/2020",
                                                "Daniela","Sanchez",1.105);

    @Test
    public void obtainBillDTO() {

        BillDTOMapper billDTOMapper = idBill -> VALID_BILL_DTO;
        BillServiceImp sut = new BillServiceImp(billDTOMapper);

        BillDTO response = sut.obtainBill(VALID_ID);

        assertThat(response.toString(), is(VALID_BILL_DTO.toString()));
    }
}