package com.monzoni.melodim_project.dto.response.album;

import com.monzoni.melodim_project.exception.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllAlbumListResponse extends ExceptionResponse {
    private List<AlbumResponse> albumResponseList;
}
