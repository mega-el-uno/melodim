package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMemberCommand
        extends SafeAbstractCommand<Integer, MemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final MemberService memberService;

    @Override
    public void preExecute() {
        log.info("DeleteMemberCommand PreExecute");
        if (!memberService.existAlbumById(this.input)) {
            throw new ProcessErrorException("This Member with ID: " + this.input + " does not exist");
        }
    }

    @Override
    protected void execute() {
        log.info("DeleteMemberCommand Execute");
        this.output = memberService.deleteMember(this.input);
    }

    @Override
    public void postExecute() {
        log.info("DeleteMemberCommand PostExecute");
    }

}
