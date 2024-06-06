package com.monzoni.melodim_project.dto.response;

import com.monzoni.melodim_project.dto.response.song.PageResponse;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class CommonPaginationResponse {

    private Integer code;
    private String message;
    private SongResponse[] items;
    private PageResponse page;

    public CommonPaginationResponse(PaginationResponse<SongResponse> content) {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.name();
        this.items = content.getItems().toArray(new SongResponse[0]);
        this.page = content.getPage();
    }
}
