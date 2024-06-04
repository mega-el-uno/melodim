package com.monzoni.melodim_project.dto.response;

import com.monzoni.melodim_project.dto.response.song.PageResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationResponse<T> {
    private List<T> items;
    private PageResponse page;
}
