package com.monzoni.melodim_project.dto.request.artist;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UpdateArtistRequest {
    private Integer id;
    @NotEmpty
    private String name;
    private String type;
}
