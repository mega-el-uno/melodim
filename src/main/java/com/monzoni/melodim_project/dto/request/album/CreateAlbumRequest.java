package com.monzoni.melodim_project.dto.request.album;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateAlbumRequest {
    @NotNull(message = "The name can't be empty")
    private String name;
    private String description;
    @NotNull(message = "The release date can't be empty")
    private LocalDate releaseDate;
}

