package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.member.DeleteMemberRequest;
import com.monzoni.melodim_project.dto.response.member.DeleteMemberResponse;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMemberCommand
        extends SafeAbstractCommand<DeleteMemberRequest, MemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final MemberService memberService;

    @Override
    public void preExecute() {
        log.info("DeleteMemberCommand PreExecute");
        if(!memberService.existAlbumById(this.input.getId())){
            throw new ProcessErrorException("This Member with ID: " + this.input.getId() + " does not exist");
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
