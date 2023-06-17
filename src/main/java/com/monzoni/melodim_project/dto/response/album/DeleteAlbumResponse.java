package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.exception.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteAlbumResponse extends ExceptionResponse {
    AlbumResponse albumResponse;
}
