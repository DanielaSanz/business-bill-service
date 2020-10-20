package com.business.billservice.service;

import com.business.billservice.model.dto.BillDTO;

public interface BillService {
    BillDTO obtainBill(Integer idBill);
}
