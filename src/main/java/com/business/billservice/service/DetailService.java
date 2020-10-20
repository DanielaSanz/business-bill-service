package com.business.billservice.service;

import com.business.billservice.model.dto.DetailDTO;

import java.util.List;

public interface DetailService {
    List<DetailDTO> obtainDetails(Integer idBill);
}
