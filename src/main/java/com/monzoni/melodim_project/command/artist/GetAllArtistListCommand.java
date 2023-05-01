package com.monzoni.melodim_project.command.artist;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.DefaultRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.GetAllArtistListResponse;
import com.monzoni.melodim_project.mapper.ArtistMapper;
import com.monzoni.melodim_project.service.ArtistService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class GetAllArtistListCommand
        extends SafeAbstractCommand<DefaultRequest, GetAllArtistListResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @Autowired
    public GetAllArtistListCommand(ArtistService artistService, ArtistMapper artistMapper) {
        this.artistService = artistService;
        this.artistMapper = artistMapper;
    }

    @Override
    public void preExecute() {
        log.info("GetAllArtistListCommand - PreExecute");

    }

    @Override
    protected void execute() {
        log.info("GetAllArtistListCommand - Execute");
        List<ArtistResponse> artistResponseList = artistService.getAllArtistList();
        this.output = artistMapper.mapperToGetAllArtistListResponse(artistResponseList);
    }

    @Override
    public void postExecute() {
        log.info("GetAllArtistListCommand - PostExecute");
        if (Utils.isNull(this.output.getArtistResponseList())) {
            this.output.setArtistResponseList(Collections.emptyList());
        }
    }
}
