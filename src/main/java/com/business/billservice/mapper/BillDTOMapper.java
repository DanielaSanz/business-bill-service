package com.business.billservice.mapper;

import com.business.billservice.model.dto.BillDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BillDTOMapper {
    BillDTO obtainBill(@Param("idBill") Integer idBill);
}
