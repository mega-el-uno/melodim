package com.monzoni.melodim_project.mapper;


import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.request.song.UpdateSongRequest;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.model.entity.SongEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {ResponseConstant.SuccessResponse.class})
public interface SongMapper {

    SongResponse mapperToSongResponse(SongEntity songEntity);

    SongEntity mapperToSongEntity(CreateSongRequest createSongRequest);

    void mapperToSongEntity(UpdateSongRequest source, @MappingTarget SongEntity target);

}
