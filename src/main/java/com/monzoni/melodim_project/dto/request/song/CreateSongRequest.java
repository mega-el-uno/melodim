package com.monzoni.melodim_project.dto.request.song;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateSongRequest {

    @NotEmpty(message = "The tittle cannot be empty")
    private String title;

    private String description;

    @NotEmpty(message = "The duration cannot e empty")
    private String duration;

    private LocalDate releaseDate;

    @NotNull
    private Integer artistId;

    @NotNull
    private Integer albumId;

    @NotNull
    private Integer genreId;

}
