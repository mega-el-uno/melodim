package com.monzoni.melodim_project.dto.request.album;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateAlbumRequest {
    private String name;
    private String description;
    private LocalDate releaseDate;
}
