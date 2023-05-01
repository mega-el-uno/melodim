package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.util.constant.ResponseConstant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {ResponseConstant.SuccessResponse.class})
public class AlbumMapper {
}
