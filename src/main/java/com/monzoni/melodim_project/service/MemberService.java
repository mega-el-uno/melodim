package com.monzoni.melodim_project.service;

import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;

import java.util.List;

public interface MemberService {
    List<MemberResponse> getAllMemberList();
    MemberResponse saveNewMember(CreateMemberRequest createMemberRequest);
    MemberResponse updateMember(UpdateMemberRequest updateMemberRequest);

}
