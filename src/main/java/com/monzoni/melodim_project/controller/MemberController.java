package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.member.CreateMemberCommand;
import com.monzoni.melodim_project.command.member.GetAllMemberListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import com.monzoni.melodim_project.dto.response.member.CreateMemberResponse;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final GetAllMemberListCommand getAllMemberListCommand;
    private final CreateMemberCommand createMemberCommand;

    @GetMapping(value = "/GetAllMemberList", produces = MediaType.APPLICATION_JSON_VALUE)
    GetAllMemberListResponse getAllMemberList(){
        (new SafeCommandExecutor<DefaultRequest, GetAllMemberListResponse>()).safeExecution(getAllMemberListCommand);
        return getAllMemberListCommand.getOutput();
    }
    @PostMapping(value = "/CreateMember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CreateMemberResponse createMember(@Valid @RequestBody CreateMemberRequest createMemberRequest){
        createMemberCommand.setInput(createMemberRequest);
        (new SafeCommandExecutor<CreateMemberRequest, CreateMemberResponse>()).safeExecution(createMemberCommand);
        return createMemberCommand.getOutput();
    }
}
