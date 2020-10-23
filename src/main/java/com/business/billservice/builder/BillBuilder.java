package com.business.billservice.builder;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.model.Detail;
import com.business.billservice.model.dto.BillDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class BillBuilder implements Function<BillDTO, BillResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillBuilder.class);
    private final Function<Integer, List<Detail>> billDetails;

    @Autowired
    public BillBuilder(Function<Integer, List<Detail>> billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public BillResponse apply(BillDTO billDTO) {
        final List<Detail> details = billDetails.apply(billDTO.getIdBill());
        final Double billRebateTotal = obtainRebateTotal(details);
        final Double billGrossTotal = obtainGrossTotal(details);
        final Double billNetTotal = billRebateTotal * billDTO.getIva();
        LOGGER.info("Se obtuvo el detalle de la factura id = {}", billDTO.getIdBill());
        return new BillResponse(billDTO.getIdBill(),
                billDTO.getBillNumber(),
                billDTO.getBillDate(),
                billDTO.getName(),
                billDTO.getSurname(),
                details,
                billDTO.getIva(),
                billRebateTotal,
                billGrossTotal,
                billNetTotal);
    }

    private Double obtainRebateTotal(List<Detail> details){
        Double rebateTotal = 0.0;
        for (Detail d : details){
            rebateTotal+=d.getNetTotal();
        }
        return rebateTotal;
    }

    private Double obtainGrossTotal(List<Detail> details){
        Double total = 0.0;
        for (Detail d : details){
            total+=d.getGrossTotal();
        }
        return total;
    }
}
