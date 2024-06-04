package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.response.PaginationResponse;
import com.monzoni.melodim_project.dto.response.song.PageResponse;
import org.springframework.data.domain.Page;

public class BasePaginationMapper {
    public static <T, K> PaginationResponse<T> setPageMetadata(PaginationResponse<T> response, Page<K> page) {
        PageResponse pageResponse = new PageResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());
        response.setPage(pageResponse);
        return response;
    }
}
