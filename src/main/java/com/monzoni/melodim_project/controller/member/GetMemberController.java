package com.monzoni.melodim_project.controller.member;

import com.monzoni.melodim_project.command.member.GetAllMemberListCommand;
import com.monzoni.melodim_project.command.spec.SafeCommandExecutor;
import com.monzoni.melodim_project.controller.constant.MemberConstant;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = MemberConstant.TAG_NAME, description = MemberConstant.TAG_DESCRIPTION)
@RequestMapping(name = MemberConstant.BASE_PATH)
@RestController
@RequiredArgsConstructor
public class GetMemberController {
    private final GetAllMemberListCommand getAllMemberListCommand;

    @ApiOperation(value = MemberConstant.TAG_GET_MEMBER)
    @GetMapping(value = "/GetAllMemberList", produces = MediaType.APPLICATION_JSON_VALUE)
    GetAllMemberListResponse getAllMemberList(){
        (new SafeCommandExecutor<DefaultRequest, GetAllMemberListResponse>()).safeExecution(getAllMemberListCommand);
        return getAllMemberListCommand.getOutput();
    }
}
