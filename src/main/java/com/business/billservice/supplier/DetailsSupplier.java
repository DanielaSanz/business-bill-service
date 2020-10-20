package com.business.billservice.supplier;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import com.business.billservice.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class DetailsSupplier implements Function<Integer, List<Detail>> {
    private final DetailService detailService;
    private final Function<List<DetailDTO>, List<Detail>> detailBuilder;

    @Autowired
    public DetailsSupplier(DetailService detailService, Function<List<DetailDTO>, List<Detail>> detailBuilder) {
        this.detailService = detailService;
        this.detailBuilder = detailBuilder;
    }

    @Override
    public List<Detail> apply(Integer idBill) {
        final List<DetailDTO> detailDTOS = detailService.obtainDetails(idBill);
        return detailBuilder.apply(detailDTOS);
    }
}
