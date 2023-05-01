package com.monzoni.melodim_project.dto.response.member;

import com.monzoni.melodim_project.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberResponse extends CommonResponse {
    private MemberResponse memberResponse;
}
