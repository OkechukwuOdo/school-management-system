package com.justintime.schoolmanagement.utilz.objectMapper;

import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.model.responseDto.ProgramResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramMapper {
    public static ProgramResponseDto programResponseDtoInstance(Program program){
        return ProgramResponseDto.builder()
                .id(program.getId())
                .title(program.getTitle())
                .programType(program.getProgramType())
                .purchasePrice(program.getPurchasePrice())
                .imageLink(program.getImageLink())
                .build();
    }
}
