package com.business.billservice.adapter;

import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.DetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class DetailsAdapter implements Function<List<DetailDTO>, List<Detail>> {

    private final Function<DetailDTO, Detail> detailAdapter;

    @Autowired
    public DetailsAdapter(Function<DetailDTO, Detail> detailAdapter) {
        this.detailAdapter = detailAdapter;
    }


    @Override
    public List<Detail> apply(List<DetailDTO> detailDTOS) {
        List<Detail> details = new ArrayList<>();
        for(DetailDTO dto : detailDTOS ){
            Detail detail = detailAdapter.apply(dto);
            details.add(detail);
        }
        return details;
    }
}
