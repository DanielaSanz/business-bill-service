package com.business.billservice.mapper;

import com.business.billservice.model.dto.DetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BillDetailsDTOMapper {

    List<DetailDTO> obtainBillDetails(@Param("idBill")Integer idBill);
}
