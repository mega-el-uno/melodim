package com.monzoni.melodim_project.dto.response.artist;

import com.monzoni.melodim_project.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArtistResponse extends CommonResponse {
    ArtistResponse artistResponse;
}
