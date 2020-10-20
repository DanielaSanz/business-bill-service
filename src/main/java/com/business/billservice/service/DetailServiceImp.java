package com.business.billservice.service;

import com.business.billservice.mapper.BillDetailsDTOMapper;
import com.business.billservice.model.dto.DetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImp implements DetailService {

    private final BillDetailsDTOMapper detailsDTOMapper;

    @Autowired
    public DetailServiceImp(BillDetailsDTOMapper detailsDTOMapper) {
        this.detailsDTOMapper = detailsDTOMapper;
    }

    @Override
    public List<DetailDTO> obtainDetails(Integer idBill) {
        return detailsDTOMapper.obtainBillDetails(idBill);
    }
}
