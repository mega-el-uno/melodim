package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.member.UpdateMemberRequest;
import com.monzoni.melodim_project.dto.response.member.MemberResponse;
import com.monzoni.melodim_project.dto.response.member.UpdateMemberResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.MemberMapper;
import com.monzoni.melodim_project.service.ArtistService;
import com.monzoni.melodim_project.service.MemberService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateMemberCommand
        extends SafeAbstractCommand<UpdateMemberRequest, MemberResponse>
        implements PreExecutorCommand, PostExecutorCommand {
    private final MemberService memberService;
    private final ArtistService artistService;

    @Override
    public void preExecute() {
        log.info("GetAllMemberListCommand - PreExecute");
        if(!Utils.isNull(this.input.getArtistId())){
            if(!artistService.isArtistIdExist(this.input.getArtistId())){
                throw new ProcessErrorException("The artist with ID: "+this.input.getArtistId()+" does not exist");
            }
        }
    }

    @Override
    protected void execute() {
        log.info("GetAllMemberListCommand - Execute");
        this.output = memberService.updateMember(this.input);
    }

    @Override
    public void postExecute() {
        log.info("GetAllMemberListCommand - PostExecute");
        if(Utils.isNull(this.output)){
            throw new ProcessErrorException("Filed to update member");
        }
    }
}
