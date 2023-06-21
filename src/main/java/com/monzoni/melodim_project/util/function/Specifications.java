package com.monzoni.melodim_project.util.function;

import com.monzoni.melodim_project.controller.SortDirection;
import org.springframework.data.domain.Sort;

public class Specifications {

    public static Sort buildSorting(String order, SortDirection direction) {
        Sort sort = Sort.unsorted();
        if (!Utils.isNull(order)) {
            sort = direction.equals(SortDirection.ASC) ? Sort.by(order).ascending() : Sort.by(order).descending();
        }

        return sort;
    }

}
