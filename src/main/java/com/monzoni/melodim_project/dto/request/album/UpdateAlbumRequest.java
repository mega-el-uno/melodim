package com.monzoni.melodim_project.dto.request.album;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateAlbumRequest {
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    private String description;
    private LocalDate releaseDate;
}
