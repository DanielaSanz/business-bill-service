package com.business.billservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Detail {
    private String description;
    private Integer amount;
    private Double salePrice;
    private Double saleRebate;
    private Double grossTotal;
    private Double netTotal;
}
