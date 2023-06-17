package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetAlbumByIdCommand
        extends SafeAbstractCommand<Integer, AlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    @Override
    public void preExecute() {

    }
    @Override
    protected void execute() {

    }

    @Override
    public void postExecute() {

    }
}

