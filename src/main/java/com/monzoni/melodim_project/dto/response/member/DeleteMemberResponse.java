package com.monzoni.melodim_project.dto.response.member;

import com.monzoni.melodim_project.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteMemberResponse extends CommonResponse {
    private MemberResponse memberResponse;
}
