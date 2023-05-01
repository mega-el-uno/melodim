package com.monzoni.melodim_project.dto.request.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateMemberRequest {
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private Integer artistId;
}
