package com.monzoni.melodim_project.command.artist;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.artist.UpdateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.UpdateArtistResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.mapper.ArtistMapper;
import com.monzoni.melodim_project.service.ArtistService;
import com.monzoni.melodim_project.util.constant.ArtistType;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
        log.info("UpdateArtistCommand - PreExecute");
        if(!Utils.isNull(this.input.getType())){
            boolean isTypeValid = Arrays.stream(ArtistType.values())
                    .anyMatch(artistType ->
                            artistType.name().equalsIgnoreCase(this.input.getType().toUpperCase())
                    );
            if(!isTypeValid){
                throw new ProcessErrorException("The type to update a Artist is not valid");
            }
        }
    }
    @Override
    protected void execute() {
        log.info("UpdateArtistCommand - Execute");
        ArtistResponse artistResponse = artistService.updateArtist(this.input);
        this.output = artistMapper.mapperToUpdateArtistResponse(artistResponse);
    }

    @Override
    public void postExecute() {
        log.info("UpdateArtistCommand - PostExecute");
        if(Utils.isNull(this.output.getArtistResponse())){
            this.output.setArtistResponse(new ArtistResponse());
        }
    }

}
