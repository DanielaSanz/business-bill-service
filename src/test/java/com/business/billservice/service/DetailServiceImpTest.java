package com.business.billservice.service;

import com.business.billservice.mapper.BillDetailsDTOMapper;
import com.business.billservice.model.dto.DetailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class DetailServiceImpTest {

     private final Integer VALID_ID = 1;
     private final DetailDTO detailDTO1 = new DetailDTO("Termo", 1 , 2100.00, 2100.00);
     private final DetailDTO detailDTO2 = new DetailDTO("Mate", 2 , 510.00, 459.00);
     private final DetailDTO detailDTO3 = new DetailDTO("Bombilla", 1 , 820.00, 656.00);

     private final List<DetailDTO> detailDTOS = Arrays.asList(detailDTO1, detailDTO2, detailDTO3);

     @InjectMocks
     DetailServiceImp sut;

     @Mock
     BillDetailsDTOMapper billDetailsDTOMapper;

     @BeforeEach
     public void setUp(){
         MockitoAnnotations.initMocks(this);
     }

    @Test
    @DisplayName("When IdBill Validate Return ListDetailDTO")
    void obtainDetailDTO() {

         when(billDetailsDTOMapper.obtainBillDetails(VALID_ID)).thenReturn(detailDTOS);
        List<DetailDTO> detailDTOList = sut.obtainDetails(VALID_ID);

        assertThat(detailDTOList.toString(), is(detailDTOS.toString()));
        assertThat(detailDTOList.get(1).getDescription(), is(detailDTOS.get(1).getDescription()));
    }

}