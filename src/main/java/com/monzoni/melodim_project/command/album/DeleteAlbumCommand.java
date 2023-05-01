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
        if (!albumService.existAlbumById(this.input.getId())) {
            throw new ProcessErrorException("The album with ID: " + this.input.getId() + " does not exist");
        }
    }

    @Override
    protected void execute() {
        log.info("DeleteAlbumCommand Execute");
        AlbumResponse albumResponse = albumService.DeleteAlbum(this.input);
        this.output = albumMapper.mapperToDeleteAlbumResponse(albumResponse);
    }

    @Override
    public void postExecute() {
        log.info("DeleteAlbumCommand PostExecute");
        if (Utils.isNull(this.output.getAlbumResponse())) {
            this.output.setAlbumResponse(new AlbumResponse());
        }
    }

}
