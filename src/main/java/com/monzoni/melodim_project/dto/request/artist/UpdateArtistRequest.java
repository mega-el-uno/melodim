package com.monzoni.melodim_project.dto.request.artist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArtistRequest {
    private Integer id;
    private String name;
    private String type;
}
