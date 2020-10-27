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
public class DetailDTO {
    private String description;
    private Integer amount;
    private Double salePrice;
    private Double saleRebate;
}
