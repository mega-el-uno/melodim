package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import com.monzoni.melodim_project.model.entity.AlbumEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant.SuccessResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {SuccessResponse.class})
public interface AlbumMapper {
    AlbumResponse mapperToAlbumResponse(AlbumEntity source);

    AlbumEntity mapperToAlbumEntity(CreateAlbumRequest source);

    void mapperToAlbumEntity(UpdateAlbumRequest source, @MappingTarget AlbumEntity target);

    default GetAllAlbumListResponse mapperToGetAllAlbumListResponse(List<AlbumResponse> albumResponseList) {
        return toGetAllAlbumListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, albumResponseList);
    }

    GetAllAlbumListResponse toGetAllAlbumListResponse(String code, String message, List<AlbumResponse> albumResponseList);
}
