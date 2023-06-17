package com.monzoni.melodim_project.controller.member;

import com.monzoni.melodim_project.command.member.UpdateMemberCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.MemberConstant;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.dto.response.member.UpdateMemberResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = MemberConstant.TAG_NAME, description = MemberConstant.TAG_DESCRIPTION)
@RequestMapping(value = MemberConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class UpdateMemberController {
    private final UpdateMemberCommand updateMemberCommand;

    @ApiOperation(value = MemberConstant.TAG_UPDATE_MEMBER)
    @PutMapping(value = "/UpdateMember", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommonResponse<MemberResponse> updateMember(@Valid @RequestBody UpdateMemberRequest updateMemberRequest){
        updateMemberCommand.setInput(updateMemberRequest);
        (new SafeCommandExecutor<UpdateMemberRequest, MemberResponse>()).safeExecution(updateMemberCommand);
        return new CommonResponse<>(updateMemberCommand.getOutput());
    }
}
