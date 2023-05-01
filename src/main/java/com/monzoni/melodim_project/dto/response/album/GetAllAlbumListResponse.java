package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.dto.response.artist.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllAlbumListResponse extends CommonResponse {
    private AlbumResponse albumResponse;
}
