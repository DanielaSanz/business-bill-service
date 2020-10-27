package com.business.billservice.builder;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DetailBuilder implements Function<DetailDTO, Detail> {

    @Override
    public Detail apply(DetailDTO dto) {
        double grossTotal = dto.getAmount() * dto.getSalePrice();
        double netTotal = dto.getAmount() * dto.getSaleRebate();
         return new Detail(dto.getDescription(),
                dto.getAmount(),
                dto.getSalePrice(),
                dto.getSaleRebate(),
                grossTotal, netTotal);
    }
}
