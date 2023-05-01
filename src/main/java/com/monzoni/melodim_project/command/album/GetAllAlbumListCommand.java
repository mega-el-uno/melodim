package com.monzoni.melodim_project.command.album;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.album.AlbumResponse;
import com.monzoni.melodim_project.dto.response.album.GetAllAlbumListResponse;
import com.monzoni.melodim_project.mapper.AlbumMapper;
import com.monzoni.melodim_project.service.AlbumService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class GetAllAlbumListCommand
        extends SafeAbstractCommand<DefaultRequest, GetAllAlbumListResponse>
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
        List<AlbumResponse> albumResponseList = albumService.getAllAlbumList();
        this.output = albumMapper.mapperToGetAllAlbumListResponse(albumResponseList);
    }

    @Override
    public void postExecute() {
        log.info("GetAllAlbumListCommand - PostExecute");
        if (Utils.isNull(this.output.getAlbumResponseList())){
            this.output.setAlbumResponseList(Collections.emptyList());
        }
    }

}
