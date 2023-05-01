package com.monzoni.melodim_project.dto.response.album;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlbumResponse {

    private Integer id;
    private String name;
    private String description;
    private LocalDate releaseDate;
}
