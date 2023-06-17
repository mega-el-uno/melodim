package com.monzoni.melodim_project.command.song;

import com.monzoni.melodim_project.command.spec.PostExecutorCommand;
import com.monzoni.melodim_project.command.spec.PreExecutorCommand;
import com.monzoni.melodim_project.command.spec.SafeAbstractCommand;
import com.monzoni.melodim_project.dto.request.song.CreateSongRequest;
import com.monzoni.melodim_project.dto.response.song.SongResponse;
import com.monzoni.melodim_project.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateSongCommand
        extends SafeAbstractCommand<CreateSongRequest, SongResponse>
        implements PreExecutorCommand, PostExecutorCommand {

    private final SongService songService;

    @Override
    public void preExecute() {
        log.info("CreateSongCommand - PreExecute");
    }

    @Override
    protected void execute() {
        log.info("CreateSongCommand - Execute");
        this.output = songService.saveNewSong(this.input);
    }

    @Override
    public void postExecute() {
        log.info("CreateSongCommand - PostExecute");
    }

}
