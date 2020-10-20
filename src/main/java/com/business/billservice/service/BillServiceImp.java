package com.business.billservice.service;

import com.business.billservice.mapper.BillDTOMapper;
import com.business.billservice.model.dto.BillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImp implements BillService {

    private final BillDTOMapper billDTOMapper;

    @Autowired
    public BillServiceImp(BillDTOMapper billDTOMapper) {
        this.billDTOMapper = billDTOMapper;
    }

    @Override
    public BillDTO obtainBill(Integer idBill) {
        return billDTOMapper.obtainBill(idBill);
    }
}
