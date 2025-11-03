package com.justintime.schoolmanagement.model.responseDto;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String freshToken;
    private List<AppUserRole> role;
    private String  email;

}
