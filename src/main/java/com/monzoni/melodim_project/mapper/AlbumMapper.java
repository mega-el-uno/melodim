package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.GetAllArtistListResponse;
import com.monzoni.melodim_project.repository.entity.AlbumEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {ResponseConstant.SuccessResponse.class})
public interface AlbumMapper {
    AlbumResponse mapperToAlbumResponse(AlbumEntity source);

    default GetAllAlbumListResponse mapperToGetAllAlbumListResponse(List<AlbumResponse> albumResponseList) {
        return toGetAllAlbumListResponse(ResponseConstant.SuccessResponse.CODE, ResponseConstant.SuccessResponse.MESSAGE, albumResponseList);
    }
    GetAllAlbumListResponse toGetAllAlbumListResponse(String code, String message, List<AlbumResponse> albumResponseList);
}
