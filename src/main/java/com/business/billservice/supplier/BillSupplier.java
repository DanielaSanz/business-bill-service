package com.business.billservice.supplier;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.dto.BillDTO;
import com.business.billservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BillSupplier implements Function<Integer, BillResponse> {

    private final BillService billService;
    private final Function<BillDTO, BillResponse> billBuilder;

    @Autowired
    public BillSupplier(BillService billService, Function<BillDTO, BillResponse> billBuilder) {
        this.billService = billService;
        this.billBuilder = billBuilder;
    }

    @Override
    public BillResponse apply(Integer idBill) {
        BillDTO billDTO = billService.obtainBill(idBill);
        return billBuilder.apply(billDTO);
    }
}
