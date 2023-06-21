package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.service.MemberService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetMemberByIdCommand
        extends SafeAbstractCommand<Integer, MemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final MemberService memberService;

    @Override
    public void preExecute() {
        log.info("GetMemberByIdCommand PreExecute");
        if (Utils.isNull(this.input)) {
            throw new ProcessErrorException("The id cannot be null");
        }
    }

    @Override
    protected void execute() {
        log.info("GetMemberByIdCommand Execute");
        this.output = memberService.getMemberById(this.input);
    }

    @Override
    public void postExecute() {
        log.info("GetMemberByIdCommand PostExecute");
    }
}
