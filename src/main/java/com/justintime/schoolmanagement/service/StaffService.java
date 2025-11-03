package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Staff;
import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {
    StaffResponseDto createStaff(StaffRequestDto staffRequestDto);
    String deleteAStaff(String id);
    StaffResponseDto getAStaffById(String staffId);

    PaginationResponse<StaffResponseDto, Staff> getALlStaffByType(String staffType, int offset, int limit);

    PaginationResponse<StaffResponseDto, Staff> getAllStaff(int offset,int limit);
}
