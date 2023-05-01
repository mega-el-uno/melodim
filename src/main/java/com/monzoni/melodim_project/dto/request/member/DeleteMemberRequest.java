package com.monzoni.melodim_project.dto.request.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DeleteMemberRequest {
    @NotNull
    private Integer id;
}
