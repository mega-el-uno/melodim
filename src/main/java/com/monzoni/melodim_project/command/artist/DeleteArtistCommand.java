package com.monzoni.melodim_project.command.artist;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.response.artist.ArtistResponse;
import com.monzoni.melodim_project.exception.ProcessErrorException;
import com.monzoni.melodim_project.service.ArtistService;
import com.monzoni.melodim_project.util.function.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteArtistCommand
        extends SafeAbstractCommand<Integer, ArtistResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final ArtistService artistService;

    @Override
    public void preExecute() {
        log.info("DeleteArtistCommand PreExecute");
        if (!artistService.isArtistIdExist(this.input)) {
            throw new ProcessErrorException("The Artist with id: " + this.input + " does not exists");
        }
    }

    @Override
    protected void execute() {
        log.info("DeleteArtistCommand Execute");
        this.output = artistService.deleteArtist(this.input);
    }

    @Override
    public void postExecute() {
        log.info("DeleteArtistCommand PostExecute");
        if (Utils.isNull(this.output)) {
            throw new ProcessErrorException("Filed to delete artist");
        }
    }

}
