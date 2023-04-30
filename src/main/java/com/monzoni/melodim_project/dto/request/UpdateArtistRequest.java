package com.monzoni.melodim_project.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateArtistRequest {
    private String name;
    private String type;
}
