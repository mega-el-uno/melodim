package com.monzoni.melodim_project.dto.response.member;

import com.monzoni.melodim_project.exception.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllMemberListResponse extends ExceptionResponse {
    private List<MemberResponse> memberResponseList;
}
