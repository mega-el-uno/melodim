package com.monzoni.melodim_project.dto.request.song;

import com.monzoni.melodim_project.controller.SortDirection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetSongByPageRequest {

    private Integer page;
    private Integer size;
    private String title;
    private SortDirection direction;
    private String order;
    private String artist;
    private String album;
    private String genre;
}
