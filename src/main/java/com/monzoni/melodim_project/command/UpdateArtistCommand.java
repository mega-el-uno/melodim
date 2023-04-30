package com.monzoni.melodim_project.command;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.UpdateArtistResponse;
import com.monzoni.melodim_project.mapper.ArtistMapper;
import com.monzoni.melodim_project.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateArtistCommand
            extends SafeAbstractCommand<UpdateArtistRequest, UpdateArtistResponse>
            implements PreExecutorCommand, PostExecutorCommand {
    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @Autowired
    public UpdateArtistCommand(ArtistService artistService, ArtistMapper artistMapper) {
        this.artistService = artistService;
        this.artistMapper = artistMapper;
    }

    @Override
    public void preExecute() {

    }
    @Override
    protected void execute() {

    }

    @Override
    public void postExecute() {

    }

}
