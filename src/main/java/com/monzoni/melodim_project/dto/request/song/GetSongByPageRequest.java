package com.monzoni.melodim_project.dto.request.song;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetSongByPageRequest {

    private Integer page;
    private Integer size;
    private Integer id;
    private String title;

}
