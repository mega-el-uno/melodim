package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.album.DeleteAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.DeleteAlbumResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteAlbumCommand
        extends SafeAbstractCommand<Integer, AlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;

    public DeleteAlbumCommand(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Override
    public void preExecute() {
        log.info("DeleteAlbumCommand PreExecute");
        if (!albumService.existAlbumById(this.input)) {
            throw new ProcessErrorException("The album with ID: " + this.input + " does not exist");
        }
    }

    @Override
    protected void execute() {
        log.info("DeleteAlbumCommand Execute");
        this.output = albumService.DeleteAlbum(this.input);

    }

    @Override
    public void postExecute() {
        log.info("DeleteAlbumCommand PostExecute");
        if (Utils.isNull(this.output)) {
            throw new ProcessErrorException("Failed to delete album");
        }
    }

}
