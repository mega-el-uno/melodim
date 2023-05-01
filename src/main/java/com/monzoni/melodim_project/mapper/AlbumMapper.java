package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.*;
import com.monzoni.melodim_project.repository.entity.AlbumEntity;
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


    default CreateAlbumResponse mapperToCreateAlbumResponse(AlbumResponse albumResponse) {
        return toCreateAlbumResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, albumResponse);
    }

    CreateAlbumResponse toCreateAlbumResponse(String code, String message, AlbumResponse albumResponse);

    default UpdateAlbumResponse mapperToUpdateAlbumResponse(AlbumResponse albumResponse) {
        return toUpdateAlbumResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, albumResponse);
    }

    UpdateAlbumResponse toUpdateAlbumResponse(String code, String message, AlbumResponse albumResponse);

    default DeleteAlbumResponse mapperToDeleteAlbumResponse(AlbumResponse albumResponse) {
        return toDeleteAlbumResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, albumResponse);
    }

    DeleteAlbumResponse toDeleteAlbumResponse(String code, String message, AlbumResponse albumResponse);

}
