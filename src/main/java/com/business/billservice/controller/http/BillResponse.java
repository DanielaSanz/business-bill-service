package com.business.billservice.controller.http;

import com.business.billservice.model.Detail;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillResponse extends GenericResponse{
    private Integer idBill;
    private String billNumber;
    private String billDate;
    private String name;
    private String surname;
    private List<Detail> details;
    private Double iva;
    private Double rebateTotal;
    private Double grossTotal;
    private Double netTotal;
    
}
