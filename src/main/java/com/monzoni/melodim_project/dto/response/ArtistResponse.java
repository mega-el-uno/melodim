package com.monzoni.melodim_project.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ArtistResponse {
    private Integer id;
    private String name;
    private String type;
    private LocalDate creationDate;
}
