package com.monzoni.melodim_project.dto.response.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResponse {
    private Integer number;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
