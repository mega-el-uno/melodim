package com.monzoni.melodim_project.dto.request.song;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateSongRequest {

    @NotNull(message = "The id cannot be null")
    private Integer id;

    @NotEmpty(message = "The title cannot e empty")
    private String title;

    private String description;

    @NotEmpty(message = "The duration cannot e empty")
    private String duration;

    private LocalDate releaseDate;

    private Integer artistId;

    private Integer albumId;

    private Integer genreId;

}
