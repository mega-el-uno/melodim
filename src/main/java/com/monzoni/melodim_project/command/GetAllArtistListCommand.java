package com.monzoni.melodim_project.command;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.GetAllArtistListRequest;
import com.monzoni.melodim_project.dto.response.GetAllArtistListResponse;
import org.springframework.stereotype.Service;

@Service
public class GetAllArtistListCommand
        extends SafeAbstractCommand<GetAllArtistListRequest, GetAllArtistListResponse>
        implements PreExecutorCommand, PostExecutorCommand {
    @Override
    protected void execute() {

    }

    @Override
    public void preExecute() {

    }

    @Override
    public void postExecute() {

    }
}
