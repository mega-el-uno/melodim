package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.model.entity.MemberEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant.SuccessResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {SuccessResponse.class})
public interface MemberMapper {
    MemberResponse mapperToMemberResponse(MemberEntity source);

    MemberEntity mapperToMemberEntity(CreateMemberRequest createMemberRequest);

    void mapperToMemberEntity(UpdateMemberRequest source, @MappingTarget MemberEntity target);

    default GetAllMemberListResponse mapperToGetAllMemberListResponse(List<MemberResponse> memberResponseList) {
        return toGetAllMemberListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, memberResponseList);
    }

    GetAllMemberListResponse toGetAllMemberListResponse(String code, String message, List<MemberResponse> memberResponseList);

}
