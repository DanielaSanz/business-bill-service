package com.business.billservice.service;

import com.business.billservice.mapper.BillDetailsDTOMapper;
import com.business.billservice.model.dto.DetailDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DetailServiceImpTest {

    private final Integer VALID_ID = 1;
    private final List<DetailDTO> detailDTOS = Arrays.asList(
            new DetailDTO("Termo", 1 , 2100.00, 2100.00),
            new DetailDTO("Mate", 2 , 510.00, 459.00),
            new DetailDTO("Bombilla", 1 , 820.00, 656.00)
    );

    @Test
    void obtainDetailDTO() {
        BillDetailsDTOMapper billDetailsDTOMapper = idBill -> detailDTOS;
        DetailServiceImp sut = new DetailServiceImp(billDetailsDTOMapper);

        List<DetailDTO> detailDTOList = sut.obtainDetails(VALID_ID);

        assertThat(detailDTOList.toString(), is(detailDTOS.toString()));
    }
}