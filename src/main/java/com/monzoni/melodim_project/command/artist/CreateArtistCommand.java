package com.monzoni.melodim_project.command.artist;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.artist.CreateArtistRequest;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.dto.response.artist.CreateArtistResponse;
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
        log.info("CreateArtistCommand PreExecute");
        if (!Utils.isNull(this.input.getType())) {
            boolean isTypeValid = Arrays.stream(ArtistType.values())
                    .anyMatch(artistType ->
                            artistType.name().equalsIgnoreCase(this.input.getType().toUpperCase())
                    );
            if (!isTypeValid) {
                throw new ProcessErrorException("The type to create a new Artist is not valid");
            }
        } else {
            this.input.setType(ArtistType.ARTIST.name().toLowerCase());
        }
    }

    @Override
    protected void execute() {
        log.info("CreateArtistCommand Execute");
        ArtistResponse artistResponse = artistService.saveNewArtist(this.input);
        this.output = artistMapper.mapperToCreateArtistResponse(artistResponse);
    }

    @Override
    public void postExecute() {
        log.info("CreateArtistCommand PostExecute");
        if (Utils.isNull(this.output.getArtistResponse())) {
            this.output.setArtistResponse(new ArtistResponse());
        }
    }
}
