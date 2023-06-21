package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.service.AlbumService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetAlbumByIdCommand
        extends SafeAbstractCommand<Integer, AlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;

    @Override
    public void preExecute() {
        log.info("GetAlbumByIdCommand PreExecute");
        if (Utils.isNull(this.input)) {
            throw new ProcessErrorException("The id cannot be null");
        }
    }

    @Override
    protected void execute() {
        log.info("GetAlbumByIdCommand Execute");
        this.output = albumService.getAlbumById(this.input);
    }

    @Override
    public void postExecute() {
        log.info("GetAlbumByIdCommand PostExecute");
    }
}

