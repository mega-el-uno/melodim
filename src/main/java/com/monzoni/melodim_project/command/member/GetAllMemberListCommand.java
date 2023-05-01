package com.monzoni.melodim_project.command.member;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.member.GetAllMemberListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetAllMemberListCommand
        extends SafeAbstractCommand<DefaultRequest, GetAllMemberListResponse>
        implements PreExecutorCommand, PostExecutorCommand {


    @Override
    protected void execute() {

    }

    @Override
    public void postExecute() {

    }

    @Override
    public void preExecute() {

    }
}
