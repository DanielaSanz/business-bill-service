package com.business.billservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BillDTO {
    private Integer idBill;
    private String billNumber;
    private String billDate;
    private String name;
    private String surname;
    private Double iva;
}
