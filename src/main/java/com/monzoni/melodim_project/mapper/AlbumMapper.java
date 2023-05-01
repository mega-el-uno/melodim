package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.*;
import com.monzoni.melodim_project.dto.response.artist.UpdateArtistResponse;
import com.monzoni.melodim_project.repository.entity.AlbumEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {ResponseConstant.SuccessResponse.class})
public interface AlbumMapper {
    AlbumResponse mapperToAlbumResponse(AlbumEntity source);
    AlbumEntity mapperToAlbumEntity(CreateAlbumRequest source);
    void mapperToAlbumEntity(UpdateAlbumRequest source,@MappingTarget AlbumEntity target);

    default GetAllAlbumListResponse mapperToGetAllAlbumListResponse(List<AlbumResponse> albumResponseList) {
        return toGetAllAlbumListResponse(ResponseConstant.SuccessResponse.CODE, ResponseConstant.SuccessResponse.MESSAGE, albumResponseList);
    }
    GetAllAlbumListResponse toGetAllAlbumListResponse(String code, String message, List<AlbumResponse> albumResponseList);


    default CreateAlbumResponse mapperToCreateAlbumResponse(AlbumResponse albumResponse) {
        return toCreateAlbumResponse(ResponseConstant.SuccessResponse.CODE, ResponseConstant.SuccessResponse.MESSAGE, albumResponse);
    }
    CreateAlbumResponse toCreateAlbumResponse(String code, String message, AlbumResponse albumResponse);

    default UpdateAlbumResponse mapperToUpdateAlbumResponse(AlbumResponse albumResponse) {
        return toUpdateAlbumResponse(ResponseConstant.SuccessResponse.CODE, ResponseConstant.SuccessResponse.MESSAGE, albumResponse);
    }
    UpdateAlbumResponse toUpdateAlbumResponse(String code, String message, AlbumResponse albumResponse);

    default DeleteAlbumResponse mapperToDeleteAlbumResponse(AlbumResponse albumResponse) {
        return toDeleteAlbumResponse(ResponseConstant.SuccessResponse.CODE, ResponseConstant.SuccessResponse.MESSAGE, albumResponse);
    }
    DeleteAlbumResponse toDeleteAlbumResponse(String code, String message, AlbumResponse albumResponse);

}
