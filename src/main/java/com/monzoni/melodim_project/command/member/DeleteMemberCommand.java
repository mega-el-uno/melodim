package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.member.DeleteMemberRequest;
import com.monzoni.melodim_project.dto.response.member.DeleteMemberResponse;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteMemberCommand
        extends SafeAbstractCommand<DeleteMemberRequest, DeleteMemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Autowired
    public DeleteMemberCommand(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;

    }
    @Override
    public void preExecute() {
        log.info("DeleteMemberCommand PreExecute");
    }

    @Override
    protected void execute() {
        log.info("DeleteMemberCommand Execute");
    }

    @Override
    public void postExecute() {
        log.info("DeleteMemberCommand PostExecute");
    }

}
