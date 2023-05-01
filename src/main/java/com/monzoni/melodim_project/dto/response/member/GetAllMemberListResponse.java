package com.monzoni.melodim_project.dto.response.member;

import com.monzoni.melodim_project.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllMemberListResponse extends CommonResponse {
    private List<MemberResponse> memberResponseList;
}
