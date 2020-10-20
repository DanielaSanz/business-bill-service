package com.business.billservice.builder;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class DetailsBuilder implements Function<List<DetailDTO>, List<Detail>> {

    @Override
    public List<Detail> apply(List<DetailDTO> detailDTOS) {
        List<Detail> details = new ArrayList<>();
        for(DetailDTO dto : detailDTOS ){
            Detail detail = builderDetail(dto);
            details.add(detail);
        }
        return details;
    }

    private Detail builderDetail (DetailDTO dto){
        return new Detail(dto.getDescription(),
                dto.getAmount(),
                dto.getSalePrice(),
                dto.getSaleRebate(),
                dto.obtainGrossTotal(),
                dto.obtainNetTotal());
    }
}
