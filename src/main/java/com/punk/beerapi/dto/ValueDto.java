package com.punk.beerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author marcossilva
 */
@Data
@Builder
@AllArgsConstructor
public class ValueDto {
    private double value;
    private String unit;
}
