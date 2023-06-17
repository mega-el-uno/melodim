package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.exception.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlbumResponse extends ExceptionResponse {
    AlbumResponse albumResponse;
}
