package com.monzoni.melodim_project.command.artist;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.artist.DeleteArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.DeleteArtistResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.ArtistMapper;
import com.monzoni.melodim_project.service.ArtistService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteArtistCommand
        extends SafeAbstractCommand<DeleteArtistRequest, DeleteArtistResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @Autowired
    public DeleteArtistCommand(ArtistService artistService, ArtistMapper artistMapper) {
        this.artistService = artistService;
        this.artistMapper = artistMapper;
    }

    @Override
    public void preExecute() {
        log.info("DeleteArtistCommand PreExecute");
        if (!artistService.isArtistIdExist(this.input.getId())) {
            throw new ProcessErrorException("The Artist with id: "+this.input.getId()+" does not exists");
        }
    }

    @Override
    protected void execute() {
        log.info("DeleteArtistCommand Execute");
        ArtistResponse artistResponse = artistService.deleteArtist(this.input);
        this.output = artistMapper.mapperToDeleteArtistResponse(artistResponse);
    }

    @Override
    public void postExecute() {
        log.info("DeleteArtistCommand PostExecute");
        if(Utils.isNull(this.output.getArtistResponse())){
            this.output.setArtistResponse(new ArtistResponse());
        }
    }

}
