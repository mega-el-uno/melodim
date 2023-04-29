package com.monzoni.melodim_project.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class CreateArtistResponse extends CommonResponse{
    ArtistResponse artistResponse;
}
