package com.monzoni.melodim_project.mapper;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.*;
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

    default CreateMemberResponse mapperToCreateMemberListResponse(MemberResponse memberResponse) {
        return toCreateMemberListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, memberResponse);
    }
    CreateMemberResponse toCreateMemberListResponse(String code, String message, MemberResponse memberResponse);

    default UpdateMemberResponse mapperToUpdateMemberListResponse(MemberResponse memberResponse) {
        return toUpdateMemberListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, memberResponse);
    }
    UpdateMemberResponse toUpdateMemberListResponse(String code, String message, MemberResponse memberResponse);


    default DeleteMemberResponse mapperToDeleteMemberListResponse(MemberResponse memberResponse) {
        return toDeleteMemberListResponse(SuccessResponse.CODE, SuccessResponse.MESSAGE, memberResponse);
    }
    DeleteMemberResponse toDeleteMemberListResponse(String code, String message, MemberResponse memberResponse);


}
