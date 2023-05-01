package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.dto.response.member.UpdateMemberResponse;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.service.MemberService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateMemberCommand
        extends SafeAbstractCommand<UpdateMemberRequest, UpdateMemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {
    private final MemberService memberService;
    private final MemberMapper memberMapper;
    @Autowired
    public UpdateMemberCommand(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @Override
    public void preExecute() {
        log.info("GetAllMemberListCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("GetAllMemberListCommand - Execute");

    }

    @Override
    public void postExecute() {
        log.info("GetAllMemberListCommand - PostExecute");
        if(Utils.isNull(this.output.getMemberResponse())){
            this.output.setMemberResponse(new MemberResponse());
        }
    }
}
