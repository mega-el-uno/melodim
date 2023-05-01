package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.album.DeleteAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.DeleteAlbumResponse;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteAlbumCommand
        extends SafeAbstractCommand<DeleteAlbumRequest, DeleteAlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;

    public DeleteAlbumCommand(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumService = albumService;
        this.albumMapper = albumMapper;
    }

    @Override
    public void preExecute() {
        log.info("DeleteAlbumCommand PreExecute");
    }

    @Override
    protected void execute() {
        log.info("DeleteAlbumCommand Execute");
    }

    @Override
    public void postExecute() {
        log.info("DeleteAlbumCommand PostExecute");
    }

}
