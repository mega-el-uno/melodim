package com.monzoni.melodim_project.controller.member;

import com.monzoni.melodim_project.command.member.CreateMemberCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.MemberConstant;
import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.member.CreateMemberResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = MemberConstant.TAG_NAME, description = MemberConstant.TAG_DESCRIPTION)
@RequestMapping(value = MemberConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class CreateMemberController {

    private final CreateMemberCommand createMemberCommand;

    @PostMapping()
    @ApiOperation(value = MemberConstant.TAG_CREATE_MEMBER)
    CommonResponse<MemberResponse> createMember(@Valid @RequestBody CreateMemberRequest createMemberRequest){
        createMemberCommand.setInput(createMemberRequest);
        (new SafeCommandExecutor<CreateMemberRequest, MemberResponse>()).safeExecution(createMemberCommand);
        return new CommonResponse<>(createMemberCommand.getOutput());
    }
}
