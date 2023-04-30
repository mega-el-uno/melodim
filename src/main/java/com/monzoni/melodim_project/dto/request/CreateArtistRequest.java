package com.monzoni.melodim_project.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class CreateArtistRequest {
    @NotEmpty(message = "The name can't be empty")
    private String name;
    private String type;
    private LocalDate creationDate;
}
