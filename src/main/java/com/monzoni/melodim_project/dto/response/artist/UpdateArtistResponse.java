package com.monzoni.melodim_project.dto.response.artist;

import com.monzoni.melodim_project.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArtistResponse extends CommonResponse {
    private ArtistResponse artistResponse;
}
