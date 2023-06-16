package com.monzoni.melodim_project.controller.member;

import com.monzoni.melodim_project.command.member.CreateMemberCommand;
import com.monzoni.melodim_project.command.member.DeleteMemberCommand;
import com.monzoni.melodim_project.command.member.GetAllMemberListCommand;
import com.monzoni.melodim_project.command.member.UpdateMemberCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.request.member.DeleteMemberRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.CreateMemberResponse;
import com.monzoni.melodim_project.dto.response.member.DeleteMemberResponse;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import com.monzoni.melodim_project.dto.response.member.UpdateMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final GetAllMemberListCommand getAllMemberListCommand;
    private final CreateMemberCommand createMemberCommand;
    private final UpdateMemberCommand updateMemberCommand;
    private final DeleteMemberCommand deleteMemberCommand;

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
    @PutMapping(value = "/UpdateMember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UpdateMemberResponse updateMember(@Valid @RequestBody UpdateMemberRequest updateMemberRequest){
        updateMemberCommand.setInput(updateMemberRequest);
        (new SafeCommandExecutor<UpdateMemberRequest, UpdateMemberResponse>()).safeExecution(updateMemberCommand);
        return updateMemberCommand.getOutput();
    }
    @DeleteMapping(value = "/DeleteMember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeleteMemberResponse deleteMember(@Valid @RequestBody DeleteMemberRequest deleteMemberRequest){
        deleteMemberCommand.setInput(deleteMemberRequest);
        (new SafeCommandExecutor<DeleteMemberRequest, DeleteMemberResponse>()).safeExecution(deleteMemberCommand);
        return deleteMemberCommand.getOutput();
    }
}
