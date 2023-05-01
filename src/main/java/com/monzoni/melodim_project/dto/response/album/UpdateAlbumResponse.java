package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAlbumResponse extends CommonResponse {
    private AlbumResponse albumResponse;
}
