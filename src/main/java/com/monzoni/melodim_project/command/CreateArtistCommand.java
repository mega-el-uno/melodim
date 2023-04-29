package com.monzoni.melodim_project.command;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.CreateArtistRequest;
import com.monzoni.melodim_project.dto.response.ArtistResponse;
import com.monzoni.melodim_project.dto.response.CreateArtistResponse;
import com.monzoni.melodim_project.mapper.ArtistMapper;
import com.monzoni.melodim_project.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateArtistCommand
        extends SafeAbstractCommand<CreateArtistRequest, CreateArtistResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @Autowired
    public CreateArtistCommand(ArtistService artistService, ArtistMapper artistMapper) {
        this.artistService = artistService;
        this.artistMapper = artistMapper;
    }

    @Override
    public void preExecute() {

    }
    @Override
    protected void execute() {
        ArtistResponse artistResponse = artistService.saveNewArtist(this.input);
        this.output = artistMapper.mapperToCreateArtistResponse(artistResponse);
    }

    @Override
    public void postExecute() {

    }


}
