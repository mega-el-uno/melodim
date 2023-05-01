package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.album.UpdateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.UpdateAlbumResponse;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateAlbumCommand
        extends SafeAbstractCommand<UpdateAlbumRequest, UpdateAlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;

    public UpdateAlbumCommand(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumService = albumService;
        this.albumMapper = albumMapper;
    }

    @Override
    public void preExecute() {
        log.info("UpdateAlbumCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("UpdateAlbumCommand - Execute");
        AlbumResponse albumResponse = albumService.UpdateAlbum(this.input);
        this.output = albumMapper.mapperToUpdateAlbumResponse(albumResponse);
    }

    @Override
    public void postExecute() {
        log.info("UpdateAlbumCommand - PostExecute");
        if (Utils.isNull(this.output.getAlbumResponse())) {
            this.output.setAlbumResponse(new AlbumResponse());
        }
    }

}
