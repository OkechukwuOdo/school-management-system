package com.justintime.schoolmanagement.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FeeSchedule {
    @Id
    private String id;

    private String academicYear;   // e.g., "2024/2025"
    private String semester;       // e.g., "First Semester"

    private String facultyId;
    private String departmentId;
    private String level;          // "100L", "SS2"

    private BigDecimal tuitionFee = BigDecimal.ZERO;
    private BigDecimal departmentFee = BigDecimal.ZERO;
    private BigDecimal facultyFee = BigDecimal.ZERO;
    private BigDecimal hostelFee = BigDecimal.ZERO;
    private BigDecimal examFee = BigDecimal.ZERO;
    private BigDecimal labFee = BigDecimal.ZERO;
    private BigDecimal otherCharges = BigDecimal.ZERO;

    private BigDecimal totalFee;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
