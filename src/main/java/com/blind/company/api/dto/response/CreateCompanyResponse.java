package com.blind.company.api.dto.response;

import com.blind.shared.api.BaseDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCompanyResponse extends BaseDtoResponse {
    private String id;
}
