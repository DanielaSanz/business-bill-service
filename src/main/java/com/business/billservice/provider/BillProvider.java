package com.business.billservice.provider;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.dto.BillDTO;
import com.business.billservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BillProvider implements Function<Integer, BillResponse> {

    private final BillService billService;
    private final Function<BillDTO, BillResponse> billAdapter;

    @Autowired
    public BillProvider(BillService billService, Function<BillDTO, BillResponse> billAdapter) {
        this.billService = billService;
        this.billAdapter = billAdapter;
    }

    @Override
    public BillResponse apply(Integer idBill) {
        BillDTO billDTO = billService.obtainBill(idBill);
        return billAdapter.apply(billDTO);
    }
}
