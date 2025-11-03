package com.justintime.schoolmanagement.model.responseDto;

import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramResponseDto {
    private String id;
    private String imageLink;
    private String title;
    private String detail;
    private BigDecimal purchasePrice;
    private SchoolCategory programType;

}
