package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "fee_definitions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeType {
    @Id
    private String id;
    private String name;
    private double amount;
    private String level; // Nursery, Primary, Secondary, Tertiary
    private Integer year;
    private String session;
}
