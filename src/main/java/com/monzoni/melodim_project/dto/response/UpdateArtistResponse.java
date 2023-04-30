package com.monzoni.melodim_project.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArtistResponse extends CommonResponse{
    private ArtistResponse artistResponse;
}
