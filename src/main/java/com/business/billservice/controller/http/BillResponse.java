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

    public BillResponse(String errorMessage, Integer idBill, String billNumber, String billDate, String name,
                        String surname, List<Detail> details, Double iva, Double rebateTotal, Double grossTotal, Double netTotal) {
        super(errorMessage);
        this.idBill = idBill;
        this.billNumber = billNumber;
        this.billDate = billDate;
        this.name = name;
        this.surname = surname;
        this.details = details;
        this.iva = iva;
        this.rebateTotal = rebateTotal;
        this.grossTotal = grossTotal;
        this.netTotal = netTotal;
    }
}
