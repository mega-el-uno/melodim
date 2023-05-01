package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.dto.response.artist.CommonResponse;
import com.monzoni.melodim_project.repository.AlbumRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class GetAllAlbumListResponse extends CommonResponse {
    private AlbumResponse albumResponse;
}
