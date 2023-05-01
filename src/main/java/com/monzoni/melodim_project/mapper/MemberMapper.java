package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.util.constant.ResponseConstant.SuccessResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {SuccessResponse.class})
public class MemberMapper {
}
