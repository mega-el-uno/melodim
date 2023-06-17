package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAlbumCommand
        extends SafeAbstractCommand<CreateAlbumRequest, AlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;

    @Override
    public void preExecute() {
        log.info("createAlbumCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("createAlbumCommand - Execute");
        this.output = albumService.saveNewAlbum(this.input);
    }

    @Override
    public void postExecute() {
        log.info("createAlbumCommand - PostExecute");
        if (Utils.isNull(this.output)) {
            throw new ProcessErrorException("Failed to create album");
        }
    }
}
