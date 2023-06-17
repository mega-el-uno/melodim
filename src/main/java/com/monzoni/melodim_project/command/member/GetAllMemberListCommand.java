package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.service.MemberService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class GetAllMemberListCommand
        extends SafeAbstractCommand<DefaultRequest, GetAllMemberListResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Autowired
    public GetAllMemberListCommand(MemberService memberService, MemberMapper memberMapper) {
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
        List<MemberResponse> memberResponseList = memberService.getAllMemberList();
        this.output = memberMapper.mapperToGetAllMemberListResponse(memberResponseList);
    }

    @Override
    public void postExecute() {
        log.info("GetAllMemberListCommand - PostExecute");
        if (Utils.isNull(this.output.getMemberResponseList())) {
            this.output.setMemberResponseList(Collections.emptyList());
        }
    }
}
