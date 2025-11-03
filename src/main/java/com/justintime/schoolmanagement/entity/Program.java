package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "schoolProgram")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Program {
    private String id;
    private String imageLink;
    private String title;
    private String description;
    private BigDecimal purchasePrice;
    private SchoolCategory programType;
}
