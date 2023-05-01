package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.dto.response.artist.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlbumResponse extends CommonResponse {
    AlbumResponse albumResponse;
}
