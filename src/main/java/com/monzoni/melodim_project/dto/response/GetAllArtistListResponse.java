package com.monzoni.melodim_project.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllArtistListResponse extends CommonResponse {
    List<ArtistResponse> artistResponseList;
}
