package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.CreateMemberResponse;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.repository.entity.MemberEntity;
import com.monzoni.melodim_project.util.constant.ResponseConstant.SuccessResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {SuccessResponse.class})
public interface MemberMapper {
    MemberResponse mapperToMemberResponse(MemberEntity source);
    MemberEntity mapperToMemberEntity(CreateMemberRequest createMemberRequest);

    default GetAllMemberListResponse mapperToGetAllMemberListResponse(List<MemberResponse> memberResponseList) {
        return toGetAllMemberListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, memberResponseList);
    }
    GetAllMemberListResponse toGetAllMemberListResponse(String code, String message, List<MemberResponse> memberResponseList);

    default CreateMemberResponse mapperToCreateMemberListResponse(MemberResponse memberResponse) {
        return toCreateMemberListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, memberResponse);
    }
    CreateMemberResponse toCreateMemberListResponse(String code, String message, MemberResponse memberResponse);

}
