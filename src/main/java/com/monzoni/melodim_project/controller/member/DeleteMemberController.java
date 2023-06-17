package com.monzoni.melodim_project.controller.member;

import com.monzoni.melodim_project.command.member.DeleteMemberCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.MemberConstant;
import com.monzoni.melodim_project.dto.response.CommonResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = MemberConstant.TAG_NAME, description = MemberConstant.TAG_DESCRIPTION)
@RequestMapping(value = MemberConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class DeleteMemberController {

    private final DeleteMemberCommand deleteMemberCommand;

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = MemberConstant.TAG_DELETE_MEMBER)
    CommonResponse<MemberResponse> deleteMember(@PathVariable Integer id) {
        deleteMemberCommand.setInput(id);
        (new SafeCommandExecutor<Integer, MemberResponse>()).safeExecution(deleteMemberCommand);
        return new CommonResponse<>(deleteMemberCommand.getOutput());
    }
}
