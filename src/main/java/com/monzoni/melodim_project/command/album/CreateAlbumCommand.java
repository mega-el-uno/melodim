package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.album.CreateAlbumRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.CreateAlbumResponse;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class CreateAlbumCommand
        extends SafeAbstractCommand<CreateAlbumRequest, CreateAlbumResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;

    @Autowired
    public CreateAlbumCommand(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumService = albumService;
        this.albumMapper = albumMapper;
    }


    @Override
    public void preExecute() {
        log.info("createAlbumCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("createAlbumCommand - Execute");
        AlbumResponse albumResponse = albumService.saveNewAlbum(this.input);
        this.output = albumMapper.mapperToCreateAlbumResponse(albumResponse);
    }

    @Override
    public void postExecute() {
        log.info("createAlbumCommand - PostExecute");
        if(Utils.isNull(this.output.getAlbumResponse())){
            this.output.setAlbumResponse(new AlbumResponse());
        }
    }
}
