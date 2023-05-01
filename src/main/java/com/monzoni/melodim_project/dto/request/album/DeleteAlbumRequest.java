package com.monzoni.melodim_project.dto.request.album;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DeleteAlbumRequest {
    @NotNull
    private Integer id;
}
