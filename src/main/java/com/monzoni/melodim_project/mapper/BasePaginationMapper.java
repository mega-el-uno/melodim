package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.response.PaginationResponse;
import org.springframework.data.domain.Page;

public class BasePaginationMapper {
    public static <T, K> PaginationResponse<T> setPageMetadata(PaginationResponse<T> response, Page<K> page) {
        response.setSize(page.getSize());
        response.setPage(page.getNumber() + 1);
        response.setTotalPage(page.getTotalPages());
        response.setTotalItems(page.getTotalElements());
        return response;
    }
}
