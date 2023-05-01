package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetAllAlbumListCommand
        extends SafeAbstractCommand<DefaultRequest, GetAllAlbumListCommand>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;

    public GetAllAlbumListCommand(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumService = albumService;
        this.albumMapper = albumMapper;
    }

    @Override
    public void preExecute() {
        log.info("GetAllAlbumListCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("GetAllAlbumListCommand - Execute");
    }

    @Override
    public void postExecute() {
        log.info("GetAllAlbumListCommand - PostExecute");
    }

}
