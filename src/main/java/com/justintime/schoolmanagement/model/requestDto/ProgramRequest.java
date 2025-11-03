package com.justintime.schoolmanagement.model.requestDto;

import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramRequest {
    private String imageLink;
    private String title;
    private String detail;
    private double purchasePrice;
    private SchoolCategory programType;
}
