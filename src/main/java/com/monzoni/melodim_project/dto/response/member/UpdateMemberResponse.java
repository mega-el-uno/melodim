package com.monzoni.melodim_project.dto.response.member;

import com.monzoni.melodim_project.exception.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberResponse extends ExceptionResponse {
    private MemberResponse memberResponse;
}
