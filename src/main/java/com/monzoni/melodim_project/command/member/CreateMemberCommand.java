package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.member.CreateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.CreateMemberResponse;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateMemberCommand
        extends SafeAbstractCommand<CreateMemberRequest, CreateMemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Autowired
    public CreateMemberCommand(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @Override
    public void preExecute() {
        log.info("CreateMemberCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("CreateMemberCommand - Execute");
    }

    @Override
    public void postExecute() {
        log.info("CreateMemberCommand - PostExecute");
    }
}
