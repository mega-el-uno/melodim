package com.monzoni.melodim_project.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationResponse<T> {
    private List<T> items;
    private Integer number;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
