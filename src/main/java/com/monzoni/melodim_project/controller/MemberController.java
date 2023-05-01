package com.monzoni.melodim_project.controller;

import com.monzoni.melodim_project.command.member.GetAllMemberListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final GetAllMemberListCommand getAllMemberListCommand;

    @GetMapping(value = "/GetAllMemberList", produces = MediaType.APPLICATION_JSON_VALUE)
    GetAllMemberListResponse getAllMemberList(){
        (new SafeCommandExecutor<DefaultRequest, GetAllMemberListResponse>()).safeExecution(getAllMemberListCommand);
        return getAllMemberListCommand.getOutput();
    }
}
